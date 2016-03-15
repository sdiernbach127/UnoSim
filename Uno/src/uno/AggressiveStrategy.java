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
        int cardColor = faceUpCard.getColor();
        int cardIndex = determineMax(faceUpCard);
        
        if(cardIndex == -1)
        {
            return null; //if there isn't a playable card return null here
        }
        
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
        int maxCardIndex = -1;
        int maxCardValue = -1;
        
        
        
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
            if(c.getColor() == faceUpCard.getColor() || c.getValue() == faceUpCard.getValue())
            {
                if(c.getValue() > maxCardValue)
                {
                    maxCardValue = c.getValue(); // if the colors match or values match and we get a max card then go for it
                }
            }
        }
        
        if(maxCardIndex == -1) //if we still didn't find one
        {
            for(Card c: hand)
            {
                if(c.getColor() == 5)
                {
                    return hand.indexOf(c);
                }
            }
        }
        return maxCardIndex; //we retunr the index in the hand so we can play the correct card
    }
    
}
