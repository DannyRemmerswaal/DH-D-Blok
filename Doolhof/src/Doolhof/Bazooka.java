/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author danny
 */
public class Bazooka extends SpelItem {

    
    public Bazooka(){
        image = setImage("/Images/bazooka.png");       
    }
    

    @Override
    public void useItem(){
    Speler.heeftBazooka = true;
    }
}
