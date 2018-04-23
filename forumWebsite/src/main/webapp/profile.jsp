<%-- 
    Document   : profile.jsp
    Created on : 10-Feb-2018, 14:01:40
    Author     : tomwa
--%>

<%@page import="DTOS.Message"%>
<%@page import="DAO.MessageDAO"%>
<%@page import="DTOS.Comment"%>
<%@page import="DAO.CommentDAO"%>
<%@page import="DTOS.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.PostDAO"%>
<%@page import="DAO.UserDAO"%>
<%@page import="DTOS.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>

        <link rel="stylesheet" type="text/css" href="Style/myProfile.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel="stylesheet" type="text/css" href="Style/header.css">

        <%@include  file="header.jsp" %>

    </head>

    <body>

        <%
            User u1 = (User) session.getAttribute("user");
        %>

        <div id="info">
            <center>
                <h2 class="headings">Your Profile</h2>
                <br>
                <br>
                <p class="details"> Email address: <%=u1.getEmail()%> </p>
                <p class="details"> First name: <%=u1.getFirstName()%> </p>
                <p class="details"> Last name: <%=u1.getLastName()%> </p>
                <input type="submit" value="Update Details" id="updateDetails">
            </center>
        </div>
        
        
        
        <% PostDAO postdao = new PostDAO("forumdatabase");
            ArrayList<Post> posts = postdao.getPostsByUserID(u1.getUserID());
        %>

        <div id="posts">
            <center><h2 class="headings">Your posts</h2></center>
            <% for (Post post : posts) {%>
            <a class="comment" href="comments.jsp?ID=<%=post.getPostID()%>"><%=post.getTitle()%></a>
            <br>
            <br>
            <% } %>


        </div>

        <% MessageDAO messagedao = new MessageDAO("forumdatabase");
            ArrayList<Message> messages = messagedao.getMessagesBySender(u1.getUserID());
        %>

        <div id="messages">
            <% for (Message message : messages) {%>
            <p><%=message.getReciever().getFirstName()%><p>
            <p><%=message.getContent()%></p>
            <% }%>
        </div>

    </body>
</html>
