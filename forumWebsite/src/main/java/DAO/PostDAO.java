/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Post;
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

            String query = "SELECT users.UserID, users.FirstName, users.LastName, users.Email, users.isAdmin,"
                    + " ForumID, IsLink, Title, Content, Score FROM posts"
                    + "INNER JOIN users ON posts.UserID = users.UserID;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                
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
    
}
