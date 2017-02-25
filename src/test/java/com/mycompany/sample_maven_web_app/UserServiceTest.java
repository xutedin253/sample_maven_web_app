/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sample_maven_web_app;

import java.util.List;
import objects.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wlloyd
 */
public class UserServiceTest {
    
    public UserServiceTest() {
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
     * Test of getUsers method, of class UserService.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        UserService instance = new UserService();
        //String result = instance.getUsers();
        //String result = instance.getUsersJson("");
        List<User> result = instance.getUsersJson("");
        //assertTrue(result.length() > 0);
        //assertTrue(result.size() > 0);
        //assertTrue(result.contains("html"));
    }

//    /**
//     * Test of updateUser method, of class UserService.
//     */
//    @Test
//    public void testUpdateUser() throws Exception {
//        System.out.println("updateUser");
//        String jobj = "";
//        UserService instance = new UserService();
//        String expResult = "";
//        String result = instance.updateUser(jobj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteUser method, of class UserService.
//     */
//    @Test
//    public void testDeleteUser() throws Exception {
//        System.out.println("deleteUser");
//        String jobj = "";
//        UserService instance = new UserService();
//        String expResult = "";
//        String result = instance.deleteUser(jobj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createUser method, of class UserService.
//     */
//    @Test
//    public void testCreateUser() throws Exception {
//        System.out.println("createUser");
//        String jobj = "";
//        UserService instance = new UserService();
//        String expResult = "";
//        String result = instance.createUser(jobj);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}

