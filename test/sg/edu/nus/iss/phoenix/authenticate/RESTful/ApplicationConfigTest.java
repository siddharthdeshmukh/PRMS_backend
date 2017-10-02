/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.authenticate.RESTful;

import java.util.Set;
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
public class ApplicationConfigTest {
    
    public ApplicationConfigTest() {
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
     * Test of getClasses method, of class ApplicationConfig.
     */
    @Test
    public void testGetClasses() {
        System.out.println("getClasses");
        ApplicationConfig instance = new ApplicationConfig();
        
        Set<Class<?>> expResult = new java.util.HashSet<>();
        expResult.add(sg.edu.nus.iss.phoenix.authenticate.RESTful.AuthenticateRESTService.class);
        expResult.add(sg.edu.nus.iss.phoenix.radioprogram.restful.ProgramRESTService.class);
        expResult.add(sg.edu.nus.iss.phoenix.scheduleprogram.restful.ScheduleRESTService.class);
        expResult.add(sg.edu.nus.iss.phoenix.user.restful.PresenterProducerRESTService.class);
        expResult.add(sg.edu.nus.iss.phoenix.user.restful.UserRESTService.class);
        
        Set<Class<?>> result = instance.getClasses();
        assertEquals(expResult, result);
    }
    
}
