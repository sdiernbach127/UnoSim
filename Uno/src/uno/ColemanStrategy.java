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
public class ColemanStrategy extends Strategy
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
        //System.out.println("drawnCard = " + drawnCard);
        hand.add(drawnCard);
    }
    
    public int getHandSize()
    {
        return hand.size();
    }
    
    private int determineMax(Card faceUpCard)
    {
        int chooseCardIndex = -1;
    
        
        
        for(Card c:hand)
        {
             if(c.getColor() == faceUpCard.getColor())
            {
                if(c.getValue() == 10 | c.getValue() == 11)
                {
                    chooseCardIndex = hand.indexOf(c);
                }
                
                else if (c.getValue() < 10)
                {
                    chooseCardIndex = hand.indexOf(c);
                }
                
                else
                {
                    chooseCardIndex =  hand.indexOf(c);
                }
            }
        }
         
        if(chooseCardIndex == -1) //if we still didn't find one
        {
            for(Card c: hand)
            {
                if(c.getColor() == 5)
                {
                    return hand.indexOf(c); //figure out how to say color change
                }
            }
        } 
        return chooseCardIndex; //we retunr the index in the hand so we can play the correct card
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
    public String getStratName(){
        return "Coleman Strategy";
    }
}
