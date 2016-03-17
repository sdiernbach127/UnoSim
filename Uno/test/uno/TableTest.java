/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.util.ArrayList;
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
public class TableTest {
    
    public TableTest() {
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
     * Test of drawCard method, of class Table.
     */
    @org.junit.Test
    public void testDrawCard() {
        System.out.println("drawCard");
        Table instance = null;
        Card expResult = null;
        Card result = instance.drawCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToFaceUp method, of class Table.
     */
    @org.junit.Test
    public void testAddToFaceUp() {
        System.out.println("addToFaceUp");
        Card card = null;
        Table instance = null;
        instance.addToFaceUp(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of topUp method, of class Table.
     */
    @org.junit.Test
    public void testTopUp() {
        System.out.println("topUp");
        Table instance = null;
        Card expResult = null;
        Card result = instance.topUp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of emptyDeck method, of class Table.
     */
    @org.junit.Test
    public void testEmptyDeck() {
        System.out.println("emptyDeck");
        Table instance = null;
        boolean expResult = false;
        boolean result = instance.emptyDeck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takePile method, of class Table.
     */
    @org.junit.Test
    public void testTakePile() {
        System.out.println("takePile");
        Table instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.takePile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
