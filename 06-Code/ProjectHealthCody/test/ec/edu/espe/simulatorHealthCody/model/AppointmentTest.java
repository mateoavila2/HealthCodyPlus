/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.simulatorHealthCody.model.Appointment;
import java.util.ArrayList;
import java.util.Date;
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
public class AppointmentTest {

    public AppointmentTest() {
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
     * Test of schedule method, of class Appointment.
     */
    @Test
    public void testSchedule() {
        System.out.println("schedule");
        Appointment instance = new Appointment("Schedule appointment");
        instance.schedule();
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.equals(instance)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of add method, of class Appointment.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String date = "DAT";
        String code = "FFGDG";
        Appointment instance = new Appointment("Schedule appointment");
        instance.add(date, code);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.equals(instance)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of show method, of class Appointment.
     */
    @Test
    public void testShow() throws Exception {
        System.out.println("show");
        Appointment instance = new Appointment("Schedule appointment");
        List<Date> expResult = new ArrayList<Date>();
        List<Date> result = instance.show();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of find method, of class Appointment.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String dataTofind = "Data";
        Appointment instance = new Appointment("Schedule appointment");
        instance.find(dataTofind);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.equals(dataTofind)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of delete method, of class Appointment.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int opc = -1;
        Appointment instance = new Appointment("Schedule appointment");
        String expResult = "1";
        String result = instance.delete(opc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (expResult != result) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getDatesOfWeek method, of class Appointment.
     */
    @Test
    public void testGetDatesOfWeek() {
        System.out.println("getDatesOfWeek");
        Appointment instance = new Appointment("Schedule appointment");
        List<Date> expResult = new ArrayList<>();
        List<Date> result = instance.getDatesOfWeek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setDatesOfWeek method, of class Appointment.
     */
    @Test
    public void testSetDatesOfWeek() {
        System.out.println("setDatesOfWeek");
        List<Date> datesOfWeek = null;
        Appointment instance = new Appointment("Schedule appointment");
        instance.setDatesOfWeek(datesOfWeek);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.equals(instance)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getCode method, of class Appointment.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        Appointment instance = new Appointment("Schedule appointment");
        String expResult = "FFEFEE";
        String result = instance.getCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCode method, of class Appointment.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String code = "";
        Appointment instance = new Appointment("Schedule appointment");
        instance.setCode(code);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.equals(instance)) {
            fail("The test case is a prototype.");
        }

    }

}
