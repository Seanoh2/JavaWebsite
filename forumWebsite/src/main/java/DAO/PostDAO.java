/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Post;
import DTOS.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class PostDAO extends DAO {
    
    public PostDAO(String databaseName) {
        super(databaseName);
    }
    
    public ArrayList<Post> getAllPosts() {
     Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post p = null;
        ArrayList<Post> postList = new ArrayList();

        try {
            conn = getConnection();
            String query = "SELECT users.UserID, users.FirstName, users.LastName, users.Email, users.isAdmin, PostID, ForumID, IsLink, Title, Content, Score FROM posts INNER JOIN users ON posts.UserID = users.UserID;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                p = new Post(
                        rs.getInt("PostID"),
                        new User(
                                rs.getInt("UserID"),
                                rs.getString("FirstName"),
                                rs.getString("LastName"),
                                rs.getString("Email"),
                                null,
                                rs.getBoolean("isAdmin")
                            ),
                        rs.getInt("ForumID"),
                        rs.getBoolean("IsLink"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getInt("Score")
                );
                postList.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllPosts() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllPosts() method: " + e.getMessage());
            }
        }
        return postList;   
    }
    public ArrayList<Post> getPostsByForum(int forumID) {
     Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post p = null;
        ArrayList<Post> postList = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT users.UserID, users.FirstName, users.LastName, users.Email, users.isAdmin,"
                    + " PostID, ForumID, IsLink, Title, Content, Score FROM posts "
                    + " INNER JOIN users ON posts.UserID = users.UserID "
                    + " WHERE ForumID = ? ";
            ps = conn.prepareStatement(query);
            ps.setInt(1, forumID);
            rs = ps.executeQuery();

            while (rs.next()) {
                p = new Post(
                        rs.getInt("PostID"),
                        new User(
                                rs.getInt("UserID"),
                                rs.getString("FirstName"),
                                rs.getString("LastName"),
                                rs.getString("Email"),
                                null,
                                rs.getBoolean("isAdmin")
                            ),
                        rs.getInt("ForumID"),
                        rs.getBoolean("IsLink"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getInt("Score")
                );
                postList.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getPostsByForum() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getPostsByForum() method: " + e.getMessage());
            }
        }
        return postList;   
    }
    
    public ArrayList<Post> getPostsByUserID(int userID) {
     Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post p = null;
        ArrayList<Post> postList = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT users.UserID, users.FirstName, users.LastName, users.Email, users.isAdmin,"
                    + " PostID, ForumID, IsLink, Title, Content, Score FROM posts "
                    + " INNER JOIN users ON posts.UserID = users.UserID "
                    + " WHERE posts.UserID = ? ";
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();

            while (rs.next()) {
                p = new Post(
                        rs.getInt("PostID"),
                        new User(
                                rs.getInt("UserID"),
                                rs.getString("FirstName"),
                                rs.getString("LastName"),
                                rs.getString("Email"),
                                null,
                                rs.getBoolean("isAdmin")
                            ),
                        rs.getInt("ForumID"),
                        rs.getBoolean("IsLink"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getInt("Score")
                );
                postList.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getPostsByUserID() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getPostsByForum() method: " + e.getMessage());
            }
        }
        return postList;   
    }
    
}
