/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.restful;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

/**
 *
 * @author e0146956
 */
public class ScheduleProgramTest {
    ScheduleProgram instance;
    
    public ScheduleProgramTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new ScheduleProgram();
        instance.setSpList(new ArrayList());
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getSpList method, of class ScheduleProgram.
     */
    @Test
    public void testGetSpList() {
        System.out.println("getSpList");
        List<ProgramSlot> expResult = null;
        List<ProgramSlot> result = instance.getSpList();
        assertNotNull(result);
    }

    /**
     * Test of setSpList method, of class ScheduleProgram.
     */
    @Test
    public void testSetSpList() {
        System.out.println("setSpList");
        List<ProgramSlot> spList = new ArrayList();
        instance.setSpList(spList);
    }
    
}
