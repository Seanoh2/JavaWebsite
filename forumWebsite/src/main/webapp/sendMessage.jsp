<%-- 
    Document   : home
    Created on : 09-Feb-2018, 21:52:12
    Author     : Sean
--%>
<%@page import="DTOS.User"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Home </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" type="text/css" href="Style/sendMessage.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel="stylesheet" type="text/css" href="Style/header.css">
        

        <%@include  file="header.jsp" %>
        <%
            User u1 = (User) session.getAttribute("user");
        %>

    </head>
    <body>
        <div id="messageContainer">
            <h2 id="messageHeader"> Send message </h2>
            <form action="FrontController" method="post" id="sendMessage">
                <input type="hidden" value="sendMessage" name="action">
                <input type="number" name="rUserID" id="sUserID" placeholder="Please enter userID...">
                <br>
                <input type="text" name="content" id="content" placeholder="Enter Message Here...">
                <br>
                <input type="hidden" value="1" name="type">
                <input type="hidden" value="<%=u1.getUserID()%>" name="sUserID">
                <br><br>
                <input type="submit" value="Send" class="submitButton" id="btnSendMessage">
            </form>
        </div>
    </body>
</html>
