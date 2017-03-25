    $('#btnCreateContact').click(function(event) {
        var name = $('#userName').val();
        var lastName = $('#userLastName').val();
        var group = $('#userGroup').val();
        var number = $('#userNumber').val();
        var email = $('#userEmail').val();
        var birth = $('#userBirthday').val();
        $.get('CreateNewContactServlet', {
            userName : name,
            userLastName : lastName,
            userGroup : group,
            userNumber : number,
            userEmail : email,
            userBirthday : birth,
        }, function(responseText) {
            var responseText2 = "<h2>Created contact</h2>";
            responseText2 += responseText;
            $('#ajaxGetAllUsersServletResponse').hide();
            $('#ajaxCreateContactServletResponse').show();
            $('#ajaxCreateContactServletResponse').html(responseText2);
        });
});