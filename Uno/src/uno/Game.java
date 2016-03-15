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

//really messy, would like to get function so to not repeating code just for other player. 
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
        for(int start = 0; start < 7; start ++){
            strat1.takeCard(table.drawCard());
            strat2.takeCard(table.drawCard());
        }
        
        table.addToFaceUp(table.drawCard());
        
        
        
        //While game is not over
        while(GameOver(strat1, strat2) != true){
            if (playerturn == 1){
                
                        
                Card toplay = strat1.playCard(table.topUp());
                //if cannot play card
                if (toplay == null){
                    strat1.takeCard(table.drawCard()); //draw card
                }
                
                //check to make sure card is playable. add for wild cards
                else if (toplay.getColor() == 5){
                    //we need to figure out how to play wilds
                    if (toplay.getValue() == 1){
                        Draw4Card(strat2);
                        playerturn = 1;
                    }
                }
                
                //if wild card: behavior
                
                //then this next if is an elif so it is part of the whole if block?
                else if (toplay.getColor() != table.topUp().getColor() && toplay.getValue() != table.topUp().getValue())
                    System.out.println("Exception: card doesn't match: " + toplay.getColor()+ " " + toplay.getValue() + " "+ table.topUp().getColor()+ " "+ table.topUp().getValue()); // Not sure but won't this fire with all wild cards because the color and value won't match?
                    //do we want the above to be a true exception thrown or keep it a print so we know it happened?
                table.addToFaceUp(toplay); 
                
                //can these be played when the colors don't match?
                System.out.println("Player 1: " + toplay.getValue());
                if (toplay.getValue() == 12){
                    Draw2Card(strat2);
                    //current rule same player
                    playerturn = 1;                
                } 
                
                else if (toplay.getValue() == 10)
                    playerturn = 1;
                
                else if (toplay.getValue() == 11)
                    playerturn = 1;
                
                else
                    playerturn = 2;
            }
            
            
            if (playerturn == 2){ 
                Card toplay = strat2.playCard(table.topUp());
                
                //if cannot play card
                if (toplay == null){
                    strat2.takeCard(table.drawCard()); //draw card
                }
                
                //check to make sure card is playable. add for wild cards
                else if (toplay.getColor() == 5){
                    //we need to figure out how to play wilds
                    if (toplay.getValue() == 1){
                        Draw4Card(strat1);
                        playerturn = 2;
                    }
                }
                
                 else if (toplay.getColor() != table.topUp().getColor() && toplay.getValue() != table.topUp().getValue())
                    System.out.print("Exception: card doesn't match");
                table.addToFaceUp(toplay);
                
                System.out.println("Player 2: " + toplay.getValue());
                if (toplay.getValue() == 12){
                    Draw2Card(strat1);
                    //current rule same player
                    playerturn = 2;                
                } 
                
                else if (toplay.getValue() == 10)
                    playerturn = 2;
                
                else if (toplay.getValue() == 11)
                    playerturn = 2;
                
                else
                    playerturn = 1; //next turn
                
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
