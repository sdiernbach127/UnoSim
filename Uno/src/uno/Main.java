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
        Strategy aggressive = new AggressiveStrategy();
        Strategy passive = new PassiveStrategy();
        Game game = new Game(aggressive, passive);
    }
}
