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
public class AggressiveStrategy extends Strategy
{
    ArrayList<Card> hand = new ArrayList<>();
    
    public Card playCard(Card faceUpCard)
    {
        //wild draw 4
        //draw two
        //skip
        //reverse
        //anything else
        
        int cardIndex = determineMax();
        Card retCard = hand.get(cardIndex);
        hand.remove(cardIndex);
        return retCard; // play the card with the higest values
    }
    
    public void takeCard(Card drawnCard)
    {
        hand.add(drawnCard);
    }
    
    public int getHandSize()
    {
        return hand.size();
    }
    
    private int determineMax()
    {
        int maxCardIndex = 0;
        int maxCardValue = 0;
        
        for(Card c:hand)
        {
            if(c.getValue() > maxCardValue)
            {
                maxCardValue = c.getValue();
                maxCardIndex = hand.indexOf(c);
            }           
        }
        return maxCardIndex; //we retunr the index in the hand so we can play the correct card
    }
    
}
