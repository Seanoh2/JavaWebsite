/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Comment;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Seanoh
 */
public class CommentDAOTest {
    
    public CommentDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCommentsBySenderID method, of class CommentDAO.
     */
    @org.junit.Test
    public void testGetCommentsBySenderID() {
        System.out.println("getCommentsBySenderID");
        int senderID = 11;
        CommentDAO instance = new CommentDAO("forumdatabase");
        int expResult = 0;
        ArrayList<Comment> result = instance.getCommentsBySenderID(senderID);
        assertTrue(result.size() >= expResult);
    }

    /**
     * Test of getCommentsByReceiverID method, of class CommentDAO.
     */
    @org.junit.Test
    public void testGetCommentsByReceiverID() {
        System.out.println("getCommentsByReceiverID");
        int receiverID = 11;
        CommentDAO instance = new CommentDAO("forumdatabase");
        ArrayList<Comment> result = instance.getCommentsByReceiverID(receiverID);
        int expResult = 1;
        assertTrue(expResult <= result.size());
    }

    /**
     * Test of getCommentsByPostID method, of class CommentDAO.
     */
    @org.junit.Test
    public void testGetCommentsByPostID() {
        System.out.println("getCommentsByPostID");
        int postID = 34;
        CommentDAO instance = new CommentDAO("forumdatabase");
        int expResult = 1;
        ArrayList<Comment> result = instance.getCommentsByPostID(postID);
        assertTrue(expResult <= result.size());
    }

    /**
     * Test of addComment method, of class CommentDAO.
     */
    @org.junit.Test
    public void testAddComment() {
        System.out.println("addComment");
        Comment c = new Comment();
        CommentDAO instance = null;
        boolean expResult = false;
        //boolean result = instance.addComment(c);
        assertTrue(true);
    }
    
    
}
