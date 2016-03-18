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
public class Game2 
{
    int playerturn = 0;
    boolean clockwise = true;
    Deck deck= new Deck("UnoDeck.dat");
    Table table = new Table(deck);
    int faceColor;
    Card toplay;
    int numTurns = 0;
    ArrayList<Strategy> strategies;
    ArrayList<Integer> turns = new ArrayList<>(); // bad name but its for number of draws
    
    public int playGame (ArrayList<Strategy> strats)
    {
        strategies = strats;
        for(int i = 0; i < strats.size(); i++)
        {
            turns.add(0); //initialize turns all players turns to 0
        }
        //stats
        int winnerIs = -1;
        //int numTurns = 0;
        //int numDrawnCardsP1 = 0;
        //int numDrawnCardsP2 = 0;
        /*
        Set Up
        strat1 draw 7, strat2 draw 7. 
        table show 1 from deck
        */
        for(int start = 0; start < 7; start ++)
        {
            for(Strategy strat : strategies)
            {
                strat.takeCard(table.drawCard());
                turns.set(strategies.indexOf(strat), turns.get(strategies.indexOf(strat)));
            }
            //turns.set(playerturn, turns.get(playerturn) + 1);
           
        }
        
        table.addToFaceUp(table.drawCard());
        
        
        
        //While game is not over
        while(GameOver(strategies) != true)
        {             
            toplay = strategies.get(playerturn).playCard(table.topUp());
            //if cannot play card
            if (toplay == null)
            {
                toplay = table.drawCard();
                //System.out.println("P1 card drawn when no playable card= " + drawnCard);
                strategies.get(playerturn).takeCard(toplay); //draw card
                advancePlayer();

                //if the deck is empty, we take and reshuffle the face up pile
                //we then pass it as a new deck, but we can just re-make the whole table
                //in fewer statements
                if(table.emptyDeck() == true)
                {
                    //System.out.println("Player 1 emptied the deck");
                    Deck temp = new Deck(table.takePile());
                    table = new Table(temp);
                    table.addToFaceUp(table.drawCard());
                }
                turns.set(playerturn, turns.get(playerturn) + 1);

            }
            else
            {
                //check to make sure card is playable. add for wild cards
                if (toplay.getColor() == 5){
                    if (toplay.getValue() == 14){
                        Draw4Card(strategies.get(playerturn));
                        advancePlayer(toplay.getValue());
                        turns.set(playerturn, turns.get(playerturn) + 4);
                    }
                }

                //if wild card: behavior

                //then this next if is an elif so it is part of the whole if block?
                else if (toplay.getColor() != table.topUp().getColor() && toplay.getValue() != table.topUp().getValue() || toplay.getColor() == 5)
                    System.out.println("Exception: card doesn't match: " + toplay.getColor()+ " " + toplay.getValue() + " "+ table.topUp().getColor()+ " "+ table.topUp().getValue()); // Not sure but won't this fire with all wild cards because the color and value won't match?
                    //do we want the above to be a true exception thrown or keep it a print so we know it happened?


                //can these be played when the colors don't match?
                //System.out.println("Table Color: " + table.topUp().getColor() + "  Value:"+ table.topUp().getValue());
                //System.out.println("Player 1 Color: " + toplay.getColor() + "  Value:"+ toplay.getValue());

                else if(toplay.getValue() == 12)
                {
                    Draw2Card(strategies.get(playerturn));
                    //current rule same player
                    advancePlayer(toplay.getValue());
                    turns.set(playerturn, turns.get(playerturn) + 2);
                } 

                else if (toplay.getValue() == 10)
                    advancePlayer(toplay.getValue());

                else if (toplay.getValue() == 11)
                {
                    if(clockwise == false)
                    {
                        clockwise = true;
                    }
                    else
                    {
                        clockwise = false;
                    }
                    advancePlayer(toplay.getValue());
                }

                else
                    advancePlayer();

                table.addToFaceUp(toplay);


                if(table.topUp().getColor() == 5) //card was legal and is a wild
                {
                    table.topUp().setColor(strategies.get(playerturn).chooseColor()); //set the color of the wild card strat1's choosing
                }

            }
            if(strategies.get(playerturn).getHandSize() == 0){ //check to see if player 1 has won 
                winnerIs = playerturn;
                /*System.out.println("Total turns played (each player goes once): " + numTurns);
                System.out.println("Player 1 number of cards drawn: " + numDrawnCardsP1);
                System.out.println("Player 2 number of cards drawn: " + numDrawnCardsP2);
                System.out.println("Total number of cards drawn: " + (numDrawnCardsP1 + numDrawnCardsP2));
                System.out.println("p1 = " + strat1.getHandSize() + " p2 = " + strat2.getHandSize());*/
                return winnerIs;
            }


        //if the deck is empty, we take and reshuffle the face up pile
        //we then pass it as a new deck, but we can just re-make the whole table
        //in fewer statements
        if(table.emptyDeck() == true)
        {
            //System.out.println("Player 1 emptied the deck");
            Deck temp = new Deck(table.takePile());
            table = new Table(temp);
            table.addToFaceUp(table.drawCard());
        }
            
            
        
        numTurns += 1;
        
        /*System.out.println("Player 1 number of cards drawn: " + numDrawnCardsP1);
        System.out.println("Player 2 number of cards drawn: " + numDrawnCardsP2);
        System.out.println("Size of the deck at turn " + numTurns + ": " + table.theDeck.sizeOfDeck());
    }
        System.out.println("Total turns played (each player goes once): " + numTurns);
        System.out.println("p1 = " + strat1.getHandSize() + " p2 = " + strat2.getHandSize());*/}
        for(int i = 0; i < strategies.size(); i++)
        {
            if(strategies.get(i).getHandSize() == 0)
            {
                winnerIs = i;
            }
        }
        return winnerIs;
    }
    
