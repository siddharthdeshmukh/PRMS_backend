/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.entity;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

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
        instance = new ProgramSlot(30, new Date(), new Time(System.currentTimeMillis()),new RadioProgram(), "pres","prod");
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
        instance.setAll(30, new Date(), new Time(System.currentTimeMillis()),new RadioProgram(), "pres","prod");
    }

    /**
     * Test of getDuration method, of class ProgramSlot.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        ProgramSlot instance = new ProgramSlot();
        int expResult = 0;
        int result = instance.getDuration();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDuration method, of class ProgramSlot.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        int duration = 20;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String expResultStr = sdf.format(expResult);
        String resultStr = sdf.format(result);
        assertEquals(expResultStr, resultStr);
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
        Time expResult = new Time(System.currentTimeMillis());
        instance.setStartTime(expResult);
        Time result = instance.getStartTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStarttime method, of class ProgramSlot.
     */
    @Test
    public void testSetStarttime() {
        System.out.println("setStarttime");
        Time Starttime = new Time(System.currentTimeMillis());
        instance.setStartTime(Starttime);
    }
    
}
