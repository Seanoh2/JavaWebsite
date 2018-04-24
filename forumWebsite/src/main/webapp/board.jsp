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
        
        <link rel="stylesheet" type="text/css" href="Style/board.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        <% 
            int id = Integer.parseInt(request.getParameter("ID"));
            ForumDAO forumdao = new ForumDAO("forumdatabase");
            PostDAO postdao = new PostDAO("forumdatabase");
            Forum f1 = forumdao.getForumByID(id);
        %>
        
        <div id="titleArea">
            <% String title = f1.getTitle();%>
            <h1><%=(title.substring(0,1).toUpperCase() + title.substring(1))%></h1>
            
        </div>
        
        <% 
            
            ArrayList <Post> posts = postdao.getPostsByForum(id);
            Forum forum = forumdao.getForumByID(id);
        %>
        <title>/<%= forum.getTitle() %>/</title>
        
        
    </head>
        <body>
            <%@include  file="header.jsp" %>
        
        <div id="spacing"/>
        
        <% 
            
        
            for (Post post : posts) {
         %>     
                <div class="postContainer">
                    <a class="title" href=" comments.jsp?ID=<%=post.getPostID()%>"><%=post.getTitle()%></a>
                    <p class="content"> <%=post.getContent()%> </p>
                    <a href="../profile.jsp?<%=post.getPoster().getUserID()%>" class="op"> <%=post.getPoster().getFirstName() + " " + post.getPoster().getLastName()%> </a>
                    <div class="rating">
                        <button type="button" class="plus"> &#x2b; </button>
                        <button type="button" class="minus"> &#8722; </button>
                    </div>
                </div>
           <% } %>
           
           <div id="buttonContainer">
                 <form action="makeTextPost.jsp" method="post" id="buttonCreateForm">
                    <input type="hidden" value="<%=id%>" name="forumID">
                    <input type="submit"  id="btnTextPost" value="Create new text post">
                    
                </form>
                    <button type="button" id="btnLinkPost" value="Create new link post" onclick="window.location.href = 'makeLinkPost.jsp'"> Make new link post </button>
           </div>
        
    </body>
</html>
