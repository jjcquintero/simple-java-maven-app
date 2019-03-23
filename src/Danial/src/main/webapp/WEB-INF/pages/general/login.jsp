<%--
  Created by IntelliJ IDEA.
  User: prakhash
  Date: 25/08/15
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="resources/login_page_styles/css/style.css">
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script src="resources/login_page_styles/js/index.js"></script>
</head>
<body>
<body>
<div class="wrapper">
  <div class="container">
    <h1>Welcome</h1>

    <form class="form" action="j_spring_security_check" method="post">
      <input type="text" name="username" placeholder="Username">
      <input type="password" name="password" placeholder="Password">
      <button type="submit" id="login-button">Login</button>
    </form>
  </div>

  <ul class="bg-bubbles">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
  </ul>
</div>
</body>
</body>
</html>
