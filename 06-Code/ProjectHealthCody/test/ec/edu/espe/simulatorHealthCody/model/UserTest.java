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
public class UserTest {

    public UserTest() {
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
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User("George", "230608441", "12/8/2001", "Masculino", "Gwchicango", "09George") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        String expResult = "George";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        User instance = new User("Jose", name, name, name, name, name) {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.name.equals(name)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = new User("", "2300608441", "", "", "", "") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        String expResult = "2300608441";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        User instance = new User(id, "2300608441", id, id, id, id) {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.id.equals(id)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getDateOfBirth method, of class User.
     */
    @Test
    public void testGetDateOfBirth() {
        System.out.println("getDateOfBirth");
        User instance = new User("", "", "Masculino", "", "", "") {
            @Override
            public void calculateAge() {
               System.out.println("Verify");
            }
        };
        String expResult = "Masculino";
        String result = instance.getDateOfBirth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setDateOfBirth method, of class User.
     */
    @Test
    public void testSetDateOfBirth() {
        System.out.println("setDateOfBirth");
        String dateOfBirth = "Masculino";
        User instance = new User("", "", dateOfBirth, "", "", "") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        instance.setDateOfBirth("");
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.dateOfBirth.equals(dateOfBirth)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getGender method, of class User.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        User instance = new User("", "", "", "", "", "") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        String expResult = "Femenino";
        String result = instance.getGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setGender method, of class User.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        String gender = "Masculino";
        User instance = new User("", "", "", "", "", "") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        instance.setGender(gender);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.gender.equals(gender)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getUserName method, of class User.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        User instance = new User("", "", "", "", "", "") {
            @Override
            public void calculateAge() {
               System.out.println("Verify");
            }
        };
        String expResult = "JW09323";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setUserName method, of class User.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "GJo302";
        User instance = new User("", "", "", "", "", "") {
            @Override
            public void calculateAge() {
               System.out.println("Verify");
            }
        };
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.userName.equals(userName)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getAccesKey method, of class User.
     */
    @Test
    public void testGetAccesKey() {
        System.out.println("getAccesKey");
        User instance = new User("", "", "", "", "", "08_jose") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        String expResult = "08_jose";
        String result = instance.getAccesKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setAccesKey method, of class User.
     */
    @Test
    public void testSetAccesKey() {
        System.out.println("setAccesKey");
        String accesKey = "0807Jose";
        User instance = new User(accesKey, accesKey, accesKey, accesKey, accesKey, accesKey) {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        instance.setAccesKey(accesKey);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.accesKey.equals(accesKey)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName2() {
        System.out.println("getName");
        User instance = new User("Kenneth", "12312312331231", "12/8/2001", "Masculino", "Gwchicango", "09George") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        String expResult = "George";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName2() {
        System.out.println("setName");
        String name = "";
        User instance = new User("", name, name, name, name, name) {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.name.equals(name)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId2() {
        System.out.println("getId");
        User instance = new User("", "", "2300608441", "", "", "") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        String expResult = "2300608441";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId2() {
        System.out.println("setId");
        String id = "";
        User instance = new User(id, "2300608441", id, id, id, id) {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.id.equals(id)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getDateOfBirth method, of class User.
     */
    @Test
    public void testGetDateOfBirth2() {
        System.out.println("getDateOfBirth");
        User instance = new User("", "", "Femenino", "", "", "") {
            @Override
            public void calculateAge() {
               System.out.println("Verify");
            }
        };
        String expResult = "Femenino";
        String result = instance.getDateOfBirth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setDateOfBirth method, of class User.
     */
    @Test
    public void testSetDateOfBirth2() {
        System.out.println("setDateOfBirth");
        String dateOfBirth = "Masculino";
        User instance = new User("", "", dateOfBirth, "", "", "") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        instance.setDateOfBirth("");
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.dateOfBirth.equals(dateOfBirth)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getGender method, of class User.
     */
    @Test
    public void testGetGender2() {
        System.out.println("getGender");
        User instance = new User("", "", "", "", "", "") {
            @Override
            public void calculateAge() {
                 System.out.println("Verify");
            }
        };
        String expResult = "Femenino";
        String result = instance.getGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setGender method, of class User.
     */
    @Test
    public void testSetGender2() {
        System.out.println("setGender");
        String gender = "Masculino";
        User instance = new User("", "", "", "", "", "") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        instance.setGender(gender);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.gender.equals(gender)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getUserName method, of class User.
     */
    @Test
    public void testGetUserName3() {
        System.out.println("getUserName");
        User instance = new User("", "", "JW09323", "", "", "") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        String expResult = "JW09323";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setUserName method, of class User.
     */
    @Test
    public void testSetUserName3() {
        System.out.println("setUserName");
        String userName = "GJo302";
        User instance = new User("", "", "", "GJo302", "", "") {
            @Override
            public void calculateAge() {
               System.out.println("Verify");
            }
        };
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.userName.equals(userName)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getAccesKey method, of class User.
     */
    @Test
    public void testGetAccesKey3() {
        System.out.println("getAccesKey");
        User instance = new User("", "", "08_jose", "", "", "08_jose") {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        String expResult = "08_jose";
        String result = instance.getAccesKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setAccesKey method, of class User.
     */
    @Test
    public void testSetAccesKey3() {
        System.out.println("setAccesKey");
        String accesKey = "LOLO";
        User instance = new User(accesKey, accesKey, accesKey, accesKey, accesKey, accesKey) {
            @Override
            public void calculateAge() {
                System.out.println("Verify");
            }
        };
        instance.setAccesKey(accesKey);
        // TODO review the generated test code and remove the default call to fail.
        if (!instance.accesKey.equals(accesKey)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString3() {
        System.out.println("toString");
        User instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

}
