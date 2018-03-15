<%-- 
    Document   : makeTextPost
    Created on : 15-Mar-2018, 13:38:55
    Author     : Tomwozzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="Style/textPost.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel="stylesheet" type="text/css" href="Style/header.css">

        
        <title>Make Text Post</title>
         <%@include  file="header.jsp" %>
    </head>
    
    <body>
        
       
        
        <div id="formBox">
            <form action="FrontController" method="post" id="makeTextPost">
                <input type="hidden" value="addPost" name="action">
                <input type="text" id="title" placeholder="title" name="title"/>
                <input type="hidden" value="<%=request.getParameter("forumID")%>" name="forumID">
                <br>
                <input type="content" id="content" placeholder="content" name="content"/>
                <br>
                <button type="submit" value="submit" id="submitButton"> Submit </button>
                <p> <%=request.getParameter("forumID")%></p>
            </form>
        </div>
    </body>
</html>
