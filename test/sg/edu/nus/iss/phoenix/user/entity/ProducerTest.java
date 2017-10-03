/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author e0146956
 */
public class ProducerTest {
    Producer instance;
    public ProducerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Producer();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setAll method, of class Producer.
     */
    @Test
    public void testSetAll() {
        System.out.println("setAll");
        String idIn = "testID";
        String nameIn = "testName";
        instance.setAll(idIn, nameIn);
    }

    /**
     * Test of getId method, of class Producer.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        instance.setId("testID");
        String expResult = "testID";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Producer.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "testID";
        instance.setId(id);
    }

    /**
     * Test of getName method, of class Producer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        instance.setName("testName");
        String expResult = "testName";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Producer.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "testName";
        instance.setName(name);
    }

    /**
     * Test of toString method, of class Producer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        instance.setName("testName");
        instance.setId("testID");
        String result = instance.toString();
        assertNotNull(result);
    }

    /**
     * Test of clone method, of class Producer.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        instance.setName("testName");
        instance.setId("testID");
        Producer result = (Producer)instance.clone();
        assertEquals(instance.getId(), result.getId());
        assertEquals(instance.getName(), result.getName());
    }
    
}
