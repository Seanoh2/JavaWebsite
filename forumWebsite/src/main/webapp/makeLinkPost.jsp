<%-- 
    Document   : makeLinkPost
    Created on : 15-Mar-2018, 13:40:53
    Author     : Tomwozzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Link Post</title>

        <link rel="stylesheet" type="text/css" href="Style/makeLinkPost.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
    </head>
    <body>
        <%@include  file="header.jsp" %>
        <div id="linkPostContainer">
            <form action="FrontController" method="post" id="makeLinkPost">
                <input type="hidden" value="login" name="action">
                <input type="text" id="title" placeholder="title"/>
                <br>
                <input type="content" id="content" placeholder="content"/>
                <br>
                <button type="submit" value="submit" id="submitLink"/> Submit </button>
            </form>
        </div>
    </body>
</html>
