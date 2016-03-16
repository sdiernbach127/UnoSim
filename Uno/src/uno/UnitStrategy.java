/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Derek
 */
public class UnitStrategy extends Strategy
{
    ArrayList<Card> hand = new ArrayList<>();
    
    public Card playCard(Card faceUpCard)
    {
       //first matching unit
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
    
    private int determineMax(Card faceUpCard)
    {
        int maxCardIndex = -1;
        int maxCardValue = -1;
        
        System.out.println("Hand Size: " + hand.size());
        for (Card c : hand){
            if (c.getValue()==faceUpCard.getValue()){//match value first
                maxCardIndex = hand.indexOf(c);
                return maxCardIndex;
            }
            
            if(c.getColor() == faceUpCard.getColor()){//match color next
                maxCardIndex = hand.indexOf(c);
                return maxCardIndex;
            }
            
            if(c.getColor() == 5){//then do wilds
                maxCardIndex = hand.indexOf(c);
                return maxCardIndex;
            }
        }
        
        return maxCardIndex;
    }
    
    public void takeCard(Card drawnCard)
    {
        hand.add(drawnCard);
    }
    
    public int getHandSize()
    {
        return hand.size();
    }
    
    public int chooseColor()
    {
        Random rand = new Random();
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
        if (color == 0)
            color = rand.nextInt(4) + 1;
        
        return color;                
        
    }
    
}
