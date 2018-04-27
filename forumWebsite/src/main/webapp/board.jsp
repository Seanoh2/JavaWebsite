<%-- 
    Document   : board
    Created on : 15-Mar-2018, 11:06:30
    Author     : Tomwozzer
--%>

<%@page import="java.util.HashMap"%>
<%@page import="DAO.RatingDAO"%>
<%@page import="DTOS.User"%>
<%@page import="DTOS.Forum"%>
<%@page import="DAO.PostDAO"%>
<%@page import="DTOS.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.ForumDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="JS/rating.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Style/board.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel=stylesheet" type="text/css" href="Style/header.css">
        <%
            int id = Integer.parseInt(request.getParameter("ID"));
            ForumDAO forumdao = new ForumDAO("forumdatabase");
            PostDAO postdao = new PostDAO("forumdatabase");
            RatingDAO ratingdao = new RatingDAO("forumdatabase");
            
            Forum f1 = forumdao.getForumByID(id);
            User user = (User)session.getAttribute("user");
            
            ArrayList<Post> posts = postdao.getPostsByForum(id);
            HashMap scores = ratingdao.getRatingsByForum();
        %>                
    <title>/<%= f1.getTitle()%>/</title>


</head>
<body>
    <%@include  file="header.jsp" %>

    <div id="titleArea">
        <% String title = f1.getTitle();%>
        <h1><%=(title.substring(0, 1).toUpperCase() + title.substring(1))%></h1>

    </div>

    <div id="buttonContainer">
        <form action="makeTextPost.jsp" method="post" id="buttonCreateForm">
            <input type="hidden" value="<%=id%>" name="forumID">
            <input type="submit"  id="btnTextPost" value="Create new text post">
        </form>
            <form action="makeLinkPost.jsp" method="post" id="buttonLink">    
                <button type="button" id="btnLinkPost" value="Create new link post" onclick="window.location.href = 'makeLinkPost.jsp'"> Make new link post </button>
            </form>
    </div>
    
    <div id="spacing"/>
    
    <br>

    <%
        for (Post post : posts) {
            int score = Integer.parseInt(scores.get(post.getPostID()).toString());
    %>     
    <div class="postContainer">
        <a class="title" href=" comments.jsp?ID=<%=post.getPostID()%>"><%=post.getTitle()%></a>
        <p class="content"> <%=post.getContent()%> </p>
        <a href="../profile.jsp?<%=post.getPoster().getUserID()%>" class="op"> <%=post.getPoster().getFirstName() + " " + post.getPoster().getLastName()%> </a>
        <div class="rating">
            <button type="button" class="ratingButton" data-post="<%=post.getPostID()%>" data-user="<%=user.getUserID()%>" value="1"> &#x2b; </button>
            <p id="ratingScore<%=post.getPostID()%>"><%=score%></p>
            <button type="button" class="ratingButton" data-post="<%=post.getPostID()%>" data-user="<%=user.getUserID()%>" value="-1"> &#8722; </button>
        </div>
    </div>
    <% }%>

    

</body>
</html>
