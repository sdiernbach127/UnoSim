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
        System.out.println("Playing card");
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
    
}
