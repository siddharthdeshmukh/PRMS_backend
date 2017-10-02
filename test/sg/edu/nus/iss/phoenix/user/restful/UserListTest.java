/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.restful;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;

/**
 *
 * @author e0146956
 */
public class UserListTest {
    
    public UserListTest() {
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
     * Test of getUserList method, of class UserList.
     */
    @Test
    public void testGetUserList() {
        System.out.println("getUserList");
        UserList instance = new UserList();
        List<User> expResult = null;
        List<User> result = instance.getUserList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserList method, of class UserList.
     */
    @Test
    public void testSetUserList() {
        System.out.println("setUserList");
        List<User> userList = null;
        UserList instance = new UserList();
        instance.setUserList(userList);
    }
    
}
