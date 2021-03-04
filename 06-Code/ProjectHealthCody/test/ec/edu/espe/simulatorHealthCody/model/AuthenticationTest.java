/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.simulatorHealthCody.model.Authentication;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author George
 */
public class AuthenticationTest {
    
    public AuthenticationTest() {
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
     * Test of login method, of class Authentication.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String userName = "rebuse";
        String accesKey = "rebuse";
        Authentication instance = new  Authentication("Customers");
        boolean expResult = true;
        boolean result = instance.login(userName, accesKey);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!expResult) {
            fail("The test case is a prototype.");
        }
    }
    
}
