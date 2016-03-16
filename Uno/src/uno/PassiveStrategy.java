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
public class PassiveStrategy extends Strategy
{
    ArrayList<Card> hand = new ArrayList<>();
    
    public Card playCard(Card faceUp)
    {
        int cardIndex = determineLowestCard();
        Card retCard = hand.get(cardIndex);
        hand.remove(cardIndex);
        return hand.get(cardIndex); // play the lowest card in the hand
    }
    
    public void takeCard(Card drawnCard)
    {
        hand.add(drawnCard);
    }
    
    public int getHandSize()
    {
        return hand.size();
    }
    
    private int determineLowestCard() // does this count as passive?
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
    
    public int chooseColor()
    {
        
        int[] colors = new int[6];
        int color = 0; //set color we have the most of to 0
        
        for(Card c: hand)
        {
            colors[c.getColor()] += 1;
        }
            
        for(int i = 1; i < 5; i++)
        {
            if(colors[i] > color)
            {
                color = i; // color is the index, colors[i] is the amount of occurences of that color
            }
        }
        
        return color;                
        
    }
    
}
