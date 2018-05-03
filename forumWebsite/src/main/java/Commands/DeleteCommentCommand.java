/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import DAO.CommentDAO;
import DAO.PostDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tomwozzer
 */
public class DeleteCommentCommand  implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        // Get the information entered into the form by the user
        // Get the parameters from the previous page       
        int commentID = Integer.parseInt(request.getParameter("commentID"));

        if (commentID != 0) {
            //Call your DAO method 
            CommentDAO commentdao = new CommentDAO("forumdatabase");
            if (commentdao.deleteComment(commentID)) {
                forwardToJsp = "profile.jsp";
            } else {
                String errorMessage = "Invalid credentials.";
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
