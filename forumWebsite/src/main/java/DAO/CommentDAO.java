/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Comment;
import DTOS.Post;
import DTOS.User;
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
        ArrayList<Comment> commentList = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT CommentID, posts.postID, posts.userID, posts.Title, posts.ForumID, sender.UserID, sender.FirstName,"
                    + " receiver.UserID, receiver.FirstName, Time, comments.Score, comments.Content"
                    + " FROM comments"
                    + " INNER JOIN users AS sender ON sender.UserID = comments.SenderID"
                    + " INNER JOIN users AS receiver ON receiver.UserID = comments.ReceiverID"
                    + " INNER JOIN posts AS posts ON posts.PostID = comments.PostID"
                    + " WHERE SenderID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, senderID);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Comment(
                        rs.getInt("CommentID"),
                        new Post(
                                rs.getInt("posts.postID"),
                                new User(
                                        rs.getInt("posts.userID"),
                                        null,
                                        null,
                                        null,
                                        null,
                                        false
                                ),
                                rs.getInt("posts.ForumID"),
                                false,
                                rs.getString("posts.Title"),
                                null,
                                0
                        ),
                        new User(
                                rs.getInt("sender.UserID"),
                                rs.getString("sender.FirstName"),
                                null,
                                null,
                                null,
                                false
                        ),
                        new User(
                                rs.getInt("receiver.UserID"),
                                rs.getString("receiver.FirstName"),
                                null,
                                null,
                                null,
                                false
                        ),
                        rs.getDate("Time"),
                        rs.getInt("Score"),
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
            String query = "SELECT CommentID, posts.postID, posts.userID, posts.Title, posts.ForumID, sender.UserID, sender.FirstName,"
                    + " receiver.UserID, receiver.FirstName, Time, comments.Score, comments.Content"
                    + " FROM comments"
                    + " INNER JOIN users AS sender ON sender.UserID = comments.SenderID"
                    + " INNER JOIN users AS receiver ON receiver.UserID = comments.ReceiverID"
                    + " INNER JOIN posts AS posts ON posts.PostID = comments.PostID"
                    + " WHERE ReceiverID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, receiverID);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Comment(
                        rs.getInt("CommentID"),
                        new Post(
                                rs.getInt("posts.postID"),
                                new User(
                                        rs.getInt("posts.userID"),
                                        null,
                                        null,
                                        null,
                                        null,
                                        false
                                ),
                                rs.getInt("posts.ForumID"),
                                false,
                                rs.getString("posts.Title"),
                                null,
                                0
                        ),
                        new User(
                                rs.getInt("sender.UserID"),
                                rs.getString("sender.FirstName"),
                                null,
                                null,
                                null,
                                false
                        ),
                        new User(
                                rs.getInt("receiver.UserID"),
                                rs.getString("receiver.FirstName"),
                                null,
                                null,
                                null,
                                false
                        ),
                        rs.getDate("Time"),
                        rs.getInt("Score"),
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
            String query = "SELECT CommentID, posts.postID, posts.userID, posts.Title, posts.ForumID, sender.UserID, sender.FirstName,"
                    + " receiver.UserID, receiver.FirstName, Time, comments.Score, comments.Content"
                    + " FROM comments"
                    + " INNER JOIN users AS sender ON sender.UserID = comments.SenderID"
                    + " INNER JOIN users AS receiver ON receiver.UserID = comments.ReceiverID"
                    + " INNER JOIN posts AS posts ON posts.PostID = comments.PostID"
                    + " WHERE posts.postID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, postID);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Comment(
                        rs.getInt("CommentID"),
                        new Post(
                                rs.getInt("posts.postID"),
                                new User(
                                        rs.getInt("posts.userID"),
                                        null,
                                        null,
                                        null,
                                        null,
                                        false
                                ),
                                rs.getInt("posts.ForumID"),
                                false,
                                rs.getString("posts.Title"),
                                null,
                                0
                        ),
                        new User(
                                rs.getInt("sender.UserID"),
                                rs.getString("sender.FirstName"),
                                null,
                                null,
                                null,
                                false
                        ),
                        new User(
                                rs.getInt("receiver.UserID"),
                                rs.getString("receiver.FirstName"),
                                null,
                                null,
                                null,
                                false
                        ),
                        rs.getDate("Time"),
                        rs.getInt("Score"),
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

}
