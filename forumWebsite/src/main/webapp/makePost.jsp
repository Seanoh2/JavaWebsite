<%-- 
    Document   : makeTextPost
    Created on : 15-Mar-2018, 13:38:55
    Author     : Tomwozzer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="Style/textPost.css">
        <link rel="stylesheet" type="text/css" href="Style/siteWide.css">
        <link rel="stylesheet" type="text/css" href="Style/header.css">

        
        <title>Make Text Post</title>
         <%@include  file="header.jsp" %>
         <%String forumID = request.getParameter("forumID");%>
         <%String islink = request.getParameter("isLink");%>
    </head>
    
    <body>
        
       
        
        <div id="formBox">
            <form action="FrontController" method="post" id="makeTextPost">
                <input type="hidden" value="addPost" name="action">
                <input type="text" id="title" placeholder="title" name="title"/>
                <br>
                <% if(Boolean.valueOf(islink)) { %>
                 <textarea rows="4" cols="50" id="content" placeholder="content" name="content"> </textarea> 
                 <% } else { %>
                <input type="url" name="content" id="content" placeholder="Please enter URL">
                <% } %>
                <input type="hidden" value="<%=forumID%>" name="forumID">
                <input type="hidden" value="<%=islink%>" name="isLInk">
                <br>
                <button type="submit" value="submit" id="submitButton"> Submit </button>
            </form>
        </div>
    </body>
</html>
