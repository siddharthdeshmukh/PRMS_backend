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
import sg.edu.nus.iss.phoenix.user.entity.Presenter;

/**
 *
 * @author e0146956
 */
public class ListOfPresentersTest {
    
    public ListOfPresentersTest() {
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
     * Test of getPresenterList method, of class ListOfPresenters.
     */
    @Test
    public void testGetPresenterList() {
        System.out.println("getPresenterList");
        ListOfPresenters instance = new ListOfPresenters();
        List<Presenter> expResult = null;
        List<Presenter> result = instance.getPresenterList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPresenterList method, of class ListOfPresenters.
     */
    @Test
    public void testSetPresenterList() {
        System.out.println("setPresenterList");
        List<Presenter> presenters = null;
        ListOfPresenters instance = new ListOfPresenters();
        instance.setPresenterList(presenters);
    }
    
}
