/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import DAO.ForumDAO;
import DAO.PostDAO;
import DAO.UserDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tomwozzer
 */
public class deletePostCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        // Get the information entered into the form by the user
        // Get the parameters from the previous page  
        int postID = Integer.parseInt(request.getParameter("postID"));

        if (postID != 0) {
            //Call your DAO method 
            PostDAO postdao = new PostDAO("forumdatabase");
            if (postdao.deletePost(postID)) {
                forwardToJsp = "deleteSuccess.jsp";
            } else {
                String errorMessage = "Delete not successful";
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        }
        return forwardToJsp;
    }
}