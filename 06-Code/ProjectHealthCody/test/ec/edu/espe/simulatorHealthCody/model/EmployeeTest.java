/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

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
public class EmployeeTest {

    public EmployeeTest() {
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
     * Test of generateCode method, of class Employee.
     */
    /*@Test
    public void testGenerateCode() {
        System.out.println("generateCode");
        Employee instance = new Employee("", "", "", "", "", "", "");
        String expResult = "HHGFDSA";
        String result = instance.generateCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }*/

    /**
     * Test of getSalary method, of class Employee.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Employee instance = new Employee("", "", "", "", "", "", "");
        double expResult = 234.32;
        double result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setSalary method, of class Employee.
     */
    @Test
    public void testSetSalary() {
        System.out.println("setSalary");
        double salary = -1300.0;
        Employee instance = new Employee("", "", "", "", "", "", "");
        instance.setSalary(salary);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getSalary() != salary) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getNumberPhone method, of class Employee.
     */
    @Test
    public void testGetNumberPhone() {
        System.out.println("getNumberPhone");
        Employee instance = new Employee("", "", "", "", "0981297292", "", "");
        String expResult = "0981297292";
        String result = instance.getNumberPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setNumberPhone method, of class Employee.
     */
    @Test
    public void testSetNumberPhone() {
        System.out.println("setNumberPhone");
        String numberPhone = "0990073142";
        Employee instance = new Employee("", "", "", "", "", "", "");
        instance.setNumberPhone(numberPhone);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getNumberPhone().equals(numberPhone)) {
            fail("The test case is a prototype.");
        }
    }

}
