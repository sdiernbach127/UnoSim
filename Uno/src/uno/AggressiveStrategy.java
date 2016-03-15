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
    boolean hasWild = false;
    
    public Card playCard(Card faceUpCard)
    {
        //wild draw 4
        //draw two
        //skip
        //reverse
        //anything else
        int cardColor = faceUpCard.getColor();
        int cardIndex = determineMax(faceUpCard);
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
    
    private int determineMax(Card faceUpCard)
    {
        int maxCardIndex = 0;
        int maxCardValue = 0;
        
        
        
        for(Card c:hand)
        {
            if(c.getColor() == 5)
            {
                if(c.getValue() == 1)
                {
                    maxCardIndex = hand.indexOf(c);
                    return maxCardIndex;
                }
            }
            else if(c.getColor() == faceUpCard.getColor())
            if(c.getValue() > maxCardValue)
            {
                maxCardValue = c.getValue();
                maxCardIndex = hand.indexOf(c);
            }           
        }
        if(maxCardValue == 0)
        {
            hasWild = true;
        }
        return maxCardIndex; //we retunr the index in the hand so we can play the correct card
    }
    
}
