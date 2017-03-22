$(document).ready(function() {
    $('#btnShowAllContacts').click(function(event) {
        var name = $('#userName').val();
        $.get('GetUserServlet', {
            userName : name,
        }, function(responseText) {
            var responseText2 = responseText;
            $('#ajaxGetAllUsersServletResponse').html(responseText2);
        });
    });
});