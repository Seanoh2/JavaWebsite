<%-- 
    Document   : profile.jsp
    Created on : 10-Feb-2018, 14:01:40
    Author     : tomwa
--%>

<%@page import="DAO.UserDAO"%>
<%@page import="DTOS.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        
        <link rel="stylesheet" type="text/css" href="Style/profile.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        
         <%@include  file="header.html" %>
        
    </head>
    
    <body>
        
        <%
            User u1 = (User) session.getAttribute("user");
        %>
        
        <div id="info">
            <p> email address: <%=u1.getEmail()%> </p>
            <input type="button" value="change" class="change" id="btnEmail"/>
            <p> first name: <%=u1.getFirstName()%> </p>
            <input type="button" value="change" class="change" id="btnFirstName"/>
            <p> last name: <%=u1.getLastName()%> </p>
            <input type="button" value="change" class="change" id="btnLastName"/>
            <p> user identification number: <%=u1.getUserID()%> </p>
        </div>
        
        <div id="posts">
            
            <p> Posts made by user will be displayed here </p>
            
        </div>
        
        <div id="comments">
            
            <p> Comments made by user will be displayed here </p>
            
        </div>
        
    </body>
</html>
