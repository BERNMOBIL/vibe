$(document).ready(function () {
    "use strict";

    var $templateContainer = $('.content');

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
        var $template = $('#template').html();
        var compile = Handlebars.compile($template);
        var rendered = compile(source);
        var oldId = getIdFromUrl();
        var newId = source.station.id;
        var newHref = location.href.replace(oldId, newId);
        history.pushState(null, null, newHref);
        $templateContainer.html(rendered);
    }

    function handleError(jqXHR, textStatus, errorThrown) {
        //TODO: do fancy error
        $templateContainer.html("An Error occured");
        console.error(textStatus);
        console.error(errorThrown);
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