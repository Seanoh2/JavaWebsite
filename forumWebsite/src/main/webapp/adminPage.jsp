<%-- 
    Document   : adminPage
    Created on : 27-Apr-2018, 17:52:56
    Author     : Sean
--%>

<%@page import="DTOS.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <%
            UserDAO userdao = new UserDAO("forumdatabase");
            ArrayList<User> userList = userdao.getAllUsers();
        %>
        <table>
            <tr>
                <th>UserID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Admin?</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            
        <% for(User user : userList) { %>
        <tr>
            <td><%=user.getUserID()%></td>
            <td><%=user.getFirstName()%></td>
            <td><%=user.getLastName()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=user.getIsAdmin()%></td>
            <td>
                <form action="FrontController" method="post">
                    <input type="hidden" name="userID" value="<%=user.getUserID()%>">
                    <input type="hidden" name="action" value="updateUser">
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>
                <form action="FrontController" method="post">
                    <input type="hidden" name="userID" value="<%=user.getUserID()%>">
                    <input type="hidden" name="action" value="deleteUser">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>       
        <% } %>
        </table>
    </body>
</html>
