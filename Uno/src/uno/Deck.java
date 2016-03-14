/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @author Spencer Diernbach
 */
public class Deck {
  
  private ArrayList<Card> theCards;
  private int nextCardIndex;
  
 
  public Deck(String filename)
  {
    // Create the arraylist so we have a place to put the cards
    theCards = new ArrayList<Card>(108);
    
    try
    {
      String line;
      BufferedReader infile = new BufferedReader(new FileReader(filename));
      int position = 0;
  
      while((line = infile.readLine()) != null)
      {
        // Blank lines might contain white space, so trim it off
        line = line.trim();
        
        // ignore blank lines
        // continue will cause the program to stop executing this iteration
        // of the body and re-evaluate the condition.
        if(line.length() == 0)
          continue;
        
        // ignore comments
        if(line.startsWith("#"))
          continue;
            
        // a valid line contains 2 integers
        // The StringTokenizer auto-magically breaks a string
        // into parts
        StringTokenizer tokenizer = new StringTokenizer(line);
        
        // The tokenizer gives us strings, that have to be converted,
        // or parsed, into integers.  If the string isn't an integer,
        // it will through an exception
        int color = Integer.parseInt(tokenizer.nextToken());
        int value = Integer.parseInt(tokenizer.nextToken());
        
        // If there was not an exception in the parse, then we
        // can create the card and add it to the deck.
        theCards.add(new Card(color, value));
      }
    }
    // We catch exceptions here and through a different kind of exception.
    // This code will make sense by the end of the semester.  I promise!
    catch(Exception e)
    {
      throw new RuntimeException("Error while reading file: " + e.toString());
    }
    
    // The first card we take is in index 0 (no matter how many cards
    // were in the file).
    
    
    nextCardIndex = 0;
  }
  
  // Other methods go here.
  public boolean hasNext()
  {
    if(theCards.size()==nextCardIndex)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  public Card 
        getNext()
  {
    int returnCard=0;
    if (theCards.size()==nextCardIndex)
    {
    return null;
    }
    else
    {
      returnCard=nextCardIndex;
      nextCardIndex=nextCardIndex+1;
      return theCards.get(returnCard);
      
    }
  }
  public static void main(String[] args)
  {
    Deck d= new Deck("UnoDeck.dat");
    while (d.hasNext())
    {
      Card c= d.getNext();
      System.out.println(c);
    }
    System.out.print(d.theCards.size());
  }    
    
}
