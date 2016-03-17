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
    
    Deck deck= new Deck("UnoDeck.dat");
    Table table = new Table(deck);

    /**
     * Test of drawCard method, of class Table.
     */
    @Test
    public void testDrawCard() {
        //we need to make it so Deck doesn't shuffle right when it's created, so we can test a steady deck
    }

    //this tests topUp and addToFaceUp
    @org.junit.Test
    public void testAddToFaceUp() {
        Card testCard = table.drawCard();
        table.addToFaceUp(testCard);
        assertEquals(testCard, table.topUp());
    }


    /**
     * Test of emptyDeck method, of class Table.
     */
    @org.junit.Test
    public void testEmptyDeck() {
        for (int i = 0; i < 108; i++){
            table.drawCard();
        }
        assertEquals(true,table.emptyDeck());
    }

    /**
     * Test of takePile method, of class Table.
     */
    @org.junit.Test
    public void testTakePile() {
        ArrayList<Card> testCards = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Card addCard = table.drawCard();
            testCards.add(addCard);
        }
        assertEquals(true,testCards.containsAll(table.takePile()));
    }
    
}
