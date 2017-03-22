<%@ page import="vi.talya.model.Contact"%>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>All Contacts</title>
</head>
  <body>
    <% Set<Contact> contacts = (Set<Contact>)request.getAttribute("contacts");%>
    <% for(Contact contact : contacts){%>
      <ul>
        <li>
          id: <%= contact.getId()%>
        </li>
        <li>
          name: <%= contact.getName()%>
        </li>
      </ul>
    <% }%>
  </body>
</html>
