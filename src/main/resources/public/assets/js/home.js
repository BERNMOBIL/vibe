$(document).ready(function () {
    "use strict";
    Materialize.updateTextFields();

    $('#search-button').on('click', function() {
        var stopName = $('#stop_name').val();
        window.location.href = '/search/' + stopName;
    })

});