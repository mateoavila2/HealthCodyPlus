/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

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
public class InventoryTest {

    public InventoryTest() {
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
     * Test of saveProduct method, of class Inventory.
     */
    @Test
    public void testSaveProduct() {// pendiente
        System.out.println("saveProduct");
        Product product = new Product(" ", "MC01", -0.32, -1);
        Inventory instance = new Inventory("Products");
        instance.saveProduct(product);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getProducts().equals(product)) {
            fail("The test case is a prototype.");
        }

    }

    /**
     * Test of showProducts method, of class Inventory.
     */
    @Test
    public void testShowProducts() {//
        System.out.println("showProducts");
        Inventory instance = new Inventory("Alcohol");
        String expResult = "";
        String result = instance.showProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findProduct method, of class Inventory.
     */
    @Test
    public void testFindProduct() {// 
        System.out.println("findProduct");
        String dataToFind = "Mascarilla";
        Inventory instance = new Inventory(dataToFind);
        String expResult = "";
        String result = instance.findProduct(dataToFind);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of updateProduct method, of class Inventory.
     */
    @Test
    public void testUpdateProduct() {// p
        System.out.println("updateProduct");
        String dataToFind = "Gel";
        String dataToUpdate = "Alcohol";
        String keyName = "name";
        Inventory instance = new Inventory("Products");
        instance.updateProduct(dataToFind, dataToUpdate, keyName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProduct method, of class Inventory.
     */
    @Test
    public void testDeleteProduct() {//p
        System.out.println("deleteProduct");
        String dataToDelete = "";
        String keyName = "";
        Inventory instance = new Inventory("Products");
        instance.deleteProduct(dataToDelete, keyName);
        // TODO review the generated test code and remove the default call to fail.

        fail("The test case is a prototype.");

    }

    /**
     * Test of getProducts method, of class Inventory.
     */
    @Test
    public void testGetProducts() {
        System.out.println("getProducts");
        Inventory instance = new Inventory("Mascarilla");
        List<Product> expResult = instance.getProducts();
        List<Product> result = instance.getProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setProducts method, of class Inventory.
     */
    @Test
    public void testSetProducts() {
        System.out.println("setProducts");
        List<Product> products = null;
        Inventory instance = new Inventory("Products");
        instance.setProducts(products);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCollectionName method, of class Inventory.
     */
    @Test
    public void testGetCollectionName() {
        System.out.println("getCollectionName");
        Inventory instance = new Inventory("Products");
        String expResult = "";
        String result = instance.getCollectionName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCollectionName method, of class Inventory.
     */
    @Test
    public void testSetCollectionName() {
        System.out.println("setCollectionName");
        String collectionName = "";
        Inventory instance = new Inventory("Products");
        instance.setCollectionName(collectionName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
