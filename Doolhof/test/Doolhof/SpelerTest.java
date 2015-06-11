/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.event.KeyEvent;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Hüseyin
 */
public class SpelerTest {
    
    public SpelerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actieBeweeg method, of class Speler.
     */
    @Test
    public void testActieBeweeg() {
        System.out.println("actieBeweeg");
        KeyEvent e = null;
        Level level = null;
        Speler instance = null;
        instance.actieBeweeg(e, level);
    }

    /**
     * Test of getRichting method, of class Speler.
     */
    @Test
    public void testGetRichting() {
        System.out.println("getRichting");
        Speler instance = null;
        Richting expResult = null;
        Richting result = instance.getRichting();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRichting method, of class Speler.
     */
    @Test
    public void testSetRichting() {
        System.out.println("setRichting");
        int keyCode = 0;
        Speler instance = null;
        instance.setRichting(keyCode);
    }

    /**
     * Test of schiet method, of class Speler.
     */
    @Test
    public void testSchiet() {
        System.out.println("schiet");
        int raketX = 0;
        int raketY = 0;
        Level level = null;
        Speler instance = null;
        instance.schiet(raketX, raketY, level);
    }

    /**
     * Test of getStappen method, of class Speler.
     */
    @Test
    public void testGetStappen() {
        System.out.println("getStappen");
        Speler instance = null;
        int expResult = 0;
        int result = instance.getStappen();
        assertEquals(expResult, result);
    }

    /**
     * Test of validKey method, of class Speler.
     */
    @Test
    public void testValidKey() {
        System.out.println("validKey");
        int key = 0;
        Speler instance = null;
        boolean expResult = false;
        boolean result = instance.validKey(key);
        assertEquals(expResult, result);
    }

    /**
     * Test of pakItemOp method, of class Speler.
     */
    @Test
    public void testPakItemOp() {
        System.out.println("pakItemOp");
        SpelItem object = null;
        Speler instance = null;
        instance.pakItemOp(object);
    }

    /**
     * Test of getMyVeld method, of class Speler.
     */
    @Test
    public void testGetMyVeld() {
        System.out.println("getMyVeld");
        Vakje expResult = null;
        Vakje result = Speler.getMyVeld();
        assertEquals(expResult, result);
    }
}
