$(document).ready(function () {
    "use strict";

    var $contentContainer = $('.content');
    var $templateContainer = $('#template');

    function getIdFromUrl() {
        var split = $(location).attr('pathname').split('/');
        return split[split.length - 1];
    }

    function getParamtersFromUrl() {
        var split = location.href.split('?');
        if(split.length === 1){
            return "";
        }
        return split[split.length - 1];
    }

    function renderTemplate(source) {
        var $template = $templateContainer.html();
        var compile = Handlebars.compile($template);
        var rendered = compile(source);
        var oldId = getIdFromUrl();
        var newId = source.station.id;
        var newHref = location.href.replace(oldId, newId);
        if(oldId !== newId) {
            history.pushState(null, null, newHref);
        }
        $('.row').show();
        $contentContainer.html(rendered);
    }

    function handleError(jqXHR, textStatus, errorThrown) {
        $('.row').hide();
        Materialize.toast("Beim Laden der Abfahrtsdaten ist ein Fehler aufgetreten.", 15 * 1000);
        console.error("An error occurred while fetching data: " + textStatus + ", " + errorThrown + ".")
    }

    function startAjax(id, parameters) {
        var url = "/api/departures/" + id;
        if(parameters) {
            url += "?" + parameters;
        }
        $.ajax({
            url: url,
            success: renderTemplate,
            error: handleError
        });
    }

    function ajaxLoop() {
        startAjax(getIdFromUrl(), getParamtersFromUrl());
        setTimeout(ajaxLoop, 30 * 1000);
    }

    ajaxLoop();
});