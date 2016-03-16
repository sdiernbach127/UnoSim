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
    public Card topUp()
    {
        return faceUpCards.get(faceUpCards.size()-1);
    }
    
    public boolean emptyDeck()
    {
        if(theDeck.hasNext() == false)
        {
            return true;
        }
        return false;
        
    }
    public ArrayList takePile()
    {
        ArrayList<Card> ret = faceUpCards;
        faceUpCards = new ArrayList<>();
        return ret;
    }
    
}
