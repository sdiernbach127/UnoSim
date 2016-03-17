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
public class Main 
{
    public static void main(String[] args)
    {
        int numGames = 10000;
        Game2 multiplayer = new Game2();
          
        //color versus all the others
        ColorVersus colorVersus = new ColorVersus();
       
        colorVersus.ColorVsColor(numGames);
        colorVersus.ColorVsAggressive(numGames);
        colorVersus.ColorVsPassive(numGames);
        colorVersus.ColorVsUnit(numGames);
        colorVersus.ColorVsRandom(numGames);
        colorVersus.ColorVstestStrategy(numGames);
        
        System.out.println("\n");
        System.out.println("============================================================================");
        //Aggressive versus all the others 
        AggressiveVersus aggressiveVersus = new AggressiveVersus();
      
        aggressiveVersus.AggressiveVsColor(numGames);
        aggressiveVersus.AggressiveVsAggressive(numGames);
        aggressiveVersus.AggressiveVsPassive(numGames);
        aggressiveVersus.AggressiveVsUnit(numGames);
        aggressiveVersus.AggressiveVsRandom(numGames);
        aggressiveVersus.AggressiveVstestStrategy(numGames);
        
        System.out.println("\n");
        System.out.println("============================================================================");
        //Passive versus all the others 
        PassiveVersus passiveVersus = new PassiveVersus();
      
        passiveVersus.PassiveVsColor(numGames);
        passiveVersus.PassiveVsAggressive(numGames);
        passiveVersus.PassiveVsPassive(numGames);
        passiveVersus.PassiveVsUnit(numGames);
        passiveVersus.PassiveVsRandom(numGames);
        passiveVersus.PassiveVstestStrategy(numGames);
        
        System.out.println("\n");
        System.out.println("============================================================================");
        //Unit versus all the others 
        UnitVersus unitVersus = new UnitVersus();
      
        unitVersus.UnitVsColor(numGames);
        unitVersus.UnitVsAggressive(numGames);
        unitVersus.UnitVsPassive(numGames);
        unitVersus.UnitVsUnit(numGames);
        unitVersus.UnitVsRandom(numGames);
        unitVersus.UnitVstestStrategy(numGames);
        
        System.out.println("\n");
        System.out.println("============================================================================");
        //Random versus all the others 
        RandomVersus randomVersus = new RandomVersus();
      
        randomVersus.RandomVsColor(numGames);
        randomVersus.RandomVsAggressive(numGames);
        randomVersus.RandomVsPassive(numGames);
        randomVersus.RandomVsUnit(numGames);
        randomVersus.RandomVsRandom(numGames);
        randomVersus.RandomVstestStrategy(numGames);
        
        System.out.println("\n");
        System.out.println("============================================================================");
        //Random versus all the others 
        testStrategyVersus testVersus = new testStrategyVersus();
      
        testVersus.testStrategyVsColor(numGames);
        testVersus.testStrategyVsAggressive(numGames);
        testVersus.testStrategyVsPassive(numGames);
        testVersus.testStrategyVsUnit(numGames);
        testVersus.testStrategyVsRandom(numGames);
        testVersus.testStrategyVstestStrategy(numGames);
        
        
        System.out.println("\n");
        System.out.println("===========================================================================");
        ArrayList<Strategy> strats = new ArrayList(3);
        strats.add(new AggressiveStrategy());
        strats.add(new AggressiveStrategy());
        strats.add(new AggressiveStrategy());
        int[] winnings = new int[3];
        int multiTurns = 0;
        int winner = -1;
        
        for(int i = 0; i < numGames; i ++)
        {
            multiplayer = new Game2();
            winner = multiplayer.playGame(strats);
            winnings[winner] += 1;
            multiTurns += multiplayer.getNumTurns();
        }
        
        for(int wins : winnings)
        {
            System.out.println("Win percent = " + (double)wins/(double)numGames);
        }
        System.out.println("Ave num turns = " + multiTurns/numGames);
    }   
    
    
             
}
