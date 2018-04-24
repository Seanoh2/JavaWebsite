/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Rating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class RatingDAO extends DAO {
    
    public RatingDAO(String databaseName) {
        super(databaseName);
    }
    
    public boolean updateRating(Rating rate) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            conn = getConnection();
            String query = "IF EXISTS (SELECT * FROM ratings "
                    + "WHERE userID = ? "
                    + "AND postID = ?) "
                    + "UPDATE ratings "
                    + "SET rating = ? "
                    + "WHERE userID = ? "
                    + "AND postID = ? "
                    + "ELSE "
                    + "INSERT INTO ratings (rateID, userID, postID, rating) "
                    + "VALUES (NULL, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, rate.getUserID());
            ps.setInt(2, rate.getPostID());
            ps.setInt(3, rate.getRating());
            ps.setInt(4, rate.getUserID());
            ps.setInt(5, rate.getPostID());
            ps.setInt(6, rate.getUserID());
            ps.setInt(7, rate.getPostID());
            ps.setInt(8, rate.getRating());
            rs = ps.executeQuery();

        } catch (SQLException e) {
            System.out.println("Exception occured in the updateRating() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the updateRating() method: " + e.getMessage());
            }
        }
        return result;
    }
    
}
