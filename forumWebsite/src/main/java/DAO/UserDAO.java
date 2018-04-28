/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Password;
import DTOS.User;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import interfaces.UserDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sami
 * @version 1.0
 * @since 14/10/17
 */
public class UserDAO extends DAO implements UserDAOInterface {

    public UserDAO(String databaseName) {
        super(databaseName);
    }

    /**
     * This will allow the user to call users by their first name and last name
     * Both variables must be exactly right, Case sensitive
     *
     * @param firstName parameter is used to find the user in the db.
     * @param lastName parameter is used to find the user in the db.
     * @return ArrayList with users from the db matching the first and last name
     * parameters
     */
    @Override
    public ArrayList<User> selectUserByUsername(String firstName, String lastName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        ArrayList<User> userList = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT * FROM users WHERE firstName = ? AND lastName = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            rs = ps.executeQuery();

            while (rs.next()) {
                u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));
                userList.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the selectUserByUsername() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the selectUserByUsername() method: " + e.getMessage());
            }
        }
        return userList;
    }

    /**
     * This will allow the user to call users by their name. This will check
     * first and last name, if the substring is inside. Case sensitive.
     *
     * @param name used to find a user if the first name or last name contains
     * this String
     * @return ArrayList with users from the database with a name containing the
     * name parameter
     */
    @Override
    public ArrayList<User> selectUserContainingName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        ArrayList<User> userList = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT * FROM users WHERE firstName LIKE ? OR lastName LIKE ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            ps.setString(2, "%" + name + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));
                userList.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the selectUserContainingName() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the selectUserByUsername() method: " + e.getMessage());
            }
        }
        return userList;
    }
    
    public ArrayList<User> getAllUsers() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        ArrayList<User> userList = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT * FROM users";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));
                userList.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllUsers() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllUsers() method: " + e.getMessage());
            }
        }
        return userList;
    }

    /**
     * This will check the database for a user with userID of the param and
     * return the user
     *
     * @param userID This Parameter is used to find a user with an id equal to
     * this parameter
     * @return User object which matches the ID of the param
     */
    public User findUserByID(int userID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            conn = getConnection();

            String query = "SELECT * FROM users WHERE userID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();

            if (rs.next()) {
                u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the findUserByID() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the findUserByID() method: " + e.getMessage());
            }
        }
        return u;
    }

    /**
     * This method will take input from the console and create a user object.
     *
     * @param u
     * @param user
     * @return boolean indicating if the add was executed or not.
     */
    @Override
    public boolean addUser(User u) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        Boolean result = null;

        try {
            conn = getConnection();
            String hashedPassword = Password.hashString(u.getPassword());
            String query = "INSERT INTO users VALUES (NULL, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, u.getFirstName());
            ps.setString(2, u.getLastName());
            ps.setString(3, u.getEmail());
            ps.setString(4, hashedPassword);
            ps.setBoolean(5, u.getIsAdmin());

            rs = ps.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Constraint Exception occurred: " + e.getMessage());
            // Set the rowsAffected to -1, this can be used as a flag for the display section
            rs = -1;

        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the addUser() method");
            }
        }
        if (rs > 0) {
            result = true;
        } else {
            result = false;
        }

        return result;

    }
    
    public boolean deleteUser(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        Boolean result = null;

        try {
            conn = getConnection();
            String query = "DELETE FROM users WHERE userID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Constraint Exception occurred: " + e.getMessage());
            // Set the rowsAffected to -1, this can be used as a flag for the display section
            rs = -1;

        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the deleteUser() method");
            }
        }
        if (rs > 0) {
            result = true;
        } else {
            result = false;
        }

        return result;

    }

    /**
     * This allows the user to login to the system with their email and
     * password. Email and Password are case sensitive.
     *
     * @param email Used to identify who is logging in.
     * @param password Used to confirm client is this user.
     * @return boolean result to if it was successful.
     */
    @Override
    public User login(String email, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = getConnection();

            String query = "SELECT * FROM users WHERE Email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next() && Password.checkPassword(password, rs.getString("Password"))) {
                u = new User();
                u.setUserID(rs.getInt("UserID"));
                u.setEmail(rs.getString("Email"));
                u.setPassword(rs.getString("Password"));
                u.setFirstName(rs.getString("FirstName"));
                u.setLastName(rs.getString("LastName"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the login method:");
            System.err.println("\t" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the login method:\n" + e.getMessage());
            }
        }
        return u;
    }

    /**
     * This will allow for a lookup of user in database. Only using single user
     * object as email needs to be unique.
     *
     * @param email Used to find user in database
     * @return User object with info if found.
     */
    @Override
    public User getUserByEmail(String email) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            con = getConnection();
            String query = "SELECT * FROM users WHERE Email = ?";
            ps = con.prepareStatement(query);

            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next()) {
                u = new User();
                u.setUserID(rs.getInt("UserID"));
                u.setFirstName(rs.getString("FirstName"));
                u.setLastName(rs.getString("LastName"));
                u.setEmail(rs.getString("Email"));
                u.setPassword(rs.getString("Password"));             
                u.setIsAdmin(rs.getBoolean("isAdmin"));
            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the getUserByEmail() method");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the getUserByEmail() method");
            }
        }

        return u;
    }

    /**
     * This will remove a user from the db User to be removed can't be an admin
     *
     * @param id to find user to be removed.
     * @return error code to indicate whether user was removed, user is an admin
     * or user does not exist.
     */
    public int removeUser(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        User temp = null;
        UserDAO userDAO = new UserDAO("librarydatabase");

        temp = userDAO.findUserByID(id);
        if (temp == null) {
            return 3;//user does not exist
        } else if (temp.getIsAdmin() == true) {
            return 2;//user is an admin
        } else {
            try {
                conn = getConnection();
                String query = "DELETE FROM users WHERE userID = ?";
                ps = conn.prepareStatement(query);

                ps.setInt(1, id);
                rs = ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Exception occured in the getUserByEmail() method");
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (conn != null) {
                        freeConnection(conn);
                    }
                } catch (SQLException e) {
                    System.out.println("Exception occured in the finally section in the removeTitle() method");
                }
            }
            //Indicates success
            return 1;
        }

    }

    public boolean updatePassword(String password, int userID) {
        Connection conn = null;
        PreparedStatement ps = null;
        EmailDAO emailDao = new EmailDAO("librarydatabase");
        int rs = 0;
        Boolean result = false;

        try {
            conn = getConnection();
            String query = "UPDATE users SET Password=? WHERE UserID=?";
            ps = conn.prepareStatement(query);
            String hashedPassword = Password.hashString(password);

            // Fill in the blanks, i.e. parameterize the query
            ps.setString(1, hashedPassword);
            ps.setInt(2, userID);

            // Execute the query
            rs = ps.executeUpdate();

        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Constraint Exception occurred: " + e.getMessage());
            // Set the rowsAffected to -1, this can be used as a flag for the display section
            rs = -1;

        } catch (SQLException se) {
            System.out.println("SQL Exception occurred: " + se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        } // Now that the program has completed its database access component, 
        // close the open access points (resultset, preparedstatement, connection)
        // Remember to close them in the OPPOSITE ORDER to how they were opened
        // Opening order: Connection -> PreparedStatement -> ResultSet
        // Closing order: ResultSet -> PreparedStatement -> Connection
        finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section in the updatePassword() method");
            }
        }

        if (rs > 0) {
            result = true;
            emailDao.removeRecovereyLog(userID);
        } else {
            result = false;
        }

        return result;

    }

}
