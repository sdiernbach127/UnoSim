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
        Strategy color = new AggressiveStrategy();
        Strategy color1 = new AggressiveStrategy();
        //Strategy color = new PassiveStrategy();
        //Strategy color1 = new PassiveStrategy();
        //Strategy color = new UnitStrategy();
        //Strategy color1 = new UnitStrategy();
        //Strategy color = new testStrategy();
        //Strategy color1 = new testStrategy();
       
        Game game = new Game();
        for(int i = 0; i < 10; i++)
        {
            game = new Game();
            winner = game.playGame(color, color1);
            System.out.println("Strategy " + winner + " wins!");
        }

    }   

}
