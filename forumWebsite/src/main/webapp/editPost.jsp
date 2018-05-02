<%-- 
    Document   : editPost
    Created on : 27-Apr-2018, 17:19:30
    Author     : tomwa
--%>

<%@page import="DTOS.Post"%>
<%@page import="DAO.PostDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit post</title>
        <link rel="stylesheet" type="text/css" href="Style/editPost.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        
        <%@include file="header.jsp" %>
        <%
            PostDAO postdao = new PostDAO("forumdatabase");
            Post p = postdao.getPostByID(Integer.parseInt(request.getParameter("postID")));
        %>
    </head>
    <body>
        
        <form action="FrontController" method="post" id="editTextPost">
                <input type="hidden" value="editTextPost" name="action">
                <input type="hidden" value="<%=p.getPostID()%>" name="postID">
                <input type="text" id="title" placeholder="title" name="title" value="<%=p.getTitle()%>"/>
                <br>
                <% if (Boolean.valueOf(p.isIsLink())) { %>
                <input type="url" name="content" id="contentLink" placeholder="Please enter URL" value="<%=p.getContent()%>">
                <% } else { %>
                <textarea rows="4" cols="50" id="content" placeholder="content" name="content"><%=p.getContent()%></textarea>
                <% }%>
                <br>
                <button type="submit" value="submit" id="submitButton"> Submit </button>
            </form>
        
    </body>
</html>
