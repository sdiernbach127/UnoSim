/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Spencer
 */
public class GameTest {
    
    public GameTest() {
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
     * Test of playGame method, of class Game.
     */
    @org.junit.Test
    public void testPlayGame() {
        System.out.println("playGame");
        Strategy strat1 = null;
        Strategy strat2 = null;
        Game instance = new Game();
        int expResult = 0;
        int result = instance.playGame(strat1, strat2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GameOver method, of class Game.
     */
    @org.junit.Test
    public void testGameOver() {
        System.out.println("GameOver");
        Strategy strat1 = null;
        Strategy strat2 = null;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.GameOver(strat1, strat2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Draw2Card method, of class Game.
     */
    @org.junit.Test
    public void testDraw2Card() {
        System.out.println("Draw2Card");
        Strategy strat = null;
        Game instance = new Game();
        instance.Draw2Card(strat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Draw4Card method, of class Game.
     */
    @org.junit.Test
    public void testDraw4Card() {
        System.out.println("Draw4Card");
        Strategy strat = null;
        Game instance = new Game();
        instance.Draw4Card(strat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumTurns method, of class Game.
     */
    @org.junit.Test
    public void testGetNumTurns() {
        System.out.println("getNumTurns");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getNumTurns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getP1Draws method, of class Game.
     */
    @org.junit.Test
    public void testGetP1Draws() {
        System.out.println("getP1Draws");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getP1Draws();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getP2Draws method, of class Game.
     */
    @org.junit.Test
    public void testGetP2Draws() {
        System.out.println("getP2Draws");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getP2Draws();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
