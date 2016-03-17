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
          
        //color versus all the others
        ColorVersus colorVersus = new ColorVersus();
       
        colorVersus.ColorVsColor(numGames);
        colorVersus.ColorVsAggressive(numGames);
        colorVersus.ColorVsPassive(numGames);
        colorVersus.ColorVsUnit(numGames);
        colorVersus.ColorVsRandom(numGames);
        
        System.out.println("\n");
        System.out.println("============================================================================");
        //Aggressive versus all the others 
        AggressiveVersus aggressiveVersus = new AggressiveVersus();
      
        aggressiveVersus.AggressiveVsColor(numGames);
        aggressiveVersus.AggressiveVsAggressive(numGames);
        aggressiveVersus.AggressiveVsPassive(numGames);
        aggressiveVersus.AggressiveVsUnit(numGames);
        aggressiveVersus.AggressiveVsRandom(numGames);
        
        System.out.println("\n");
        System.out.println("============================================================================");
        //Passive versus all the others 
        PassiveVersus passiveVersus = new PassiveVersus();
      
        passiveVersus.PassiveVsColor(numGames);
        passiveVersus.PassiveVsAggressive(numGames);
        passiveVersus.PassiveVsPassive(numGames);
        passiveVersus.PassiveVsUnit(numGames);
        passiveVersus.PassiveVsRandom(numGames);
        
        System.out.println("\n");
        System.out.println("============================================================================");
        //Unit versus all the others 
        UnitVersus unitVersus = new UnitVersus();
      
        unitVersus.UnitVsColor(numGames);
        unitVersus.UnitVsAggressive(numGames);
        unitVersus.UnitVsPassive(numGames);
        unitVersus.UnitVsUnit(numGames);
        unitVersus.UnitVsRandom(numGames);
        
        System.out.println("\n");
        System.out.println("============================================================================");
        //Random versus all the others 
        RandomVersus randomVersus = new RandomVersus();
      
        randomVersus.RandomVsColor(numGames);
        randomVersus.RandomVsAggressive(numGames);
        randomVersus.RandomVsPassive(numGames);
        randomVersus.RandomVsUnit(numGames);
        randomVersus.RandomVsRandom(numGames);
    }   
    
}
