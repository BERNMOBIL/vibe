$(document).ready(function() {
  "use strict";

  var hrefList = $(location).attr('pathname').split('/');
  var currentId = hrefList[hrefList.length - 1];

  function renderTemplate(source) {
    var template = $('#template').html();
    var compile = Handlebars.compile(template);
    var rendered = compile(source);
    $('.content').html(rendered);
  }

  function handleError(jqXHR, textStatus, errorThrown) {
    console.error(textStatus);
    console.error(errorThrown);
  }

  function startAjax(id) {
    $.ajax({
      url: "/api/departures/" + id,
      success: renderTemplate,
      error: handleError
    });
  }

  startAjax(currentId);
  setInterval(function() {
    startAjax(currentId);
  }, 30 * 1000);
});