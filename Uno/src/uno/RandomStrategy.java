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
            cardIndex = getHighestCard(faceUpCard);
        }
        else
        {
            cardIndex = getLowestCard(faceUpCard);
        }
        if(cardIndex == -1)
        {
            return null;
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
    
    private int getHighestCard(Card faceUpCard)
    {
        int maxCardIndex = -1;
        int maxCardValue = -1;
        
        
        
        for(Card c:hand)
        {
            //System.out.println(c);
            //System.out.println("c index = " + hand.indexOf(c));
            //System.out.println("hand = " + hand.size());
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
    
    private int getLowestCard(Card faceUpCard)
    {
        int lowestCardIndex = -1;
        int lowestCardValue = 100;
        System.out.println("Hand size = " + hand.size());
        for(Card c : hand)
        {
            //if(c != null)
            //{
               //System.out.println(hand.get(i));
                if(c.getColor() == faceUpCard.getColor() || c.getValue() == faceUpCard.getValue() || c.getColor() == 5)
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
    
    public String getStratName(){
        return "Random Strategy";
    }
    
}
