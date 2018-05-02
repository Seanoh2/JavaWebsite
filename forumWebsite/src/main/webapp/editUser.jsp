<%-- 
    Document   : login
    Created on : 16-Nov-2017, 15:53:10
    Author     : Seanoh
--%>

<%@page import="DTOS.User"%>
<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>

        
        <link rel="stylesheet" type="text/css" href="Style/editUser.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css"> 
        


        <%             UserDAO userdao = new UserDAO("forumdatabase");
            int userID = Integer.parseInt(request.getParameter("userID"));
            User edit = userdao.findUserByID(userID);
        %>

    </head>
    <body>
        <%@include  file="header.jsp" %>
        <form action="FrontController" method="post" id="containerEditUser">
            <input type="hidden" value="editUser" name="action">
            <br>
            <label> Email: </label>
            <input type="text" name="email" placeholder="email" value="<%=edit.getEmail()%>" class="txtField" id="editEmail">
            <br>
            <br>
            <label> First Name: </label>
            <input type="text" name="firstName" placeholder="first name" value="<%=edit.getFirstName()%>" class="txtField">
            <br>
            <br>
            <label> Last Name: </label>
            <input type="text" name="lastName" placeholder="last name" value="<%=edit.getLastName()%>" class="txtField">
            <br>

            <% if (edit.getIsAdmin()) { %>
            <p>Admin</p>
            <input type="radio" name="isAdmin" value="true" checked>
            <p>Not admin</p>
            <input type="radio" name="isAdmin" value="false">
            <% } else { %>
            <p>Yes</p>
            <input type="radio" name="isAdmin" value="true">
            <br>
            <p>No</p>
            <input type="radio" name="isAdmin" value="false" checked>
            <% }%>

            <br>
            <input type="hidden" name="userID" value="<%=userID%>">
            <br><br>
            <input type="submit" value="Edit" class="submitButton" id="editButton">
        </form>

    </body>
</html>
