<%-- 
    Document   : boards
    Created on : 10-Feb-2018, 14:34:34
    Author     : tomwa
--%>

<%@page import="DTOS.Post"%>
<%@page import="DAO.PostDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTOS.Forum"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ForumDAO"%>
<%  ForumDAO forumDAO = new ForumDAO("forumDatabase");
    PostDAO postDAO = new PostDAO("forumDatabase");
    ArrayList<Forum> forums = forumDAO.getAllForums();
    ArrayList<Post> posts = postDAO.getAllPosts();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Boards</title>

        <link rel="stylesheet" type="text/css" href="Style/boards.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        
         <%@include  file="header.html" %>
    </head>
    <body>

        <div id="container">            
            <% for (Forum forum : forums) {%>
            <div id="<%=forum.getTitle()%>">
                <% for (Post filter : posts) {
                        if (filter.getForumID() == forum.getForumID()) {  
                            if(filter.isIsLink()) { %>
                            <a href="<%=filter.getContent()%>"><%=filter.getTitle()%></a>
                          <% } else { %>
                                
                <% }
                     }
                        } %>
            </div>
            <% }%>
        </div>

    </body>
</html>
