/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import DAO.CommentDAO;
import DAO.MessageDAO;
import DTOS.Comment;
import DTOS.Message;
import DTOS.Post;
import DTOS.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Seanoh
 */
public class SendCommentCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        CommentDAO messageDao = new CommentDAO("forumdatabase");
        Comment c = new Comment(
                        0,
                        new Post(
                                Integer.parseInt(request.getParameter("postID")),
                                new User(
                                        0,
                                        null,
                                        null,
                                        null,
                                        null,
                                        false
                                ),
                                0,
                                false,
                                null,
                                null
                        ),
                        new User(
                                Integer.parseInt(request.getParameter("senderID")),
                                null,
                                null,
                                null,
                                null,
                                false
                        ),
                        new User(
                                Integer.parseInt(request.getParameter("receiverID")),
                                null,
                                null,
                                null,
                                null,
                                false
                        ),
                        null,
                        request.getParameter("content")
                );
        
      
        if (messageDao.addComment(c)) {
            session.setAttribute("message", "Comment Added!");
            forwardToJsp = "comments.jsp?ID=" + request.getParameter("postID");
        } else {
            String errorMessage = "Error sending comment. Please try again";
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }

        return forwardToJsp;
    }
    
}
