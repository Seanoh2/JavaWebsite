<%-- 
    Document   : board
    Created on : 15-Mar-2018, 11:06:30
    Author     : Tomwozzer
--%>

<%@page import="DTOS.Forum"%>
<%@page import="DAO.PostDAO"%>
<%@page import="DTOS.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ForumDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% 
            int id = Integer.parseInt(request.getParameter("ID"));
            ForumDAO forumdao = new ForumDAO("forumdatabase");
            PostDAO postdao = new PostDAO("forumdatabase");
            ArrayList <Post> posts = postdao.getPostsByForum(id);
            Forum forum = forumdao.getForumByID(id);
        %>
        <title><%= forum.getTitle() %></title>
        <link rel="stylesheet" type="text/css" href="../Style/games.css">
        <link rel="stylesheet" type="text/css" href="../Style/siteWide.css">
    </head>
        <body>
        
        <div id="spacing"/>
        
        <% 
            
        
            for (Post post : posts) {
         %>     
                <div class="postContainer">
                    <a class="title" href=" comments.jsp?ID=<%=post.getPostID()%>"><%=post.getTitle()%></a>
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
