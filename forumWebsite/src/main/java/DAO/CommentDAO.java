/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Comment;
import DTOS.Post;
import DTOS.User;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Seanoh
 */
public class CommentDAO extends DAO {

    public CommentDAO(String databaseName) {
        super(databaseName);
    }

    public ArrayList<Comment> getCommentsBySenderID(int senderID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comment c = null;
        Post p = null;
        User us = null;
        User ur = null;
        ArrayList<Comment> commentList = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT * FROM comments WHERE userID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, senderID);
            rs = ps.executeQuery();
            PostDAO postdao = new PostDAO("forumdatabase");
            UserDAO userdao = new UserDAO("forumdatabase");

            while (rs.next()) {           
                   c = new Comment(
                        rs.getInt("CommentID"),
                        p,
                        us,
                        ur,
                        rs.getDate("Time"),
                        rs.getString("Content")
                );
                commentList.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getCommentsBySenderID() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getCommentsBySenderID() method: " + e.getMessage());
            }
        }
        return commentList;
    }

    public ArrayList<Comment> getCommentsByReceiverID(int receiverID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comment c = null;
        ArrayList<Comment> commentList = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT * FROM comments WHERE ReceiverID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, receiverID);
            rs = ps.executeQuery();

            while (rs.next()) {
                PostDAO postdao = new PostDAO("forumdatabase");
                UserDAO userdao = new UserDAO("forumdatabase");
                
                Post p = postdao.getPostByID(rs.getInt("PostID"));
                User us = userdao.findUserByID(rs.getInt("SenderID"));
                User ur = userdao.findUserByID(rs.getInt("ReceiverID"));
                   c = new Comment(
                        rs.getInt("CommentID"),
                        p,
                        us,
                        ur,
                        rs.getDate("Time"),
                        rs.getString("Content")
                );
                commentList.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getCommentsByReceiverID() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getCommentsByReceiverID() method: " + e.getMessage());
            }
        }
        return commentList;
    }

    public ArrayList<Comment> getCommentsByPostID(int postID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comment c = null;
        ArrayList<Comment> commentList = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT * FROM comments WHERE PostID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, postID);
            rs = ps.executeQuery();

            while (rs.next()) {
                PostDAO postdao = new PostDAO("forumdatabase");
                UserDAO userdao = new UserDAO("forumdatabase");
                
                Post p = postdao.getPostByID(rs.getInt("PostID"));
                User us = userdao.findUserByID(rs.getInt("SenderID"));
                User ur = userdao.findUserByID(rs.getInt("ReceiverID"));
                   c = new Comment(
                        rs.getInt("CommentID"),
                        p,
                        us,
                        ur,
                        rs.getDate("Time"),
                        rs.getString("Content")
                );
                commentList.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getCommentsByPostID() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getCommentsByPostID() method: " + e.getMessage());
            }
        }
        return commentList;
    }
    
    public boolean addComment(Comment c) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        Boolean result = null;
        
        try {
            conn = getConnection();
            String query = "INSERT INTO comments VALUES (NULL, ?, ?, ?, NOW(), ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, c.getPost().getPostID());
            ps.setInt(2, c.getSender().getUserID());
            ps.setInt(3, c.getReceiver().getUserID());
            ps.setString(4, c.getContent());

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
                System.out.println("Exception occured in the finally section in the addComment() method");
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
