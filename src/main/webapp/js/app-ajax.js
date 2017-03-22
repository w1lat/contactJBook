$(document).ready(function() {
    $('#userName').blur(function(event) {
        var name = $('#userName').val();
        $.get('GetUserServlet', {
            userName : name,
        }, function(responseText) {
            var responseText2 = responseText;
            $('#ajaxGetUserServletResponse').html(responseText2);
        });
    });
});