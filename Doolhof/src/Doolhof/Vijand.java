/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

/**
 *
 * @author danny
 */
public class Vijand extends SpelItem{
    
    public Vijand(){
        image = setImage("/Images/vijand.png");       
    }
    
    
    
    @Override
    public void useItem(){
    RunSpel.gameOver();    
    }
}
