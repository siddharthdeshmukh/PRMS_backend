/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author e0146956
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({sg.edu.nus.iss.phoenix.scheduleprogram.ScheduleprogramSuite.class, sg.edu.nus.iss.phoenix.user.UserSuite.class, sg.edu.nus.iss.phoenix.authenticate.AuthenticateSuite.class, sg.edu.nus.iss.phoenix.radioprogram.RadioprogramSuite.class})
public class PhoenixSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
