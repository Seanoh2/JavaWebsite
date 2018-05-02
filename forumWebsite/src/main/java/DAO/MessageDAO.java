/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Message;
import DTOS.User;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class MessageDAO extends DAO {
    
    public MessageDAO(String databaseName) {
        super(databaseName);
    }
    
    public ArrayList<Message> getMessagesBySender(int UserID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Message message = null;
        User us = null;
        User ur = null;
        ArrayList<Message> messages = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT * FROM messages;";
            ps = conn.prepareStatement(query);
            ps.setInt(1, UserID);
            rs = ps.executeQuery();
            UserDAO userdao = new UserDAO("forumdatabase");

            while (rs.next()) {
                us = userdao.findUserByID(rs.getInt("SenderID"));
                ur = userdao.findUserByID(rs.getInt("ReceiverID"));
                
                message = new Message(
                        rs.getInt("MessageID"),
                        us,
                        ur,
                        rs.getInt("Type"),
                        rs.getDate("Time"),
                        rs.getString("Content")
                        
                );
                messages.add(message);
            }

        } catch (SQLException ex) {
            System.out.println("Exception occured in the getMessagesBySender() method: " + ex.getMessage());
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
                System.out.println("Exception occured in the finally section of the getMessagesBySender() method: " + e.getMessage());
            }
        }
        return messages;
    }
    
    public ArrayList<Message> getMessagesByReceiver(int UserID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Message message = null;
        User us = null;
        User ur = null;
        ArrayList<Message> messages = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT * FROM messages";
            ps = conn.prepareStatement(query);
            ps.setInt(1, UserID);
            rs = ps.executeQuery();
            UserDAO userdao = new UserDAO("forumdatabase");

            while (rs.next()) {
                us = userdao.findUserByID(rs.getInt("SenderID"));
                ur = userdao.findUserByID(rs.getInt("ReceiverID"));
                
                message = new Message(
                        rs.getInt("MessageID"),
                        us,
                        ur,
                        rs.getInt("Type"),
                        rs.getDate("Time"),
                        rs.getString("Content")
                        
                );
                messages.add(message);
            }

        } catch (SQLException ex) {
            System.out.println("Exception occured in the getMessagesByReceiver() method: " + ex.getMessage());
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
                System.out.println("Exception occured in the finally section of the getMessagesByReceiver() method: " + e.getMessage());
            }
        }
        return messages;
    }
    
    public boolean addMessage(Message msg) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        Boolean result = null;

        try {
            conn = getConnection();
            String query = "INSERT INTO Messages VALUES (NULL, ?, ?, ?, NOW(), ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1,msg.getSender().getUserID());
            ps.setInt(2,msg.getReciever().getUserID());
            ps.setInt(3,msg.getType());
            ps.setString(4,msg.getContent());

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
                System.out.println("Exception occured in the finally section in the addMessage() method");
            }
        }
        if (rs > 0) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }
    
}
