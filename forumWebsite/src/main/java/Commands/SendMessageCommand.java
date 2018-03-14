/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import DAO.MessageDAO;
import DTOS.Message;
import DTOS.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sean
 */
public class SendMessageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        MessageDAO messageDao = new MessageDAO("forumdatabase");

        int sUserID = Integer.parseInt(request.getParameter("sUserID"));
        int rUserID = Integer.parseInt(request.getParameter("rUserID"));
        int type = Integer.parseInt(request.getParameter("type"));
        String content = request.getParameter("content");

        Message addMessage = new Message(
                0,
                new User(
                        sUserID,
                        null,
                        null,
                        null,
                        null,
                        false
                ),
                new User(
                        rUserID,
                        null,
                        null,
                        null,
                        null,
                        false
                ),
                type,
                null,
                content
        );

        if (messageDao.addMessage(addMessage)) {
            session.setAttribute("message", "Message sent!");
            forwardToJsp = "profile.jsp";
        } else {
            String errorMessage = "Error sending message. Please try again";
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }

        return forwardToJsp;
    }
}
