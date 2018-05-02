/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Post;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sean
 */
public class PostDAOIT {
    
    public PostDAOIT() {
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
     * Test of getAllPosts method, of class PostDAO.
     */
    @Test
    public void testGetAllPosts() {
        System.out.println("getAllPosts");
        PostDAO instance = new PostDAO("forumdatabase");
        int expResult = 1;
        ArrayList<Post> result = instance.getAllPosts();
        assertTrue(expResult <= result.size());
    }

    /**
     * Test of getPostsByForum method, of class PostDAO.
     */
    @Test
    public void testGetPostsByForum() {
        System.out.println("getPostsByForum");
        int forumID = 1;
        PostDAO instance = new PostDAO("forumdatabase");
        int expResult = 1;
        ArrayList<Post> result = instance.getPostsByForum(forumID);
        assertTrue(expResult <= result.size());
    }

    /**
     * Test of getPostsByUserID method, of class PostDAO.
     */
    @Test
    public void testGetPostsByUserID() {
        System.out.println("getPostsByUserID");
        int userID = 3;
        PostDAO instance = new PostDAO("forumdatabase");
        ArrayList<Post> expResult = null;
        ArrayList<Post> result = instance.getPostsByUserID(userID);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostByID method, of class PostDAO.
     */
    @Test
    public void testGetPostByID() {
        System.out.println("getPostByID");
        int postID = 0;
        PostDAO instance = null;
        Post expResult = null;
        Post result = instance.getPostByID(postID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPost method, of class PostDAO.
     */
    @Test
    public void testAddPost() {
        System.out.println("addPost");
        Post p = null;
        PostDAO instance = null;
        boolean expResult = false;
        boolean result = instance.addPost(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editPost method, of class PostDAO.
     */
    @Test
    public void testEditPost() {
        System.out.println("editPost");
        Post p = null;
        PostDAO instance = null;
        boolean expResult = false;
        boolean result = instance.editPost(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePost method, of class PostDAO.
     */
    @Test
    public void testDeletePost() {
        System.out.println("deletePost");
        int id = 0;
        PostDAO instance = null;
        boolean expResult = false;
        boolean result = instance.deletePost(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
