/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.radioprogram.entity;

import java.sql.Time;
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
public class RadioProgramTest {
    
    public RadioProgramTest() {
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
     * Test of getName method, of class RadioProgram.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        RadioProgram instance = new RadioProgram();
        instance.setName("testName");
        String expResult = "testName";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class RadioProgram.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String nameIn = "testName";
        RadioProgram instance = new RadioProgram();
        instance.setName(nameIn);
        assertNotNull(instance.getName());
    }

    /**
     * Test of getDescription method, of class RadioProgram.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        RadioProgram instance = new RadioProgram();
        String expResult = "testDesc";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class RadioProgram.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String descriptionIn = "testDesc";
        RadioProgram instance = new RadioProgram();
        instance.setDescription(descriptionIn);
        assertNotNull(instance.getDescription());
    }

    /**
     * Test of getTypicalDuration method, of class RadioProgram.
     */
    @Test
    public void testGetTypicalDuration() {
        System.out.println("getTypicalDuration");
        RadioProgram instance = new RadioProgram();
        Time expResult = new Time(System.currentTimeMillis());
        instance.setTypicalDuration(expResult);
        Time result = instance.getTypicalDuration();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTypicalDuration method, of class RadioProgram.
     */
    @Test
    public void testSetTypicalDuration() {
        System.out.println("setTypicalDuration");
        Time typicalDurationIn = new Time(System.currentTimeMillis());
        RadioProgram instance = new RadioProgram();
        instance.setTypicalDuration(typicalDurationIn);
        assertNotNull(instance.getTypicalDuration());
    }

    /**
     * Test of setAll method, of class RadioProgram.
     */
    @Test
    public void testSetAll() {
        System.out.println("setAll");
        String nameIn = "Name";
        String descriptionIn = "Desc";
        Time typicalDurationIn = new Time(System.currentTimeMillis());
        RadioProgram instance = new RadioProgram();
        instance.setAll(nameIn, descriptionIn, typicalDurationIn);
        assertEquals(nameIn,instance.getName());
        assertEquals(descriptionIn,instance.getDescription());
        assertEquals(typicalDurationIn,instance.getTypicalDuration());
    }

    /**
     * Test of hasEqualMapping method, of class RadioProgram.
     */
    @Test
    public void testHasEqualMapping() {
        System.out.println("hasEqualMapping");
        String nameIn = "Name";
        String descriptionIn = "Desc";
        Time typicalDurationIn = new Time(System.currentTimeMillis());
        RadioProgram valueObject = new RadioProgram(nameIn,descriptionIn,typicalDurationIn);;
        RadioProgram instance = new RadioProgram(nameIn,descriptionIn,typicalDurationIn);
        boolean expResult = true;
        boolean result = instance.hasEqualMapping(valueObject);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class RadioProgram.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RadioProgram instance = new RadioProgram();
        String expResult = "";
        String result = instance.toString();
        assertNotNull(result);
    }

    /**
     * Test of clone method, of class RadioProgram.
     */
    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        RadioProgram instance = new RadioProgram();
        String nameIn = "Name";
        String descriptionIn = "Desc";
        Time typicalDurationIn = new Time(System.currentTimeMillis());
        instance.setAll(nameIn, descriptionIn, typicalDurationIn);
        
        RadioProgram result = (RadioProgram)instance.clone();
        assertEquals(nameIn, result.getName());
        assertEquals(descriptionIn, result.getDescription());
        assertEquals(typicalDurationIn, result.getTypicalDuration());

    }
    
}
