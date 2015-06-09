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
        KeyEvent expResult = null;
        KeyEvent result = instance.getRichting();
        assertEquals(expResult, result);
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
}
