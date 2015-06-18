/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author danny
 */
public class HelperTest {
    
    public HelperTest() {
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
     * Test of useItem method, of class Helper.
     */
        @Test
    public void testPadvinderLevel1() {
        System.out.println("");
        System.out.println("Test de mogelijke paden van level 1 & startpunt");
        Doolhof d = new Doolhof("src/Levels/level1.txt");
        Speler speler = d.getSpeler();
        Helper instance = new Helper();
        instance.zoekPad(speler.getMyVeld());
        int expected = 39;
        System.out.println("Het kortste pad is : " + instance.getKortstePad().size());
        assertEquals(instance.getKortstePad().size(), expected);
    }
        
        @Test
    public void testPadvinderLevel1Helperpositie() {
        System.out.println("");
        System.out.println("Test de mogelijke paden van level 1 & positie helper");
        Doolhof d = new Doolhof("src/Levels/level1.txt");
        Helper instance = new Helper();
        Vakje[][] doolhofArray = d.getLevel().getDoolhofArray();
        instance.zoekPad(doolhofArray[8][6]);
        int expected = 41;
        System.out.println("Het kortste pad is : " + instance.getKortstePad().size());
        assertEquals(instance.getKortstePad().size(), expected);
    }
        @Test
    public void testPadvinderLevel2Helperpositie() {
        System.out.println("");
        System.out.println("Test de mogelijke paden van level 2 & positie helper");
        Doolhof d = new Doolhof("src/Levels/level2.txt");
        Helper instance = new Helper();
        Vakje[][] doolhofArray = d.getLevel().getDoolhofArray();
        instance.zoekPad(doolhofArray[8][5]);
        int expected = 24;
        System.out.println("Het kortste pad is : " + instance.getKortstePad().size());
        assertEquals(instance.getKortstePad().size(), expected);
    }
                
        @Test
    public void testPadvinderLevel3() {
        System.out.println("");
        System.out.println("Test de mogelijke paden van level 3 & startpunt speler.");
        Doolhof d = new Doolhof("src/Levels/level3.txt");
        Speler speler = d.getSpeler();
        Helper instance = new Helper();
        instance.zoekPad(speler.getMyVeld());
        int expected = 27;
        System.out.println("Het kortste pad is : " + instance.getKortstePad().size());
        assertEquals(instance.getKortstePad().size(), expected);
    }
        
        @Test
    public void testPadvinderLevel3Helperpositie() {
        System.out.println("");
        System.out.println("Test de mogelijke paden van level 3 & positie helper.");
        Doolhof d = new Doolhof("src/Levels/level3.txt");
        Helper instance = new Helper();
        Vakje[][] doolhofArray = d.getLevel().getDoolhofArray();
        instance.zoekPad(doolhofArray[9][2]);
        int expected = 32;
        System.out.println("Het kortste pad is : " + instance.getKortstePad().size());
        assertEquals(instance.getKortstePad().size(), expected);
    }
}
