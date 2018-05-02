<%-- 
    Document   : logoutConfirm
    Created on : 27-Apr-2018, 17:33:53
    Author     : tomwa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
        <link rel="stylesheet" type="text/css" href="Style/logout.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
    </head>
    <body>
        <div id="logContainer">
            <center><h1 id="messageLog">Are you sure you want to log out?</h1></center>

            <center>
                <button type="button" class="logControl" value="No" onclick="window.location.href = 'profile.jsp'">No</button>
                <button type="button" class="logControl" value="Yes" onclick="<%session.removeAttribute("user");%>window.location.href = 'home.jsp'">Yes</button>
            </center>
        </div>
    </body>
</html>
