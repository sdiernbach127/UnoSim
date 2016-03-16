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
public class PassiveStrategy extends Strategy
{
    ArrayList<Card> hand = new ArrayList<>();
    
    public Card playCard(Card faceUp)
    {
        int cardIndex = determineLowestCard(faceUp);
        if(cardIndex == -1)
        {
            return null;
        }   
        //System.out.println("retIndex = " + cardIndex + " and hand = " + hand.size());
        Card retCard = this.hand.get(cardIndex);
        this.hand.remove(cardIndex);
        return retCard; // play the lowest card in the hand
    }
    
    public void takeCard(Card drawnCard)
    {
        this.hand.add(drawnCard);
    }
    
    public int getHandSize()
    {
        return this.hand.size();
    }
    
    private int determineLowestCard(Card faceUp) // does this count as passive?
    {
        int lowestCardIndex = -1;
        int lowestCardValue = 100;
        System.out.println("Hand size = " + hand.size());
        for(Card c : hand)
        {
            //if(c != null)
            //{
               //System.out.println(hand.get(i));
                if(c.getColor() == faceUp.getColor() || c.getValue() == faceUp.getValue() || c.getColor() == 5)
                {
                    if(c.getValue() < lowestCardValue)
                    {
                        lowestCardValue = c.getValue();
                        lowestCardIndex = hand.indexOf(c);
                    }
                }
            //}
        }
        
        //System.out.println("Index = " + lowestCardIndex + " and hand size = " + hand.size());
        return lowestCardIndex; // we want to return the index of the lowest card
    }
    
    public int chooseColor()
    {
        Random rand = new Random();
        int[] colors = new int[6];
        int color = 0; //set color we have the most of to 0
        
        for(Card c: this.hand)
        {
           //System.out.println(c.getColor());
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
