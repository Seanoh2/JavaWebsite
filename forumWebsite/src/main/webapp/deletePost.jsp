<%-- 
    Document   : deletePost
    Created on : 27-Apr-2018, 17:19:37
    Author     : tomwa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete post</title>
        <link rel="stylesheet" type="text/css" href="Style/deletePost.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        
        <%@include file="header.jsp" %>
    </head>
    <body>
        <form action="FrontController" method="post" id="deletePost">
                <input type="hidden" value="deletePost" name="action">
                <input type="hidden" value="<%=request.getAttribute("postID")%>" name="forumID">
                <p> delete post? </p>
                <button type="submit" value="submit" id="submitButton"> Submit </button>
        </form>
    </body>
</html>
