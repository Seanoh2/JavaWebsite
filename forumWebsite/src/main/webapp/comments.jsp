<%-- 
    Document   : Comments
    Created on : 15-Feb-2018, 14:01:46
    Author     : Seanoh
--%>

<%@page import="DTOS.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTOS.Post"%>
<%@page import="DAO.PostDAO"%>
<%@page import="DAO.CommentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        
        <%@include  file="header.html" %>
        
        <%PostDAO postdao = new PostDAO("forumdatabase");%>
        <%Post currentPost = postdao.getPostByID(Integer.parseInt(request.getParameter("postID")));%>
        <%CommentDAO commentdao = new CommentDAO("forumdatabase");%>
        <%ArrayList<Comment> comments = commentdao.getCommentsByPostID(Integer.parseInt(request.getParameter("postID")));%>
        
        <title><%=currentPost.getTitle()%></title>
        
        <% for(Comment comment : comments) { %>
        <% if(comment.getReceiver() == )
            <div class="comment">
                
            </div>
        <% } %>
    </head>
    <body>
    </body>
</html>
