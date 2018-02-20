<%-- 
    Document   : Comments
    Created on : 15-Feb-2018, 14:01:46
    Author     : Seanoh
--%>

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
        
        <title></title>
    </head>
    <body>
    </body>
</html>
