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
 * @author Sean
 */
public class SignUpUserCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        UserDAO userDao = new UserDAO("forumdatabase");
        HttpSession session = request.getSession();
        // Get the information entered into the form by the user
        // Get the parameters from the previous page       
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));
        User u = new User(0, firstName, lastName, email, password, isAdmin);

        User result = userDao.getUserByEmail(email);
        //now you have the information confrim its valid information
        if (result == null) {
            //Attempting to add User to DB
            boolean addUser = userDao.addUser(u);

            //If the user was added sucessfully, they are told so and than logged in automatically.
            if (addUser) {
                session.setAttribute("user", u);
                forwardToJsp = "profile.jsp";
            } else {
                //If any issues arised, they are not added and told so.
                String errorMessage = "Error adding user to database";
                session.setAttribute("errorMessage", errorMessage);
                forwardToJsp = "error.jsp";
            }

        } else {
            //If the email is in use, the user is told so and not added to DB, as emails need to be unique to allow login.
            String errorMessage = "Email already in use.";
            session.setAttribute("errorMessage", errorMessage);
            forwardToJsp = "error.jsp";
        }
        //Forward user to correct location 
        return forwardToJsp;
    }
}
