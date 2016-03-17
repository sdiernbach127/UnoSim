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
        int numGames = 10000;
        Versus versus = new Versus();
        
        versus.ColorVsColor(numGames);
        versus.ColorVsAgressive(numGames);
        versus.ColorVsPassive(numGames);
        
        versus.AgressiveVsAgressive(numGames);
        versus.AgressiveVsColor(numGames);
        
        versus.PassiveVsPassive(numGames);
        
        versus.UnitVsUnit(numGames);
        
        versus.RandomVsRandom(numGames);
    }   
    
}
