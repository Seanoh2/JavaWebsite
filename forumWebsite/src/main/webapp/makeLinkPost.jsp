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
    </head>
    <body>
        <form action="FrontController" method="post" id="makeLinkPost">
            <input type="hidden" value="login" name="action">
            <input type="text" id="title" placeholder="title"/>
            <br>
            <input type="content" id="content" placeholder="content"/>
            <br>
            <button type="submit" value="submit"/>
        </form>
    </body>
</html>
