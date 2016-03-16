/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

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
        System.out.println("drawnCard = " + drawnCard);
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
            System.out.println(c);
            //System.out.println("c index = " + hand.indexOf(c));
            System.out.println("hand = " + hand.size());
            if(c.getColor() == 5)
            {
                if(c.getValue() == 14)
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
                    maxCardIndex = hand.indexOf(c);
                }
            }
        }
        
        if(maxCardIndex == -1) //if we still didn't find one
        {
            for(Card c: hand)
            {
                if(c.getColor() == 5)
                {
                    return hand.indexOf(c); //figure out how to say color change
                }
            }
        }
        return maxCardIndex; //we retunr the index in the hand so we can play the correct card
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
