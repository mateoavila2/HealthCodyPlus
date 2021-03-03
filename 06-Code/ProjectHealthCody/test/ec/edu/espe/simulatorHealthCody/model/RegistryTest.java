/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
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
public class RegistryTest {

    public RegistryTest() {
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
     * Test of register method, of class Registry.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        User user = null;
        Registry instance = null;
        instance.register(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showUsers method, of class Registry.
     */
    @Test
    public void testShowUsers() {
        System.out.println("showUsers");
        Registry instance = new Registry("Customers");
        String expResult = "Customers";
        String result = instance.showUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findUser method, of class Registry.
     */
    @Test
    public void testFindUser() {
        System.out.println("findUser");
        String dataToFind = "";
        Registry instance = null;
        String expResult = "";
        String result = instance.findUser(dataToFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class Registry.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        String dataToFind = "";
        String dataToUpdate = "";
        String keyName = "";
        Registry instance = null;
        instance.updateUser(dataToFind, dataToUpdate, keyName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class Registry.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        String dataToDelete = "";
        String keyName = "";
        Registry instance = null;
        instance.deleteUser(dataToDelete, keyName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class Registry.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        Registry instance = new Registry("Customers");
        List<User> expResult = new ArrayList<User>();
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setUsers method, of class Registry.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        List<User> users = null;
        Registry instance = null;
        instance.setUsers(users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCollenctionName method, of class Registry.
     */
    @Test
    public void testGetCollenctionName() {
        System.out.println("getCollenctionName");
        Registry instance = new Registry("Customers");
        String expResult = "Customers";
        String result = instance.getCollenctionName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCollenctionName method, of class Registry.
     */
    @Test
    public void testSetCollenctionName() {
        System.out.println("setCollenctionName");
        String collenctionName = "";
        Registry instance = null;
        instance.setCollenctionName(collenctionName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
        /**
     * Test of register method, of class Registry.
     */
    @Test
    public void testRegister2() {
        System.out.println("reg");
        User user = null;
        Registry instance = null;
        instance.register(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showUsers method, of class Registry.
     */
    @Test
    public void testShowUsers2() {
        System.out.println("showUsers");
        Registry instance = new Registry("Employees");
        String expResult = "Employees";
        String result = instance.showUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findUser method, of class Registry.
     */
    @Test
    public void testFindUser2() {
        System.out.println("findUser");
        String dataToFind = "";
        Registry instance = null;
        String expResult = "";
        String result = instance.findUser(dataToFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class Registry.
     */
    @Test
    public void testUpdateUser2() {
        System.out.println("updateUser");
        String dataToFind = "";
        String dataToUpdate = "";
        String keyName = "";
        Registry instance = null;
        instance.updateUser(dataToFind, dataToUpdate, keyName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class Registry.
     */
    @Test
    public void testDeleteUser2() {
        System.out.println("deleteUser");
        String dataToDelete = "";
        String keyName = "";
        Registry instance = null;
        instance.deleteUser(dataToDelete, keyName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class Registry.
     */
    @Test
    public void testGetUsers2() {
        System.out.println("getUsers");
        Registry instance = new Registry("Customers");
        List<User> expResult = new ArrayList<User>();
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setUsers method, of class Registry.
     */
    @Test
    public void testSetUsers2() {
        System.out.println("setUsers");
        List<User> users = null;
        Registry instance = null;
        instance.setUsers(users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCollenctionName method, of class Registry.
     */
    @Test
    public void testGetCollenctionName2() {
        System.out.println("getCollenctionName");
        Registry instance = new Registry("Employees");
        String expResult = "Employees";
        String result = instance.getCollenctionName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCollenctionName method, of class Registry.
     */
    @Test
    public void testSetCollenctionName2() {
        System.out.println("setCollenctionName");
        String collenctionName = " ";
        Registry instance = null;
        instance.setCollenctionName(collenctionName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
            /**
     * Test of register method, of class Registry.
     */
    @Test
    public void testRegister3() {
        System.out.println("reglop");
        User user = null;
        Registry instance = null;
        instance.register(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showUsers method, of class Registry.
     */
    @Test
    public void testShowUsers3() {
        System.out.println("showUsers");
        Registry instance = new Registry("Custom");
        String expResult = "ustom";
        String result = instance.showUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findUser method, of class Registry.
     */
    @Test
    public void testFindUser3() {
        System.out.println("findUser");
        String dataToFind = "";
        Registry instance = null;
        String expResult = "";
        String result = instance.findUser(dataToFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class Registry.
     */
    @Test
    public void testUpdateUser3() {
        System.out.println("updateUser");
        String dataToFind = "";
        String dataToUpdate = "";
        String keyName = "";
        Registry instance = null;
        instance.updateUser(dataToFind, dataToUpdate, keyName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class Registry.
     */
    @Test
    public void testDeleteUser3() {
        System.out.println("deleteUser");
        String dataToDelete = "";
        String keyName = "";
        Registry instance = null;
        instance.deleteUser(dataToDelete, keyName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class Registry.
     */
    @Test
    public void testGetUsers3() {
        System.out.println("getUsers");
        Registry instance = new Registry("Customers");
        List<User> expResult = new ArrayList<User>();
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setUsers method, of class Registry.
     */
    @Test
    public void testSetUsers3() {
        System.out.println("setUsers");
        List<User> users = null;
        Registry instance = null;
        instance.setUsers(users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCollenctionName method, of class Registry.
     */
    @Test
    public void testGetCollenctionName3() {
        System.out.println("getCollenctionName");
        Registry instance = new Registry("Employees");
        String expResult = "Employees";
        String result = instance.getCollenctionName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCollenctionName method, of class Registry.
     */
    @Test
    public void testSetCollenctionName3() {
        System.out.println("setCollenctionName");
        String collenctionName = " ";
        Registry instance = null;
        instance.setCollenctionName(collenctionName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
