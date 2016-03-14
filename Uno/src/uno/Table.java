/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.util.ArrayList;

/**
 *
 * @author Derek
 */
public class Table 
{
    Deck theDeck;
    ArrayList<Card> faceUpCards = new ArrayList<>();
    
    public Table(Deck deck)
    {
        theDeck = deck;
    }
    
    public Card drawCard()
    {
        return theDeck.getNext();
    }
    
    public void addToFaceUp(Card card)
    {
        faceUpCards.add(card);
    }
    
}
