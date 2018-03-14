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
    </head>
    <body>
        <%@include  file="header.html" %>

        <%PostDAO postdao = new PostDAO("forumdatabase");%>
        <%Post currentPost = postdao.getPostByID(Integer.parseInt(request.getParameter("postID")));%>
        <%CommentDAO commentdao = new CommentDAO("forumdatabase");%>
        <%ArrayList<Comment> comments = commentdao.getCommentsByPostID(Integer.parseInt(request.getParameter("postID")));%>

        <title><%=currentPost.getTitle()%></title>

        <div class="Content">
            <% if (currentPost.isIsLink()) {%>
            <iframe width="420" height="315"
                    src="<%=currentPost.getContent()%>">
            </iframe> 
            <p><%=currentPost.getContent()%></p>
        </div>

        <% for (Comment comment : comments) { %>
        <% if (comment.getReceiver() == null) { %>
        <div class="comment">
            <% } else { %>
            <div class="response">
                <% }%>
                <a href="viewProfile.jsp?ID=<%=comment.getSender().getUserID()%>"><%=comment.getSender().getFirstName()%></a>
                <br/>
                <%=comment.getContent()%>
            </div>
            <% }%>
    </body>
</html>
