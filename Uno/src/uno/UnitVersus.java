/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

/**
 *
 * @author Spencer
 */
public class UnitVersus {
    
    public void UnitVsColor(int numGames)
    {
        int winner;
        int[] players = new int[3];
        int totalTurns = 0;
        int p1TotalDraws = 0;
        int p2TotalDraws = 0;
        

        Strategy color = new UnitStrategy();
        Strategy color1 = new AggressiveStrategy();
       
        Game game = new Game();
        for(int i = 0; i < numGames; i++)
        {
            game = new Game();
            winner = game.playGame(color, color1);
            players[winner] += 1; // add to histogram
            totalTurns += game.getNumTurns();
            p1TotalDraws += game.getP1Draws();
            p2TotalDraws += game.getP2Draws();
            
            //System.out.println("Strategy " + winner + " wins!");
        }
            System.out.println("\n");
            System.out.println("This was a " + color.getStratName() + " vs " + color1.getStratName() + " game, where " + color.getStratName() + " goes first.");
            System.out.println("Here's some Statistics:");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("The number of games played is " + numGames);
            System.out.println("Average turns per game = " + totalTurns/numGames);
            System.out.println(color.getStratName() + "'s percentage of wins = " + (double)players[1]/(double)numGames + " with an average of " + p1TotalDraws/numGames + " number of draws per game");
            System.out.println(color1.getStratName() +"'s percentage of wins = " + (double)players[2]/(double)numGames + " with an average of " + p2TotalDraws/numGames + " number of draws per game");
    }
    
    public void UnitVsAggressive(int numGames)
    {
        int winner;
        int[] players = new int[3];
        int totalTurns = 0;
        int p1TotalDraws = 0;
        int p2TotalDraws = 0;
      
        Strategy color = new UnitStrategy(); 
        Strategy color1 = new AggressiveStrategy();
        
       
        Game game = new Game();
        for(int i = 0; i < numGames; i++)
        {
            game = new Game();
            winner = game.playGame(color, color1);
            players[winner] += 1; // add to histogram
            totalTurns += game.getNumTurns();
            p1TotalDraws += game.getP1Draws();
            p2TotalDraws += game.getP2Draws();
            
            //System.out.println("Strategy " + winner + " wins!");
        }
            System.out.println("\n");
            System.out.println("This was a " + color.getStratName() + " vs " + color1.getStratName() + " game, where " + color.getStratName() + " goes first.");
            System.out.println("Here's some Statistics:");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("The number of games played is " + numGames);
            System.out.println("Average turns per game = " + totalTurns/numGames);
            System.out.println(color.getStratName() + "'s percentage of wins = " + (double)players[1]/(double)numGames + " with an average of " + p1TotalDraws/numGames + " number of draws per game");
            System.out.println(color1.getStratName() +"'s percentage of wins = " + (double)players[2]/(double)numGames + " with an average of " + p2TotalDraws/numGames + " number of draws per game");
    }
    
    public void UnitVsPassive(int numGames)
    {
        int winner;
        int[] players = new int[3];
        int totalTurns = 0;
        int p1TotalDraws = 0;
        int p2TotalDraws = 0;
      
        Strategy color = new UnitStrategy(); 
        Strategy color1 = new PassiveStrategy();
        
       
        Game game = new Game();
        for(int i = 0; i < numGames; i++)
        {
            game = new Game();
            winner = game.playGame(color, color1);
            players[winner] += 1; // add to histogram
            totalTurns += game.getNumTurns();
            p1TotalDraws += game.getP1Draws();
            p2TotalDraws += game.getP2Draws();
            
            //System.out.println("Strategy " + winner + " wins!");
        }
            System.out.println("\n");
            System.out.println("This was a " + color.getStratName() + " vs " + color1.getStratName() + " game, where " + color.getStratName() + " goes first.");
            System.out.println("Here's some Statistics:");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("The number of games played is " + numGames);
            System.out.println("Average turns per game = " + totalTurns/numGames);
            System.out.println(color.getStratName() + "'s percentage of wins = " + (double)players[1]/(double)numGames + " with an average of " + p1TotalDraws/numGames + " number of draws per game");
            System.out.println(color1.getStratName() +"'s percentage of wins = " + (double)players[2]/(double)numGames + " with an average of " + p2TotalDraws/numGames + " number of draws per game");
    }
    
    public void UnitVsUnit(int numGames)
    {
        int winner;
        int[] players = new int[3];
        int totalTurns = 0;
        int p1TotalDraws = 0;
        int p2TotalDraws = 0;
        

        Strategy color = new UnitStrategy();
        Strategy color1 = new UnitStrategy();
               
        Game game = new Game();
        for(int i = 0; i < numGames; i++)
        {
            game = new Game();
            winner = game.playGame(color, color1);
            players[winner] += 1; // add to histogram
            totalTurns += game.getNumTurns();
            p1TotalDraws += game.getP1Draws();
            p2TotalDraws += game.getP2Draws();
            
            //System.out.println("Strategy " + winner + " wins!");
        }
            System.out.println("\n");
            System.out.println("This was a " + color.getStratName() + " vs " + color1.getStratName() + " game, where " + color.getStratName() + " goes first.");
            System.out.println("Here's some Statistics:");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("The number of games played is " + numGames);
            System.out.println("Average turns per game = " + totalTurns/numGames);
            System.out.println(color.getStratName() + "'s percentage of wins = " + (double)players[1]/(double)numGames + " with an average of " + p1TotalDraws/numGames + " number of draws per game");
            System.out.println(color1.getStratName() +"'s percentage of wins = " + (double)players[2]/(double)numGames + " with an average of " + p2TotalDraws/numGames + " number of draws per game");
    }
    
    public void UnitVsRandom(int numGames)
    {
        int winner;
        int[] players = new int[3];
        int totalTurns = 0;
        int p1TotalDraws = 0;
        int p2TotalDraws = 0;
        

        Strategy color = new UnitStrategy();
        Strategy color1 = new RandomStrategy();
       
        Game game = new Game();
        for(int i = 0; i < numGames; i++)
        {
            game = new Game();
            winner = game.playGame(color, color1);
            players[winner] += 1; // add to histogram
            totalTurns += game.getNumTurns();
            p1TotalDraws += game.getP1Draws();
            p2TotalDraws += game.getP2Draws();
            
            //System.out.println("Strategy " + winner + " wins!");
        }
            System.out.println("\n");
            System.out.println("This was a " + color.getStratName() + " vs " + color1.getStratName() + " game, where " + color.getStratName() + " goes first.");
            System.out.println("Here's some Statistics:");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("The number of games played is " + numGames);
            System.out.println("Average turns per game = " + totalTurns/numGames);
            System.out.println(color.getStratName() + "'s percentage of wins = " + (double)players[1]/(double)numGames + " with an average of " + p1TotalDraws/numGames + " number of draws per game");
            System.out.println(color1.getStratName() +"'s percentage of wins = " + (double)players[2]/(double)numGames + " with an average of " + p2TotalDraws/numGames + " number of draws per game");
    }
}
