/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.restful;

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
@Suite.SuiteClasses({ sg.edu.nus.iss.phoenix.user.restful.UserListTest.class, sg.edu.nus.iss.phoenix.user.restful.ListOfProducersTest.class, sg.edu.nus.iss.phoenix.user.restful.ListOfPresentersTest.class})
public class RestfulSuite {

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
