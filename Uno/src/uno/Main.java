/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

/**
 *
 * @author Derek
 */
public class Main 
{
    public static void main(String[] args)
    {
        int winner;
        //Strategy color = new ColorStrategy();
        //Strategy color1 = new ColorStrategy();
        //Strategy color = new AggressiveStrategy();
        //Strategy color1 = new AggressiveStrategy();
        Strategy color = new PassiveStrategy();
        Strategy color1 = new PassiveStrategy();
        
        Game game = new Game();
        winner = game.playGame(color1, color1);
        System.out.println("Strategy " + winner + " wins!");
        
    }
}
