<%-- 
    Document   : editPost
    Created on : 27-Apr-2018, 17:19:30
    Author     : tomwa
--%>

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
    </head>
    <body>
        
        <form action="FrontController" method="post" id="editTextPost">
                <input type="hidden" value="editTextPost" name="action">
                <input type="hidden" value="<%=request.getAttribute("postID")%>" name="forumID">
                <input type="text" id="title" placeholder="title" name="title"/>
                <br>
                <textarea rows="4" cols="50" id="content" placeholder="content" name="content"> </textarea> 
                <br>
                <button type="submit" value="submit" id="submitButton"> Submit </button>
            </form>
        
    </body>
</html>
