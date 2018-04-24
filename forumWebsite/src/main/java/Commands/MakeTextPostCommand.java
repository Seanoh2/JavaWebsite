/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import DAO.PostDAO;
import DTOS.Post;
import DTOS.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tomwozzer
 */
public class MakeTextPostCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        PostDAO postdao = new PostDAO("forumdatabase");
        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        User u1 = (User) session.getAttribute("user");
        int id = u1.getUserID();
        int forumID = Integer.parseInt(request.getParameter("forumID"));
        boolean isLink = false;
        
        Post post1 = new Post(0, u1, forumID, isLink, title, content);
        
        boolean addpost = postdao.addPost(post1);
        
        if(addpost){
                        
            forwardToJsp = "profile.jsp";
        } else {
                //If any issues arised, they are not added and told so.
                String errorMessage = "Error adding post to database";
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        
        return forwardToJsp;
    }
    
}
