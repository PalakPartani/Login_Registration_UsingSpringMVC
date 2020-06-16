<%--
  Created by IntelliJ IDEA.
  User: Palak
  Date: 03-06-2020
  Time: 01:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">

</head>
<body>
<div class="login-box">
    <form action="registerProcess" method="get">
        <div style="font-family: Arial;font-size:25px;font-weight:700;text-align: center;padding:10px">
            Registration Page
        </div>
        <div>
            <input type="text" name="name" placeholder="Enter username" required>
        </div>
        <div>
            <input type="text" name="address" placeholder="Enter address" required>
        </div>
        <div>
            <input type="password" name="password" placeholder="Enter password" required>
        </div>
        <div>
            <input type="email" name="email" placeholder="Enter email" required>
        </div>

        <div>
            <input type="submit" name="submit" value="Register">
        </div>
        <div style="font-family: Arial;font-size:12px;font-weight: 700;text-align: center;padding: 30px">
            <a href="login">Login</a>
        </div>
    </form>
</div>
</body>
</html>