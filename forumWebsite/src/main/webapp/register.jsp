<%-- 
    Document   : login
    Created on : 16-Nov-2017, 15:53:10
    Author     : Seanoh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="FrontController" method="post">
            <input type="hidden" value="register" name="action">
            Username:
            <input type="text" name="username">
            <br>
            Password:
            <input type="text" name="password">
            <br>
            first Name:
            <input type="text" name="firstName">
            <br>
            last Name:
            <input type="text" name="lastName">
            <br><br>
            <input type="submit" value="Register">
        </form>

        <footer>
            <br><br>
            <a href="login.html">Login</a>
            <br>
            <a href="register.jsp">Register</a>
            <br>
        </footer>
    </body>
</html>
