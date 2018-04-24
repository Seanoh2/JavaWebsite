<%-- 
    Document   : howTo
    Created on : 24-Apr-2018, 11:48:30
    Author     : tomwozzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Style/howTo.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>How to use Discover</title>
        
    </head>
    <body>
         <%@include  file="header.jsp" %>
        
        <div id="registrationExplained" class="helpContainer">
            <center>
                <h2>Registration</h2> 
                <p class="textHelp">
                    To use Discover, you must register an account with a valid email address.
                    This is needed due to our password recovery system that emails you in the event of account lock out.
                </p>
            </center>
        </div>
        <br>
    <div id="boardsExplained" class="helpContainer">
            <center>
                <h2>Boards</h2>
                <p class="textHelp">
                    A board is an area dedicated to a specific topic. Boards are where you make your posts.
                    When a board is loaded all posts associated with that board are loaded and are visible to you, the user.
                </p>
            </center>
        </div>
        <br> 
        <div id="postsExplained" class="helpContainer">
            <center>
                <h2>Posts</h2>
                <p class="textHelp">
                    A post is a user made piece of content, it can be either a link or a text based post.
                    A text post is a simple post containing only text with a title and content, where as a link post contains
                    a link that will redirect the user to another page.
                </p>
            </center>
        </div>
        <br>
         <div id="votingExplained" class="helpContainer">
            <center>
                <h2>Voting</h2>
                <p class="textHelp">
                    Users can rate other users posts while using our site to show appreciation for or post or rather if you 
                    do not like the post you can downvote to show your distaste of the post.
                </p>
            </center>
         </div>
         
    </body>
</html>
