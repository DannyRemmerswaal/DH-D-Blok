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
    private int raketAantal;

    //private Image bazooka;
    
    /**
     * @return the raketAantal
     */
    
    public Bazooka(){
        image = setImage("/Images/bazooka.png");
        //bazooka = img.getImage();
        
    }
    
    public int getRaketAantal() {
        return raketAantal;
    }

    /**
     * @param raketAantal the raketAantal to set
     */
    public void setRaketAantal(int raketAantal) {
        this.raketAantal = raketAantal;
    }
}
