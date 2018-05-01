<%-- 
    Document   : login
    Created on : 16-Nov-2017, 15:53:10
    Author     : Seanoh
--%>

<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>

        <link rel="stylesheet" type="text/css" href="Style/register.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">

        <%@include  file="header.jsp" %>
        <%             UserDAO userdao = new UserDAO("forumdatabase");
            int userID = Integer.parseInt(request.getParameter("userID"));
            User edit = userdao.findUserByID(userID);
        %>

    </head>
    <body>
        <form action="FrontController" method="post" id="container">
            <input type="hidden" value="editUser" name="action">
            <input type="text" name="email" placeholder="email" value="<%=edit.getEmail()%>" class="txtField">
            <br>
            <input type="text" name="firstName" placeholder="first name" value="<%=edit.getFirstName()%>" class="txtField">
            <br>
            <input type="text" name="lastName" placeholder="last name" value="<%=edit.getLastName()%>" class="txtField">
            <br>
            <% if (edit.getIsAdmin()) { %>
            <input type="checkbox" name="isAdmin" value="true" checked>
            <input type="checkbox" name="isAdmin" value="false">
            <% } else { %>
            <input type="checkbox" name="isAdmin" value="true">
            <input type="checkbox" name="isAdmin" value="false" checked>
            <% }%>
            <br>
            <input type="hidden" name="userID" value="<%=userID%>">
            <br><br>
            <input type="submit" value="Edit" class="submitButton" id="editButton">
        </form>

    </body>
</html>
