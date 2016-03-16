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
public class ColorStrategy extends Strategy
{
    ArrayList<Card> hand = new ArrayList<>();
    
    public Card playCard(Card faceUpCard)
    {
        System.out.println("Hand Size: " + hand.size());
        for(int i = 0; i < hand.size() - 1; i++){
            if (hand.get(i).getColor()==faceUpCard.getColor()){
                Card toPlay = hand.get(i);
                hand.remove(i);
                return toPlay;
            }
        }
        for(int i = 0; i < hand.size() - 1; i++){
            if (hand.get(i).getValue() == faceUpCard.getValue()){
                Card toPlay = hand.get(i);
                hand.remove(i);
                return toPlay;
            }
        }
        for(int i = 0; i < hand.size() - 1; i++){
            if (hand.get(i).getValue() == 5){
                Card toPlay = hand.get(i);
                hand.remove(i);
                return toPlay;
            }
        }
        return null;
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
