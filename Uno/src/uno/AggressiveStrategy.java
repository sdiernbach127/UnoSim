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
    
    public Card playCard()
    {
        Card toPlay = hand.get(0);
        hand.remove(0);
        return toPlay;
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
