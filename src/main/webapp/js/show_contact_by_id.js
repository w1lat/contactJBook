$('#btnShowContactById').click(function(event){
    var contactId = $('#contactId').val();
    $.get('GetContactByIdServlet',{
        id : contactId,}, function(responseText){
            $('#ajaxGetUserByIdResponse').html(responseText);
        });
    });