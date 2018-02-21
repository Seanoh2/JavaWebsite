<%-- 
    Document   : games
    Created on : 20-Feb-2018, 21:55:29
    Author     : tomwa
--%>

<%@page import="DTOS.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.PostDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>/games/</title>
        
        <link rel="stylesheet" type="text/css" href="../Style/games.css">
        <link rel="stylesheet" type="text/css" href="../Style/siteWide.css">

        
         <%@include  file="/header.html" %>
    </head>
    <body>
        
        <div id="spacing"/>
        
        <% 
            PostDAO postdao = new PostDAO("forumdatabase");
            ArrayList <Post> posts = postdao.getPostsByForum(1);
        
            for (Post post : posts) {
         %>     
                <div class="postContainer">
                    <a class="title" href="../comments.jsp?<%=post.getPostID()%>"><%=post.getTitle()%></a>
                    <p class="content"> <%=post.getContent()%> </p>
                    <a href="../profile.jsp?<%=post.getPoster().getUserID()%>" class="op"> <%=post.getPoster().getFirstName() + " " + post.getPoster().getLastName()%> <a/>
                    <p class="score"> <%=post.getScore()%> </p>
                    <div id="rating">
                        <button type="button" class="plus"> &#x2b; </button>
                        <button type="button" class="minus"> &#8722; </button>
                    </div>
                </div>
           <% } %>
        
    </body>
</html>
