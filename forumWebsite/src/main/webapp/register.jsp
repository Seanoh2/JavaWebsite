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
        
        <link rel="stylesheet" type="text/css" href="Style/register.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        
         <%@include  file="header.html" %>
        
    </head>
    <body>
        <form action="FrontController" method="post" id="container">
            <input type="hidden" value="register" name="action">
            <input type="text" name="email" placeholder="email" class="txtField">
            <br>
            <input type="text" name="password" placeholder="password" class="txtField">
            <br>
            <input type="text" name="firstName" placeholder="first name" class="txtField">
            <br>
            <input type="text" name="lastName" placeholder="last name" class="txtField">
            <br><br>
            <input type="submit" value="Register" class="submitButton">
        </form>
        
    </body>
</html>
