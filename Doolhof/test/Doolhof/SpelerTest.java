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
        
        @Test
        public void testSchietenbuitenmuur(){
        System.out.println("Pak een bazooka op en kijk of de buitenmuur vernietigd word, bij een geslaagde test blijft de muur bestaan.");
        Doolhof d = new Doolhof("src/Levels/level1.txt");
        Level level = d.getLevel();
        int rechts = KeyEvent.VK_RIGHT;
        int omlaag = KeyEvent.VK_DOWN;
        int schiet = KeyEvent.VK_SPACE;
        Speler instance = d.getSpeler();
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(schiet, level);
        Vakje[][] doolhofArray = d.getLevel().getDoolhofArray();
        assertTrue(doolhofArray[10][11].getObject() instanceof Muur);
        }
        
        @Test
        public void testSchietennormalemuur(){
        System.out.println("Pak een bazooka op en kijk of de normale muur vernietigd word, bij een geslaagde test is er geen object.");
        Doolhof d = new Doolhof("src/Levels/level1.txt");
        Level level = d.getLevel();
        int rechts = KeyEvent.VK_RIGHT;
        int omlaag = KeyEvent.VK_DOWN;
        int schiet = KeyEvent.VK_SPACE;
        Speler instance = d.getSpeler();
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        System.out.println("Richting : " + instance.getRichting());
        System.out.println("Heeft bazooka : " + instance.getHeeftBazooka());
        instance.actieBeweeg(schiet, level);
        System.out.println("Er is geschoten");
        System.out.println("Heeft bazooka : " + instance.getHeeftBazooka());
        Vakje[][] doolhofArray = d.getLevel().getDoolhofArray();
        assertTrue(doolhofArray[10][8].getObject() == null);
        }
        
        @Test
        public void testOppakkenBazooka(){
        System.out.println("Pak een bazooka op en kijk of de Speler de bazooka heeft, zo ja is de test geslaagd.");
        Doolhof d = new Doolhof("src/Levels/level1.txt");
        Level level = d.getLevel();
        int rechts = KeyEvent.VK_RIGHT;
        int omlaag = KeyEvent.VK_DOWN;
        Speler instance = d.getSpeler();
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(rechts, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(omlaag, level);
        instance.actieBeweeg(rechts, level);
        assertTrue(instance.getHeeftBazooka() == true);
        }
        
}
