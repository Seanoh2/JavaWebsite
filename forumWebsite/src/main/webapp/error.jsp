<%-- 
    Document   : error
    Created on : 21-Nov-2017, 16:36:02
    Author     : Seanoh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
    function goBack() {
        window.history.back();
    }
</script> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css"
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        
         <%@include  file="header.html" %>
    </head>
    <body>
        <h1><%=session.getAttribute("errorMessage")%></h1>
        <%session.removeAttribute("errorMessage");%>


        <button onclick="goBack()">Go Back</button>

        <footer>
            <br><br>
            <a href="login.html">Login</a>
            <br>
            <a href="register.jsp">Register</a>
            <br>
            <a href="myBlog.jsp">My Blog</a>
        </footer>

    </body>
</html>
