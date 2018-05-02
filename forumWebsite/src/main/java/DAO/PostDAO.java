/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Forum;
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
            String query = "SELECT * FROM posts";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            UserDAO userdao = new UserDAO("forumdatabase");

            while (rs.next()) {
                User poster = userdao.findUserByID(rs.getInt("UserID"));
                p = new Post(
                        rs.getInt("PostID"),
                        poster,
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

            String query = "SELECT * FROM forum WHERE ForumID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, forumID);
            rs = ps.executeQuery();
            UserDAO userdao = new UserDAO("forumdatabase");

            while (rs.next()) {
                User poster = userdao.findUserByID(rs.getInt("UserID"));
                p = new Post(
                        rs.getInt("PostID"),
                        poster,
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

            String query = "SELECT * FROM forum WHERE UserID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            UserDAO userdao = new UserDAO("forumdatabase");

            while (rs.next()) {
                User poster = userdao.findUserByID(rs.getInt("UserID"));
                p = new Post(
                        rs.getInt("PostID"),
                        poster,
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
            String query = "SELECT * FROM post WHERE postID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, postID);
            rs = ps.executeQuery();
            UserDAO userdao = new UserDAO("forumdatabase");

            while (rs.next()) {
                User poster = userdao.findUserByID(rs.getInt("UserID"));
                post = new Post(
                        rs.getInt("PostID"),
                        poster,
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

            String query = "INSERT INTO posts VALUES (NULL, ?, ?, ?, ?, ?)";
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

    public boolean editPost(Post p) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        Boolean result = null;

        try {
            conn = getConnection();

            String query = "UPDATE POSTS SET Title = ?, Content = ? WHERE PostID = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getTitle());
            ps.setString(2, p.getContent());
            ps.setInt(3, p.getPostID());

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
                System.out.println("Exception occured in the finally section in the editPost() method");
            }
        }
        if (rs > 0) {
            result = true;
        } else {
            result = false;
        }

        return result;

    }

    public boolean deletePost(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        Boolean result = null;

        try {
            conn = getConnection();
            String query = "DELETE FROM posts WHERE postID = ?";
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
                System.out.println("Exception occured in the finally section in the deletePost() method");
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
