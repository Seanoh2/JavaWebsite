<%-- 
Document   : Comments
Created on : 15-Feb-2018, 14:01:46
Author     : Seanoh
--%>

<%@page import="DTOS.User"%>
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
        <link rel="stylesheet" type="text/css" href="Style/header.css">
        <link rel="stylesheet" type="text/css" href="Style/comments.css">
    </head>
    <body>
        <%@include  file="header.jsp" %>

        <%PostDAO postdao = new PostDAO("forumdatabase");
        Post currentPost = postdao.getPostByID(Integer.parseInt(request.getParameter("ID")));
        CommentDAO commentdao = new CommentDAO("forumdatabase");
        ArrayList<Comment> comments = commentdao.getCommentsByPostID(Integer.parseInt(request.getParameter("ID")));
        %>

        <div id="postContainer">
            <p id="title"><%=currentPost.getTitle()%></p>

            <div id="content">
                <% if (currentPost.isIsLink()) {
                    if (currentPost.getContent().contains("watch?v") == true) {%>
                <p><%=currentPost.getContent()%></p>
                <iframe width="560" height="315" src="https://www.youtube.com/embed/<%=(currentPost.getContent()).substring((currentPost.getContent()).lastIndexOf('=')+1)%>"  frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
                    <% } else {%>
                <a href="<%=currentPost.getContent()%>" target="_blank"><%=currentPost.getContent()%></a>
                <% }
                } else { 
                %>
                <p><%=currentPost.getContent()%></p>
                <% User user1 = (currentPost.getPoster());%>
                <a href="viewProfile.jsp?ID="<%=currentPost.getPoster().getUserID()%> id="op">-<%=user1.getEmail()%></a>
                <% }%>
            </div>
            <div class="controlsContainer">
                <form action="sendComment.jsp" method="post" id="formPost">
                    <input type="hidden" value="<%=currentPost.getPostID()%>" name="postID">
                    <input type="submit" value="Post Comment" id="postComment" class="actionButton">
                </form>
                <%
                    User currentUser = (User) session.getAttribute("user");
                    if (currentUser.getUserID() == (currentPost.getPoster()).getUserID()) {
                        out.println("<form action='editPost.jsp' method='post' id='formEditPost'><input type='hidden' value=' + currentPost.getPostID() name='postID'><input type='submit' value='Edit' id='editPost' class='actionButton'> </form>");
                        out.println("<form action='deletePost.jsp' method='post' id='formDeletePost'><input type='hidden' value=' + currentPost.getPostID() name='postID'><input type='submit' value='Delete' id='deletePost' class='actionButton'> </form>");
                    }

                %>
            </div>   

        </div>

        <% for (Comment comment : comments) {
                if (comment.getReceiver() == null) {
        %>
        <% } else { %>
        <div class="response">
            <% }%>

            <p class="commentReply"><%=comment.getContent()%></p>
            <br/>
            <a class="sender" href="viewProfile.jsp?ID=<%=comment.getSender().getUserID()%>">-<%=comment.getSender().getFirstName()%></a>

        </div>
        <% }%>

    </body>
</html>
