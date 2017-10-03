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
import sg.edu.nus.iss.phoenix.user.entity.Producer;

/**
 *
 * @author e0146956
 */
public class ListOfProducersTest {
    
    public ListOfProducersTest() {
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
     * Test of getProducerList method, of class ListOfProducers.
     */
    @Test
    public void testGetProducerList() {
        System.out.println("getProducerList");
        ListOfProducers instance = new ListOfProducers();
        List<Producer> expResult = null;
        List<Producer> result = instance.getProducerList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProducerList method, of class ListOfProducers.
     */
    @Test
    public void testSetProducerList() {
        System.out.println("setProducerList");
        List<Producer> producers = null;
        ListOfProducers instance = new ListOfProducers();
        instance.setProducerList(producers);
    }
    
}
