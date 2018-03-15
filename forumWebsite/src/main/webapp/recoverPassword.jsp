<%-- 
    Document   : recoverPassword
    Created on : 15-Dec-2017, 00:58:53
    Author     : Sean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recover Password</title>
        
        <link rel="stylesheet" type="text/css" href="Style/recoverPassword.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        
         <%@include  file="header.jsp" %>
    </head>
    <body>
    <center>
        <form id="recoveryForm" action="FrontController" method="post">
            <input type="hidden" value="passwordrecovery" name="action">
            <input id="email" placeholder="Please Enter email address" type="text" name="email" required>
            <br><br>
            <input id="submit" type="submit" value="Recover">
        </form>
    </center>
</body>
</html>
