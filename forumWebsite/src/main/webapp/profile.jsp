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
        
    </head>
    
    <body>
        
        <%
            User u1 = (User) session.getAttribute("user");
            UserDAO userdao = new UserDAO("forumdatabase");
            User loggedIn = userdao.getUserByEmail(u1.getEmail());
        %>
        
        <div id="container">
            <p> email address: <% out.println(u1.getEmail());%> </p>
            <p> first name: <% out.println(loggedIn.getFirstName()); %> </p>
            <p> last name: <% out.println(loggedIn.getLastName()); %> </p>
            <p> user identification number: <% out.println(loggedIn.getUserID()); %> </p>
        </div>
        
    </body>
</html>
