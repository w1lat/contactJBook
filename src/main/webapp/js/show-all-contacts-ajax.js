$(document).ready(function() {
    $('#btnShowAllContacts').click(function(event) {
        var name = $('#userName').val();
        $.get('GetUsersServlet', {
            userName : name,
        }, function(responseText) {
            var responseText2 = responseText;
            $('#ajaxCreateContactServletResponse').hide();
            $('#ajaxGetAllUsersServletResponse').show();
            $('#ajaxGetAllUsersServletResponse').html(responseText2);
        });
    });
});