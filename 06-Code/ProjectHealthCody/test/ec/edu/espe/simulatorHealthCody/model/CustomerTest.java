/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.simulatorHealthCody.model.Customer;
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
public class CustomerTest {

    public CustomerTest() {
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
     * Test of getCodeAppoinment method, of class Customer.
     */
    @Test
    public void testGetCodeAppoinment() {
        System.out.println("getCodeAppoinment");
        Customer instance = new Customer("", "", "", "", "", "");
        String expResult = "EFERGE";
        String result = instance.getCodeAppoinment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCodeAppoinment method, of class Customer.
     */
    @Test
    public void testSetCodeAppoinment() {
        System.out.println("setCodeAppoinment");
        String codeAppoinment = "HRSFGTF";
        Customer instance = new Customer("", "", "", "", "", "HRSFGTF");
        instance.setCodeAppoinment(codeAppoinment);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.accesKey.equals(codeAppoinment)) {
            fail("The test case is a prototype.");
        }
    }

}
