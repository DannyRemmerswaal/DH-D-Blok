/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author danny
 */
public class Bazooka extends SpelItem {
    
    public Bazooka(){
        image = setImage("/Images/bazooka.png");       
    }
    
    
        public void schiet(int posX, int posY, Level level, Richting richting) {
        int x = posX;
        int y = posY;
        while (!(level.getDoolhofArray()[y][x].getObject() instanceof Muur)) {

            switch (richting) {
                case NORTH:
                    y--;
                    break;
                case EAST:
                    x++;
                    break;
                case SOUTH:
                    y++;
                    break;
                case WEST:
                    x--;
                    break;
            }
        }
        Muur muur = (Muur) level.getDoolhofArray()[y][x].getObject();
        if (!muur.isBuitenMuur()) {
            level.getDoolhofArray()[y][x].setObject(null);
        }

        }       

    @Override
    public void useItem(){
        Speler.setHeeftBazooka(true);
    }

 }

