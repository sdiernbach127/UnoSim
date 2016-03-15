/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;
import java.util.Random;

import java.util.ArrayList;

/**
 *
 * @author Derek
 */
public class RandomStrategy extends Strategy
{
    ArrayList<Card> hand = new ArrayList<>();
    
    public Card playCard(Card faceUpCard)
    {
        int cardIndex = 0;
        Random rand = new Random();
        
        // We can do the following or just play the hand in order of how we have it.
        if(rand.nextDouble() > 0.5)
        {
            cardIndex = getHighestCard();
        }
        else
        {
            cardIndex = getLowestCard();
        }
        Card retCard = hand.get(cardIndex);
        hand.remove(cardIndex);
        return retCard;
    }
    
    public void takeCard(Card drawnCard)
    {
        hand.add(drawnCard);
    }
    
    public int getHandSize()
    {
        return hand.size();
    }
    
    private int getHighestCard()
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
    
    private int getLowestCard()
    {
        int lowestCardIndex = 0;
        int lowestCardValue = 0;
        
        for(Card c : hand)
        {
            if(c.getValue() < lowestCardValue)
            {
                lowestCardValue = c.getValue();
                lowestCardIndex = hand.indexOf(c);
            }
        }
        return lowestCardIndex; // we want to return the index of the lowest card
    }
    
}
