/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

/**
 *
 * @author Spencer Diernbach
 */
public class Game {
    int playerturn = 1;
    Deck deck= new Deck("UnoDeck.dat");
    Table table = new Table(deck);
    public Game (Strategy strat1, Strategy strat2){
        /*
        Set Up
        strat1 draw 7, strat2 draw 7. 
        table show 1 from deck
        */
        for(int start = 0; start <= 7; start ++){
            strat1.takeCard(table.drawCard());
            strat2.takeCard(table.drawCard());
        }
        table.addToFaceUp(table.drawCard());
        
        
        
        //While game is not over
        while(GameOver(strat1, strat2) != true){
            if (playerturn == 1){
                Card toplay = strat1.playCard();
                
                //check to make sure card is playable. add for wild cards
                if (toplay.getColor() == 'W'){
                    //we need to figure out how to play wilds
                    if (toplay.getValue() == 'D'){
                        Draw4Card(strat2);
                        playerturn = 1;
                    }
                }
                
                if (toplay.getColor() != table.topUp().getColor() || toplay.getValue() != table.topUp().getValue())
                    System.out.print("Exception: card doesn't match");
                table.addToFaceUp(toplay);
                
                if (toplay.getValue() == 'd'){
                    Draw2Card(strat2);
                    //current rule same player
                    playerturn = 1;                
                } 
                
                if (toplay.getValue() == 'S')
                    playerturn = 1;
                
                if (toplay.getValue() == 'R')
                    playerturn = 1;
                
                
            }   
        }
    }
    
    public boolean GameOver(Strategy strat1, Strategy strat2){
        if (strat1.getHandSize() == 0)
            return true;
        if (strat2.getHandSize() == 0)
            return false;
        else
            return false;
    }
    
    public void Draw2Card(Strategy strat){
        strat.takeCard(table.drawCard());//drawCard from deck, we need to acces table here
        strat.takeCard(table.drawCard());
    } 
    
    public void Draw4Card(Strategy strat){
        strat.takeCard(table.drawCard());//drawCard from deck
        strat.takeCard(table.drawCard());//drawCard from deck
        strat.takeCard(table.drawCard());//drawCard from deck
        strat.takeCard(table.drawCard());//drawCard from deck
    } 
}
