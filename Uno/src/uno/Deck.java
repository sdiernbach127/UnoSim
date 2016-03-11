/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

/**
 *
 * @author Spencer Diernbach
 */
public class Deck {
    private Card cards[];
    
    public Deck(){
        this.cards = new Card[108];
        for(int i=0; i < 108 ; i++){
            Card card = new Card(1,1);
            this.cards[i] = card;      
        }
    }
    
}
