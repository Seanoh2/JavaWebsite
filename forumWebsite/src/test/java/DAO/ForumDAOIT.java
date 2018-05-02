///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package DAO;
//
//import DTOS.Forum;
//import java.util.ArrayList;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
//
///**
// *
// * @author Sean
// */
//public class ForumDAOIT {
//    
//    public ForumDAOIT() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getAllForums method, of class ForumDAO.
//     */
//    @Test
//    public void testGetAllForums() {
//        System.out.println("getAllForums");
//        ForumDAO instance = new ForumDAO("forumdatabase");
//        int expResult = 1;
//        ArrayList<Forum> result = instance.getAllForums();
//        assertTrue(expResult <= result.size());
//    }
//
//    /**
//     * Test of getForumsByTitle method, of class ForumDAO.
//     */
//    @Test
//    public void testGetForumsByTitle() {
//        System.out.println("getForumsByTitle");
//        String title = "games";
//        ForumDAO instance = new ForumDAO("forumdatabase");
//        int expResult = 1;
//        ArrayList<Forum> result = instance.getForumsByTitle(title);
//        assertTrue(expResult <= result.size());
//    }
//
//    /**
//     * Test of getForumByID method, of class ForumDAO.
//     */
//    @Test
//    public void testGetForumByID() {
//        System.out.println("getForumByID");
//        int ID = 0;
//        ForumDAO instance = null;
//        Forum expResult = null;
//        Forum result = instance.getForumByID(ID);
//        assertThat(expResult, not(result));
//    }
//    
//}
