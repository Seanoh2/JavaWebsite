/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import DAO.UserDAO;
import DTOS.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author grahamm
 */
public class LoginUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        // Get the information entered into the form by the user
        // Get the parameters from the previous page       
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //now you have the information confrim its valid information
        if (email != null && password != null && !email.equals("")) {
            //Call your DAO method 
            UserDAO userDao = new UserDAO("librarydatabase");
            User u = userDao.login(email, password);
            HttpSession session = request.getSession();

            if (u != null) {
                session.setAttribute("user", u);
                forwardToJsp = "home.jsp";
            } else {
                String errorMessage = "Invalid credentials.";
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }
        }
        return forwardToJsp;
    }

}
