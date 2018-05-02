/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.Message;
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
public class MessageDAOIT {
    
    public MessageDAOIT() {
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
     * Test of getMessagesBySender method, of class MessageDAO.
     */
    @Test
    public void testGetMessagesBySender() {
        System.out.println("getMessagesBySender");
        int UserID = 3;
        MessageDAO instance = new MessageDAO("forumdatabase");
        int expResult = 1;
        ArrayList<Message> result = instance.getMessagesBySender(UserID);
        assertTrue(expResult <= result.size());
    }

    /**
     * Test of getMessagesByReceiver method, of class MessageDAO.
     */
    @Test
    public void testGetMessagesByReceiver() {
        System.out.println("getMessagesByReceiver");
        int UserID = 0;
        MessageDAO instance = null;
        int expResult = 1;
        ArrayList<Message> result = instance.getMessagesByReceiver(UserID);
        assertTrue(expResult <= result.size());

    }

    /**
     * Test of addMessage method, of class MessageDAO.
     */
    @Test
    public void testAddMessage() {
        System.out.println("addMessage");
        Message msg = null;
        MessageDAO instance = null;
        boolean expResult = false;
        boolean result = instance.addMessage(msg);
        assertEquals(expResult, result);
    }
    
}
