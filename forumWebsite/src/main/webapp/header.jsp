<%-- 
    Document   : header
    Created on : 15-Mar-2018, 11:09:41
    Author     : Tomwozzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" type="text/css" href="Style/header.css">
    <link rel="stylesheet" type="text/css" href="../Style/header.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<div id="header">

    <a href="home.jsp">
    
        <div id="logoArea">
            <img src="Media/logo.png" class="logo" alt="logo"/>
            
        </div>
    
    </a>
    
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

    <div id="aboutUs">
        <a href="howTo.jsp"> How to use Discover </a>
        <br>
        <br>
        <a href="aboutUs.jsp"> About Us </a>
    </div>
    
    <div id="misc">

        <a href="settings.jsp"> Settings </a>
        <br>
        <br>
        <a href="profile.jsp"> Profile </a>
        <br>
        <br>
        <a href="settings.jsp"> Logout </a>

    </div>

</div>

</html>