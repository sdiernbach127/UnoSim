/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
