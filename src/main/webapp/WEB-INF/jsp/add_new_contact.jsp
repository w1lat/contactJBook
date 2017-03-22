<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>New contact adding</title>

  <script src="http://code.jquery.com/jquery-1.10.2.js"
          type="text/javascript"></script>

</head>
<body>
<h2>New Contact Creation</h2>
<div>
    Name: <input type="text" id="userName"/>

    Last name: <input type="text" id="userLastName"/>

    Contact group: <input type="text" id="userGroup"/>

    Phone number: <input type="text" id="userNumber"/>

    Email: <input type="text" id="userEmail"/>

    Birhtday: <input type="text" id="userBirthday"/>
</div>
<p style="text-align: center"><button id="btnCreateContact">Create contact</button></p>
<br>
<br>

<strong>Created Contact</strong>:
<div id="ajaxCreateContactServletResponse"></div>

<script src="js/show-contact-ajax.js" type="text/javascript"></script>
</body>
</html>