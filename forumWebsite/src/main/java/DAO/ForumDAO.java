/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Forum;
import interfaces.ForumDAOInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class ForumDAO extends DAO implements ForumDAOInterface {

    public ForumDAO(String databaseName) {
        super(databaseName);
    }

    @Override
    public ArrayList<Forum> getAllForums() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Forum forum = null;
        ArrayList<Forum> forums = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT * FROM forums";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                forum = new Forum(
                        rs.getInt("forumID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("sidebar"),
                        rs.getString("wiki")
                );
                forums.add(forum);
            }

        } catch (SQLException ex) {
            System.out.println("Exception occured in the getAllForums() method: " + ex.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllForums() method: " + e.getMessage());
            }
        }
        return forums;
    }

    @Override
    public ArrayList<Forum> getForumsByTitle(String title) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Forum forum = null;
        ArrayList<Forum> forums = new ArrayList();

        try {
            conn = getConnection();

            String query = "SELECT * FROM forums WHERE Title = ?";
            ps.setString(1, title);
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                forum = new Forum(
                        rs.getInt("forumID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("sidebar"),
                        rs.getString("wiki")
                );
                forums.add(forum);
            }

        } catch (SQLException ex) {
            System.out.println("Exception occured in the getForumsByTitle() method: " + ex.getMessage());
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
                System.out.println("Exception occured in the finally section of the getForumsByTitle() method: " + e.getMessage());
            }
        }
        return forums;
    }

    @Override
    public Forum getForumByID(int ID) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Forum forum = null;

        try {
            conn = getConnection();

            String query = "SELECT * FROM forums WHERE ForumID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, ID);
            rs = ps.executeQuery();

            if(rs.next()) {
                forum = new Forum(
                        rs.getInt("ForumID"),
                        rs.getString("Title"),
                        rs.getString("Description"),
                        rs.getString("Sidebar"),
                        rs.getString("Wiki")
                );

            }

        } catch (SQLException ex) {
            System.out.println("Exception occured in the getForumsByTitle() method: " + ex.getMessage());
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
                System.out.println("Exception occured in the finally section of the getForumsByTitle() method: " + e.getMessage());
            }
        }
        return forum;
    }

    @Override
    public boolean addForum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteForum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
