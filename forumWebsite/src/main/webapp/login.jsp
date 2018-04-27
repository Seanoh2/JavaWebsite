<%-- 
    Document   : login
    Created on : 14-Feb-2018, 20:29:53
    Author     : tomwarren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <link rel="stylesheet" type="text/css" href="Style/login.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        
         <%@include file="header.jsp" %>

    </head>
    <body>
        <form action="FrontController" method="post" id="loginForm">
            <input type="hidden" value="login" name="action">
            
            <h2 id="loginTitle"> Login </h2>
            <input type="text" name="email" id="txtEmail" placeholder="email address">
            <br>
            <input type="password" name="password" id="txtPassword" placeholder="password">
            <br><br>
            <input type="submit" value="Login" class="submitButton" id="loginButton">
        </form>
        <a href="recoverPassword.jsp">Recover password</a>
    </body>
</html>
