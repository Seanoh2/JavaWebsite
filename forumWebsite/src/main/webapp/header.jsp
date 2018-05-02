<%-- 
    Document   : header
    Created on : 15-Mar-2018, 11:09:41
    Author     : Tomwozzer
--%>

<%@page import="DTOS.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" type="text/css" href="Style/header.css">
    <link rel="stylesheet" type="text/css" href="../Style/header.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<div id="header">
    
    <br>
    
        <div id="logoArea">
            <img src="Media/logo.png" class="logo" alt="logo"/>
            
        </div>
   
    
    <form id="searchArea">
        <input type="text" placeholder="search..." id="searchbar">
        <input type="button" id="btnSearch" value="Search"/>
    </form>

    <div id="linkContainer">
        <a href="board.jsp?ID=1" id="games"> /games/ </a>
        <a href="board.jsp?ID=4" id="music"> /music/ </a>
        <a href="board.jsp?ID=2" id="tech"> /tech/ </a>
        <a href="board.jsp?ID=3" id="movies"> /movies/ </a>
        <a href="board.jsp?ID=5" id="sports"> /sports/ </a>
    </div>
    
    <%
        User loggedIn = (User) session.getAttribute("user");
        out.println("<div id='nameContainer'>");
             if(loggedIn == null){
            
    %>
            <% out.println("<a href='login.jsp' class='accountLink'>login</a>");%>
            <br>
            <% out.println("<a href='register.jsp' class='accountLink'>register</a>");%>
            
    <% 
       } else{
            out.println("<p id='loggedIn'> Hello </p> <a href='profile.jsp' id='loggedInName'>" + loggedIn.getEmail() + "</a>");
        }

        if (loggedIn.getIsAdmin()){
            
        %>
        <a href="adminPage.jsp" class="adminLink">Admin Controls</a>
        
        <%
        }    
        %>
        
    
         
    </div>
    
    <div id="misc">
        <a href="howTo.jsp"> How to use Discover </a>
        <br>
        <a href="aboutUs.jsp"> About Us </a>
        <br>
        
        <%
          if(loggedIn != null){
              out.print("<a href='logoutConfirm.jsp'> Logout </a>");
          }      
        %>
    </div>

</div>

</html>
