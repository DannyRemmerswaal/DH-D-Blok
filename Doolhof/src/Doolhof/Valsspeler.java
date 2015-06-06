/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

/**
 *
 * @author Hüseyin
 */
public class Valsspeler extends SpelItem{
    int aantalStappen;
    public Valsspeler(int aantalStappen) {
        this.aantalStappen = aantalStappen;
        image = setImage("/Images/valsspeler.png");
    }
    
         @Override
    public void useItem(){   
    Speler.stappen -= aantalStappen;
    }
    
}
