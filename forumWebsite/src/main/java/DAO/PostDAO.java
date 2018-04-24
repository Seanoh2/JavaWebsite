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
            String query = "SELECT users.UserID, users.FirstName, users.LastName, users.Email, users.isAdmin, PostID, ForumID, IsLink, Title, Content FROM posts INNER JOIN users ON posts.UserID = users.UserID;";
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
                        rs.getString("Content")
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
                    + " PostID, ForumID, IsLink, Title, Content FROM posts "
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
                        rs.getString("Content")
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
                    + " PostID, ForumID, IsLink, Title, Content FROM posts "
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
                        rs.getString("Content")
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
    
    public Post getPostByID(int postID) {
         Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post post = null;

        try {
            conn = getConnection();

            String query = "SELECT users.UserID, users.FirstName, users.LastName, users.Email, users.isAdmin,"
                    + " PostID, ForumID, IsLink, Title, Content FROM posts "
                    + " INNER JOIN users ON posts.UserID = users.UserID "
                    + " WHERE posts.postID = ? ";
            ps = conn.prepareStatement(query);
            ps.setInt(1, postID);
            rs = ps.executeQuery();

            while (rs.next()) {
                post = new Post(
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
                        rs.getString("Content")
                );
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getPostByID() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getPostByID() method: " + e.getMessage());
            }
        }
        return post;
    }
    
    public boolean addPost(Post p) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        Boolean result = null;

        try {
            conn = getConnection();
            
            String query = "INSERT INTO posts VALUES (NULL, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, p.getPoster().getUserID());
            ps.setInt(2, p.getForumID());
            ps.setBoolean(3, p.isIsLink());
            ps.setString(4, p.getTitle());
            ps.setString(5, p.getContent());

            rs = ps.executeUpdate();

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
                System.out.println("Exception occured in the finally section in the addPost() method");
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
