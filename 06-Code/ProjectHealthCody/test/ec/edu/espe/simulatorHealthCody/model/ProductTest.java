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
public class ProductTest {

    public ProductTest() {
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
     * Test of getNameProduct method, of class Product.
     */
    @Test
    public void testGetNameProduct() {
        System.out.println("getNameProduct");
        Product instance = new Product("Mascarilla", "", 0, 0);
        String expResult = "Mascarilla";
        String result = instance.getNameProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setNameProduct method, of class Product.
     */
    @Test
    public void testSetNameProduct() {
        System.out.println("setNameProduct");
        String nameProduct = "Gel";
        Product instance = new Product("", "", 0, 0);
        instance.setNameProduct(nameProduct);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getNameProduct().equals(nameProduct)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getCodeProduct method, of class Product.
     */
    @Test
    public void testGetCodeProduct() {
        System.out.println("getCodeProduct");
        Product instance = new Product("", "", 0, 0);
        String expResult = "HV12";
        String result = instance.getCodeProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCodeProduct method, of class Product.
     */
    @Test
    public void testSetCodeProduct() {
        System.out.println("setCodeProduct");
        String codeProduct = "HDR-23";
        Product instance = new Product("", "", 0, 0);
        instance.setCodeProduct(codeProduct);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getCodeProduct().equals(codeProduct)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getPriceProduct method, of class Product.
     */
    @Test
    public void testGetPriceProduct() {
        System.out.println("getPriceProduct");
        Product instance = new Product("", "", -2.0, 0);
        double expResult = 2.0;
        double result = instance.getPriceProduct();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPriceProduct method, of class Product.
     */
    @Test
    public void testSetPriceProduct() {
        System.out.println("setPriceProduct");
        double priceProduct = -0.34;
        Product instance = new Product("", "", 0.34, 0);
        instance.setPriceProduct(priceProduct);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getPriceProduct() != priceProduct) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getQuantity method, of class Product.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Product instance = new Product( "", "", 0, 3);
        int expResult = 3;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setQuantity method, of class Product.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 10;
        Product instance = new Product("", "", 0, 0);
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getQuantity()!= quantity) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Product instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
        /**
     * Test of getNameProduct method, of class Product.
     */
    @Test
    public void testGetNameProduct2() {
        System.out.println("getNameProduct");
        Product instance = new Product("Guantes", "", 0, 0);
        String expResult = "Guantes";
        String result = instance.getNameProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setNameProduct method, of class Product.
     */
    @Test
    public void testSetNameProduct2() {
        System.out.println("setNameProduct");
        String nameProduct = "Alcohol";
        Product instance = new Product("", "", 0, 0);
        instance.setNameProduct(nameProduct);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getNameProduct().equals(nameProduct)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getCodeProduct method, of class Product.
     */
    @Test
    public void testGetCodeProduct2() {
        System.out.println("getCodeProduct");
        Product instance = new Product("", "", 0, 0);
        String expResult = "HV12";
        String result = instance.getCodeProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCodeProduct method, of class Product.
     */
    @Test
    public void testSetCodeProduct2() {
        System.out.println("setCodeProduct");
        String codeProduct = "HDR-23";
        Product instance = new Product("", "", 0, 0);
        instance.setCodeProduct(codeProduct);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getCodeProduct().equals(codeProduct)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getPriceProduct method, of class Product.
     */
    @Test
    public void testGetPriceProduct2() {
        System.out.println("getPriceProduct");
        Product instance = new Product("", "", 17, 0);
        double expResult = 17;
        double result = instance.getPriceProduct();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPriceProduct method, of class Product.
     */
    @Test
    public void testSetPriceProduct2() {
        System.out.println("setPriceProduct");
        double priceProduct = 0.34;
        Product instance = new Product("", "", 0.34, 0);
        instance.setPriceProduct(priceProduct);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getPriceProduct() != priceProduct) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getQuantity method, of class Product.
     */
    @Test
    public void testGetQuantity2() {
        System.out.println("getQuantity");
        Product instance = new Product( "", "", 0, 48);
        int expResult = 48;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setQuantity method, of class Product.
     */
    @Test
    public void testSetQuantity2() {
        System.out.println("setQuantity");
        int quantity = 10;
        Product instance = new Product("", "", 0, 10);
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getQuantity()!= quantity) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString2() {
        System.out.println("toString");
        Product instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
        /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString3() {
        System.out.println("toString");
        Product instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
        /**
     * Test of getNameProduct method, of class Product.
     */
    @Test
    public void testGetNameProduct3() {
        System.out.println("getNameProduct");
        Product instance = new Product("Guantes", "", 0, 0);
        String expResult = "Guantes";
        String result = instance.getNameProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setNameProduct method, of class Product.
     */
    @Test
    public void testSetNameProduct3() {
        System.out.println("setNameProduct");
        String nameProduct = "Alcohol";
        Product instance = new Product("", "", 0, 0);
        instance.setNameProduct(nameProduct);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getNameProduct().equals(nameProduct)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getCodeProduct method, of class Product.
     */
    @Test
    public void testGetCodeProduct3() {
        System.out.println("getCodeProduct");
        Product instance = new Product("", "", 0, 0);
        String expResult = "HV12";
        String result = instance.getCodeProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCodeProduct method, of class Product.
     */
    @Test
    public void testSetCodeProduct3() {
        System.out.println("setCodeProduct");
        String codeProduct = "HDR-23";
        Product instance = new Product("", "", 0, 0);
        instance.setCodeProduct(codeProduct);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.getCodeProduct().equals(codeProduct)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getPriceProduct method, of class Product.
     */
    @Test
    public void testGetPriceProduct3() {
        System.out.println("getPriceProduct");
        Product instance = new Product("", "", 17, 0);
        double expResult = 17;
        double result = instance.getPriceProduct();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setPriceProduct method, of class Product.
     */
    @Test
    public void testSetPriceProduct3() {
        System.out.println("setPriceProduct");
        double priceProduct = 0.34;
        Product instance = new Product("", "", 0.34, 0);
        instance.setPriceProduct(priceProduct);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getPriceProduct() != priceProduct) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getQuantity method, of class Product.
     */
    @Test
    public void testGetQuantity3() {
        System.out.println("getQuantity");
        Product instance = new Product( "", "", 0, 48);
        int expResult = 48;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result != expResult) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setQuantity method, of class Product.
     */
    @Test
    public void testSetQuantity3() {
        System.out.println("setQuantity");
        int quantity = 10;
        Product instance = new Product("", "", 0, 10);
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        if (instance.getQuantity()!= quantity) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString4() {
        System.out.println("toString");
        Product instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
