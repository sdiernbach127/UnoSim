/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.util.Collections;

/**
 *
 * @author Spencer Diernbach
 */
public class Game {
    int playerturn = 1;
    public Game (Strategy strat1, Strategy strat2){
        Deck deck= new Deck("UnoDeck.dat");
        
        /*
        Set Up
        strat1 draw 7, strat2 draw 7. 
        table show 1 from deck
        
        */
        
        
        //While game is not over
        if (playerturn ==1){
            Card toplay = strat1.playCard();
            if(toplay.getValue() == 'd'){
                
            player
        }
        if playerturn == 2
        strat2.playCard()
        
    }
    }   
    public boolean GameOver(){
        if (strat1.getHandSize() == 0)
            return true;
        if (strat2.getHandSize() == 0)
            return false;
        else
            return false;
    }
    public  Draw2Card(Strategy strat){
        strat.drawCard();
        strat.drawCard();
    } 
    
    public void Draw4Card(Strategy strat){
        strat.drawCard();
        strat.drawCard();
    } 
}
