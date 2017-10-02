/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.entity;

import java.sql.Time;
import java.util.Date;
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
public class ProgramSlotTest {
    
    ProgramSlot instance;
    public ProgramSlotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ProgramSlot(null, new Date(), new Date(), "test");
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of setAll method, of class ProgramSlot.
     */
    @Test
    public void testSetAll() {
        System.out.println("setAll");
        Time Duration = null;
        Date DateOfProgram = null;
        Date Starttime = null;
        String progamName = "";
        ProgramSlot instance = new ProgramSlot();
        instance.setAll(Duration, DateOfProgram, Starttime, progamName);
    }

    /**
     * Test of getDuration method, of class ProgramSlot.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        ProgramSlot instance = new ProgramSlot();
        Time expResult = null;
        Time result = instance.getDuration();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDuration method, of class ProgramSlot.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        Time duration = new Time(new Date().getTime());
        instance.setDuration(duration);
        assertEquals(instance.getDuration(),duration);
        
    }

    /**
     * Test of getDateOfProgram method, of class ProgramSlot.
     */
    @Test
    public void testGetDateOfProgram() {
        System.out.println("getDateOfProgram");
        Date expResult = new Date();
        Date result = instance.getDateOfProgram();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateOfProgram method, of class ProgramSlot.
     */
    @Test
    public void testSetDateOfProgram() {
        System.out.println("setDateOfProgram");
        Date DateOfProgram = new Date();
        instance.setDateOfProgram(DateOfProgram);
    }

    /**
     * Test of getStarttime method, of class ProgramSlot.
     */
    @Test
    public void testGetStarttime() {
        System.out.println("getStarttime");
        Date expResult = new Date();
        Date result = instance.getStarttime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStarttime method, of class ProgramSlot.
     */
    @Test
    public void testSetStarttime() {
        System.out.println("setStarttime");
        Date Starttime = new Date();
        instance.setStarttime(Starttime);
    }

    /**
     * Test of getProgamName method, of class ProgramSlot.
     */
    @Test
    public void testGetProgamName() {
        System.out.println("getProgamName");
        String result = instance.getProgamName();
        assertEquals("test", result);
    }

    /**
     * Test of setProgamName method, of class ProgramSlot.
     */
    @Test
    public void testSetProgamName() {
        System.out.println("setProgamName");
        String progamName = "test";
        instance.setProgamName(progamName);
        assertEquals(progamName,instance.getProgamName());
    }
    
}
