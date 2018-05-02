/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import DAO.PostDAO;
import DTOS.Post;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tomwozzer
 */
public class EditPostCommand implements Command{
     @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        // Get the information entered into the form by the user
        // Get the parameters from the previous page       
        int postid = Integer.parseInt(request.getParameter("postID"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        if (postid != 0) {
            //Call your DAO method 
            PostDAO postdao = new PostDAO("forumdatabase");
            Post p1 = postdao.getPostByID(postid);
            p1.setTitle(title);
            p1.setContent(content);
            
            if (postdao.editPost(p1)) {
                forwardToJsp = "comments.jsp?ID=" + p1.getPostID();
            } else {
                String errorMessage = "Invalid edit.";
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        } else {
            String errorMessage = "Not all information entered.";
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        return forwardToJsp;
    }
}