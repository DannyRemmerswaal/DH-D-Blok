/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.event.KeyEvent;
import static org.junit.Assert.assertTrue;
import org.junit.*;

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
        // Test lopen naar rechts zonder muur
        @Test
        public void testLopenRechts() {
        System.out.println("Lopen naar rechts naar een veld zonder muur");
        Doolhof d = new Doolhof("src/Levels/level1.txt");
        Level level = d.getLevel();
        int key = KeyEvent.VK_RIGHT;
        Speler instance = d.getSpeler();
        instance.actieBeweeg(key, level);
        Vakje[][] doolhofArray = d.getLevel().getDoolhofArray();
        assertTrue(doolhofArray[1][2].getObject() instanceof Speler);
    }
        
        @Test
        public void testLopenLinks() {
        System.out.println("Lopen naar links naar een veld zonder muur, bij een geslaagde test zal de speler op de huidige positie blijven");
        Doolhof d = new Doolhof("src/Levels/level1.txt");
        Level level = d.getLevel();
        int key = KeyEvent.VK_LEFT;
        Speler instance = d.getSpeler();
        instance.actieBeweeg(key, level);
        Vakje[][] doolhofArray = d.getLevel().getDoolhofArray();
        assertTrue(doolhofArray[1][1].getObject() instanceof Speler);
        }
}
