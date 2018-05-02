/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTOS.User;
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
public class UserDAOIT {
    
    public UserDAOIT() {
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
     * Test of selectUserByUsername method, of class UserDAO.
     */
    @Test
    public void testSelectUserByUsername() {
        System.out.println("selectUserByUsername");
        String firstName = "Sean";
        String lastName = "OHora";
        UserDAO instance = new UserDAO("forumdatabase");
        int expResult = 1;
        ArrayList<User> result = instance.selectUserByUsername(firstName, lastName);
        assertTrue(expResult <= result.size());
    }

    /**
     * Test of selectUserContainingName method, of class UserDAO.
     */
    @Test
    public void testSelectUserContainingName() {
        System.out.println("selectUserContainingName");
        String name = "";
        UserDAO instance = new UserDAO("forumdatabase");;
        int expResult = 1;
        ArrayList<User> result = instance.selectUserContainingName(name);
        assertTrue(expResult <= result.size());
    }

    /**
     * Test of getAllUsers method, of class UserDAO.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        UserDAO instance = null;
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findUserByID method, of class UserDAO.
     */
    @Test
    public void testFindUserByID() {
        System.out.println("findUserByID");
        int userID = 0;
        UserDAO instance = null;
        User expResult = null;
        User result = instance.findUserByID(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class UserDAO.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User u = null;
        UserDAO instance = null;
        boolean expResult = false;
        boolean result = instance.addUser(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserDAO.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        int id = 0;
        UserDAO instance = null;
        boolean expResult = false;
        boolean result = instance.deleteUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class UserDAO.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String email = "";
        String password = "";
        UserDAO instance = null;
        User expResult = null;
        User result = instance.login(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserByEmail method, of class UserDAO.
     */
    @Test
    public void testGetUserByEmail() {
        System.out.println("getUserByEmail");
        String email = "";
        UserDAO instance = null;
        User expResult = null;
        User result = instance.getUserByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeUser method, of class UserDAO.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        int id = 0;
        UserDAO instance = null;
        int expResult = 0;
        int result = instance.removeUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePassword method, of class UserDAO.
     */
    @Test
    public void testUpdatePassword() {
        System.out.println("updatePassword");
        String password = "";
        int userID = 0;
        UserDAO instance = null;
        boolean expResult = false;
        boolean result = instance.updatePassword(password, userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserDAO.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        User u1 = null;
        UserDAO instance = null;
        boolean expResult = false;
        boolean result = instance.updateUser(u1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
