/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.Point;
import javax.swing.JOptionPane;

/**
 *
 * @author Danny
 */
public class Vriend extends SpelItem {
    
    public Vriend() {
        image = setImage("/Images/vriend.png");
    }
    
    @Override
    public void useItem(){ 
     int huidigLevel = RunSpel.getNummer();
     int volgendlevel = huidigLevel + 1;
     RunSpel.setNummer(volgendlevel);
     RunSpel.reset();
    }
    
}
