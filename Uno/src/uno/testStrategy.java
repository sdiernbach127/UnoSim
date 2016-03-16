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
public class testStrategy extends Strategy
{
    ArrayList<Card> hand = new ArrayList();
    
    @Override
    public Card playCard(Card faceUpCard) 
    {
        Card temp;
        for(int i = 0; i < hand.size(); i++)
        {
            System.out.println("Check if Card = " + hand.get(i) + " and its index = " + i + " hand size = " + hand.size());
            if(hand.get(i).getColor() == faceUpCard.getColor() || hand.get(i).getValue() == faceUpCard.getValue() || hand.get(i).getColor() == 5)
            {
                temp = hand.get(i);
                hand.remove(hand.get(i));
                return temp;
            }
        }
        return null;
    }

    @Override
    public void takeCard(Card drawnCard) 
    {
        hand.add(drawnCard);
    }

    @Override
    public int getHandSize() 
    {
        return hand.size();
    }

    @Override
    public int chooseColor() 
    {
        int[] colors = new int[6];
        int color = 0; //set color we have the most of to 0
        
        for(Card c: hand)
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
        
        return color;    
    }
    
}
