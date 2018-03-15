<%-- 
    Document   : home
    Created on : 09-Feb-2018, 21:52:12
    Author     : Sean
--%>
<%@page import="DTOS.User"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Send Comment</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="Style/home.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">

        <%@include  file="header.jsp" %>
        <%
            User u1 = (User) session.getAttribute("user");
            int postID = Integer.parseInt(request.getParameter("postID"));
            
        %>

    </head>
    <body>
        <div id="container">
            <form action="FrontController" method="post" id="sendComment">
                <input type="hidden" value="sendComment" name="action">
                <input type="hidden" value="<%=postID%>" name="postID">
                <input type="hidden" value="0" name="receiverID">
                <input type="hidden" value="<%=u1.getUserID()%>" name="senderID">
                <br><br>
                <input type="submit" value="Send" class="submitButton">
            </form>
        </div>
    </body>
</html>
