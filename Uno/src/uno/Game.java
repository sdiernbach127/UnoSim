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
        /*
        Set Up
        strat1 draw 7, strat2 draw 7. 
        table show 1 from deck
        */
        Deck deck= new Deck("UnoDeck.dat");
        Table table = new Table(deck);
        for(int start = 0; start <= 7; start ++){
            strat1.takeCard(table.drawCard());
            strat2.takeCard(table.drawCard());
        }
        table.addToFaceUp(table.drawCard());
        
        
        
        //While game is not over
        while(GameOver() != true)
        if (playerturn ==1){
            Card toplay = strat1.playCard();
            if(toplay.getValue() == 'd'){
                Draw2Card(strat2);
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
    public static void Draw2Card(Strategy strat){
        strat.//drawCard from deck
        strat.//drawCard from deck
    } 
    
    public void Draw4Card(Strategy strat){
        strat.//drawCard from deck
        strat.//drawCard from deck
        strat.//drawCard from deck
        strat.//drawCard from deck
    } 
}
