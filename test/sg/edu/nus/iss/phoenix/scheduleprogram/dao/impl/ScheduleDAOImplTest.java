/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.scheduleprogram.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.scheduleprogram.entity.ProgramSlot;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import org.powermock.modules.junit4.PowerMockRunner;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author e0146956
 */
@RunWith(PowerMockRunner.class)
public class ScheduleDAOImplTest {
    ScheduleDAOImpl instance;
    ProgramSlot valueObject;
    
    RadioProgram rp;
    String name ;
    Date progdate;
    Time startTime;
    int duration;
    
  @InjectMocks private ScheduleDAOImpl instanceSchDAO;
  @Mock private Connection mockConnection;
  @Mock private PreparedStatement mockStatement;

    
    public ScheduleDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        instance = new ScheduleDAOImpl();
        name = "testName";
        progdate = new Date(System.currentTimeMillis());
        startTime = new Time(System.currentTimeMillis());
        duration = 30;
        rp = new RadioProgram();
        valueObject = new ProgramSlot();
        valueObject.setAll(duration, progdate, startTime, rp,"presenter","producer");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createValueObject method, of class ScheduleDAOImpl.
     */
    @Test
    public void testCreateValueObject() {
        System.out.println("createValueObject");
        ProgramSlot result = instance.createValueObject();
        assertNotNull(result);
    }

    /**
     * Test of getObject method, of class ScheduleDAOImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetObject() throws Exception {
        System.out.println("getObject");
        ScheduleDAOImpl testObject = EasyMock.createMockBuilder(ScheduleDAOImpl.class)
                .addMockedMethod("load", ProgramSlot.class).createMock(); 
        String name = "testName";
        Date progdate = new Date(System.currentTimeMillis());
        int duration = 35;
       
        ProgramSlot result = testObject.getObject(name, progdate, duration);
        assertEquals(progdate, result.getDateOfProgram());
        assertEquals(duration, result.getDuration());

    }
//
//    /**
//     * Test of load method, of class ScheduleDAOImpl.
//     */
//    @Test
//    public void testLoad() throws Exception {
//        System.out.println("load");
//        Mockito.when(mockConnection.prepareStatement(Mockito.any())).thenReturn(mockStatement);
//
//        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
//        instance.load(valueObject);
//    }
//
//    /**
//     * Test of loadAll method, of class ScheduleDAOImpl.
//     */
//    @Test
//    public void testLoadAll() throws Exception {
//        System.out.println("loadAll");
//        ScheduleDAOImpl instance = new ScheduleDAOImpl();
//        List<ProgramSlot> expResult = null;
//        List<ProgramSlot> result = instance.loadAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of create method, of class ScheduleDAOImpl.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        ProgramSlot valueObject = null;
//        ScheduleDAOImpl instance = new ScheduleDAOImpl();
//        instance.create(valueObject);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of databaseUpdate method, of class ScheduleDAOImpl.
//     */
//    @Test
//    public void testDatabaseUpdate() throws Exception {
//        System.out.println("databaseUpdate");
//        PreparedStatement stmt = null;
//        ScheduleDAOImpl instance = new ScheduleDAOImpl();
//        int expResult = 0;
//        int result = instance.databaseUpdate(stmt);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of save method, of class ScheduleDAOImpl.
//     */
//    @Test
//    public void testSave() throws Exception {
//        System.out.println("save");
//        ProgramSlot valueObject = null;
//        ScheduleDAOImpl instance = new ScheduleDAOImpl();
//        instance.save(valueObject);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of singleQuery method, of class ScheduleDAOImpl.
//     */
//    @Test
//    public void testSingleQuery() throws Exception {
//        System.out.println("singleQuery");
//        PreparedStatement stmt = null;
//        ProgramSlot valueObject = null;
//        ScheduleDAOImpl instance = new ScheduleDAOImpl();
//        instance.singleQuery(stmt, valueObject);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listQuery method, of class ScheduleDAOImpl.
//     */
//    @Test
//    public void testListQuery() throws Exception {
//        System.out.println("listQuery");
//        PreparedStatement stmt = null;
//        ScheduleDAOImpl instance = new ScheduleDAOImpl();
//        List<ProgramSlot> expResult = null;
//        List<ProgramSlot> result = instance.listQuery(stmt);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class ScheduleDAOImpl.
//     */
//    @Test
//    public void testDelete() throws Exception {
//        System.out.println("delete");
//        ProgramSlot valueObject = null;
//        ScheduleDAOImpl instance = new ScheduleDAOImpl();
//        instance.delete(valueObject);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteAll method, of class ScheduleDAOImpl.
//     */
//    @Test
//    public void testDeleteAll() throws Exception {
//        System.out.println("deleteAll");
//        Connection conn = null;
//        ScheduleDAOImpl instance = new ScheduleDAOImpl();
//        instance.deleteAll(conn);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchMatching method, of class ScheduleDAOImpl.
//     */
//    @Test
//    public void testSearchMatching() throws Exception {
//        System.out.println("searchMatching");
//        ProgramSlot valueObject = null;
//        ScheduleDAOImpl instance = new ScheduleDAOImpl();
//        List<ProgramSlot> expResult = null;
//        List<ProgramSlot> result = instance.searchMatching(valueObject);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
