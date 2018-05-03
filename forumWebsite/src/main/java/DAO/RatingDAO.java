/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Post;
import DTOS.Rating;
import DTOS.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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
            String query = "INSERT INTO ratings "
                    + "VALUES(NULL,?,?,?) "
                    + "ON DUPLICATE KEY "
                    + "UPDATE rating = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, rate.getUserID());
            ps.setInt(2, rate.getPostID());
            ps.setInt(3, rate.getRating());
            ps.setInt(4, rate.getRating());
            result = ps.execute();

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

    public HashMap getRatingsByForum() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        HashMap ratingMap = new HashMap();

        try {
            conn = getConnection();

            String query = "SELECT postID,SUM(rating) AS score FROM ratings GROUP BY postID";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                ratingMap.put(rs.getInt("postID"), rs.getInt("score"));
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getRatingsByForumID() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getRatingsByForumID() method: " + e.getMessage());
            }
        }
        return ratingMap;
    }
    
    public HashMap getRatingsByPost(int userID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        HashMap ratingMap = new HashMap();

        try {
            conn = getConnection();

            String query = "SELECT postID,rating FROM ratings WHERE userID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();

            while (rs.next()) {
                ratingMap.put(rs.getInt("postID"), rs.getInt("rating"));
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getRatingsByPost() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getRatingsByPost() method: " + e.getMessage());
            }
        }
        return ratingMap;
    }
    
    public ArrayList<Rating> getAllRatings(int forumID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Rating r = null;
        ArrayList<Rating> ratingList = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT * FROM ratings";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                r = new Rating(
                        rs.getInt("rateID"),
                        rs.getInt("userID"),
                        rs.getInt("postID"),
                        rs.getInt("rating")
                );
                ratingList.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getRatingsByForumID() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getRatingsByForumID() method: " + e.getMessage());
            }
        }
        return ratingList;
    } 

}