    public boolean GameOver(ArrayList<Strategy> strategies)
    {
        for(Strategy strat : strategies)
        {
            if(strat.getHandSize() == 0)
            {
                return true;
            }
        }   
            
        return false;
        
    }
    
    public void Draw2Card(Strategy strat)
    {
        for(int i = 0; i < 2; i++)
        {
            //if the deck is empty, we take and reshuffle the face up pile
            //we then pass it as a new deck, but we can just re-make the whole table
            //in fewer statements
            if(table.emptyDeck() == true)
            {
                //System.out.println("Player 1 emptied the deck");
                Deck temp = new Deck(table.takePile());
                table = new Table(temp);
                table.addToFaceUp(table.drawCard());
            }
            Card drawnCard = table.drawCard();
            //System.out.println("D2 card = " + drawnCard);
            strat.takeCard(drawnCard);//drawCard from deck, we need to acces table here
        }
        //overkill?
        //to catch an empty deck after the fact
        if(table.emptyDeck() == true)
        {
            //System.out.println("Player 1 emptied the deck");
            Deck temp = new Deck(table.takePile());
            table = new Table(temp);
            table.addToFaceUp(table.drawCard());
        }
    } 
    
    public void Draw4Card(Strategy strat){
        for(int i = 0; i < 4; i++)
        {
            //make sure we don't empty the deck
            //if the deck is empty, we take and reshuffle the face up pile
            //we then pass it as a new deck, but we can just re-make the whole table
            //in fewer statements
            if(table.emptyDeck() == true)
            {
                //System.out.println("Player 1 emptied the deck");
                Deck temp = new Deck(table.takePile());
                table = new Table(temp);
                table.addToFaceUp(table.drawCard());
            }
            Card drawnCard = table.drawCard();
            //System.out.println("D4 card = " + drawnCard);
            strat.takeCard(drawnCard);
        }
        //overkill?
        //to catch an empty deck after the fact
        if(table.emptyDeck() == true)
        {
            //System.out.println("Player 1 emptied the deck");
            Deck temp = new Deck(table.takePile());
            table = new Table(temp);
            table.addToFaceUp(table.drawCard());
        }

    } 
    
    public void advancePlayer()
    {
        if(clockwise == true)
        {
            playerturn = (playerturn + 1) % strategies.size();
        }
        else
        {
            playerturn -= 1;
            if(playerturn < 0)
            {
                playerturn = strategies.size()-1;
            }
        }
    }
    
    public void advancePlayer(int value)
    {
        if(clockwise == true)
        {
            if(value == 10 || value == 12 || value == 14)
            {
                playerturn = (playerturn + 2) % strategies.size();
            }
            else
            {
                playerturn = (playerturn + 1) % strategies.size();
            }
        }
        else
        {
            if(value == 10 || value == 12 || value == 14)
            {
                playerturn -= 1;
                if(playerturn < 0)
                {
                    playerturn = strategies.size()-1;

                }
                playerturn -= 1;
            }
            
            else
            {
                playerturn -= 1;
            }
            if(playerturn < 0)
            {
                playerturn = strategies.size()-1;
            }
        }
    }
    
    public int getNumTurns()
    {
        return numTurns;
    }
    
    public ArrayList<Integer> getDraws()
    {
        return turns;
    }
    
    
}
