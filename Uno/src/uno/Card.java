/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// There are 4 colors Possibly 5 if you count the wilds as their own color
// Counting the different wilds it looks like there are 15 possible values to represent the type of card.
package uno;

public class Card 
{
    private int color;
    private int value;
    
    public Card(int color, int value)
    {
        this.color = color;
        this.value = value;
    }
    
    public int getColor()
    {
        return this.color;
    }
    
    public int getValue()
    {
        return this.value;
    }
}
