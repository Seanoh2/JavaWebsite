/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Rating;
import java.util.ArrayList;
import java.util.HashMap;
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
public class RatingDAOIT {
    
    public RatingDAOIT() {
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
     * Test of updateRating method, of class RatingDAO.
     */
    @Test
    public void testUpdateRating() {
        System.out.println("updateRating");
        Rating rate = null;
        RatingDAO instance = null;
        boolean expResult = false;
        boolean result = instance.updateRating(rate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRatingsByForum method, of class RatingDAO.
     */
    @Test
    public void testGetRatingsByForum() {
        System.out.println("getRatingsByForum");
        RatingDAO instance = new RatingDAO("forumdatabase");
        int expResult = 1;
        HashMap result = instance.getRatingsByForum();
        assertTrue(expResult <= result.size());
    }

    /**
     * Test of getAllRatings method, of class RatingDAO.
     */
    @Test
    public void testGetAllRatings() {
        System.out.println("getAllRatings");
        int forumID = 0;
        RatingDAO instance = new RatingDAO("forumdatabase");
        int expResult = 1;
        ArrayList<Rating> result = instance.getAllRatings(forumID);
        assertTrue(expResult <= result.size());
    }
    
}
