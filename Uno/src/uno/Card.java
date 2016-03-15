/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * If color int is 
 * 1 - yellow
 * 2 - red
 * 3 - blue
 * 4 - green
 * 5 - Wild
 * 
 * If value int is 
 * between 0 and 9 is that value
 * 10 - skip
 * 11 - reverse
 * 12 - draw 2
 * if card is wild then 0 is no draw, and 1 is draw 4 wild
 */

// There are 4 colors Possibly 5 if you count the wilds as their own color
// Counting the different wilds it looks like there are 15 possible values to represent the type of card.
package uno;

public class Card 
{
    private int clr;
    private int val;
    
    public Card(int color, int value)
    {
        clr = color;
        val = value;
    }
    
    public int getColor()
    {
        return clr;
    }
    
    public int getValue()
    {
        return val;
    }
    public String toString()
  {
    String clrSt="O";
    String valSt="O"; 
   
    if (clr != 5){
        if (clr==1)
          clrSt= "Y"; // yellow
        else if (clr==2)
          clrSt= "R"; //red
        else if (clr==3)
          clrSt= "B"; //blue   
        else if (clr==4)
          clrSt= "G"; //green 
        
        if (val <=9)
            valSt = Integer.toString(val);        
        else if (val == 10)
            valSt = "S"; // skip
        else if (val == 11)
            valSt = "R"; // reverse
        else if (val == 12)
            valSt = "d"; //draw 2
    }
    if (clr==5)
    {
      clrSt= "W"; // wild
      if (val == 0)
          valSt = "N"; // normal wild
      if (val == 1)
          valSt = "D"; // draw four
    }
    
    String newstring= (clrSt + " " + valSt);
    return (newstring);
  }
}
