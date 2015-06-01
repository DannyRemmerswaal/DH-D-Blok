/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Danny
 */
public class Muur extends SpelItem {
    
    private boolean buitenMuur;
    
    public Muur(boolean buitenMuur) {
        image = setImage("/Images/muur.png");
        setBuitenMuur(buitenMuur);
    }

    /**
     * @return the buitenMuur
     */
    public boolean isBuitenMuur() {
        return buitenMuur;
    }

    /**
     * @param buitenMuur the buitenMuur to set
     */
    public void setBuitenMuur(boolean buitenMuur) {
        this.buitenMuur = buitenMuur;
    }
    
    
  
    }

