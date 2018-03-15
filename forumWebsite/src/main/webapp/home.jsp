<%-- 
    Document   : home
    Created on : 09-Feb-2018, 21:52:12
    Author     : Sean
--%>
<!DOCTYPE html>
<html>
    <head>
        <title> Home </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="Style/home.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        
         <%@include  file="header.jsp" %>

    </head>
    <body>
        <div id="container">
            <button class="button" id="login" onclick="window.location.href = 'login.jsp'"><span> Login </span></button>
            <button class="button" id="register" onclick="window.location.href = 'register.jsp'"><span> Register </span></button>
        </div>
    </body>
</html>
