/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Danny R
 */
public class Speler extends SpelItem {

    private static int stappen;
    private static boolean heeftBazooka = false;
    private Bazooka bazooka = new Bazooka();
    private Richting richting;
    private static Vakje myVeld;

    public Speler(Point beginPunt, Vakje v) {
        image = setImage("/Images/speler.png");
        objectPositie = beginPunt;
        this.myVeld = v;
    }

    public void actieBeweeg(int key, Level level) {        
        if (validKey(key) == true) {
            if (key != KeyEvent.VK_SPACE) {
                setRichting(key);
                if (!(myVeld.getBuur(richting).getObject() instanceof Muur)) {
                    Vakje nieuw = myVeld.getBuur(richting);                    
                    Vakje oud = myVeld;
                    myVeld = nieuw;
                    if (nieuw.getObject() != null){
                        pakItemOp(nieuw.getObject());
                    }
                    oud.setObject(null);
                    nieuw.setObject(this);
                    this.objectPositie = new Point(myVeld.getVeldPositie().x, myVeld.getVeldPositie().y);
                    stappen++;                   
                }
            } 
            if(key == KeyEvent.VK_SPACE && heeftBazooka == false){
                JOptionPane.showMessageDialog(null, "Oeps, je hebt geen bazooka bij de hand!", "Waarschuwing!", JOptionPane.PLAIN_MESSAGE);    
            }
            if(key == KeyEvent.VK_SPACE && heeftBazooka == true) {
                bazooka.schiet((myVeld.getVeldPositie().y /40) , (myVeld.getVeldPositie().x /40 ), level, richting);
                heeftBazooka = false;
            }
        }
        else 
        {
        }
    }
    
    
    /**
     * @return the richting
     */
    
    public Richting getRichting() {
        return richting;
    }

    /**
     * @param richting the richting to set
     */
        public void setRichting(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                image = setImage("/Images/speler_back.png");
                this.richting = Richting.NORTH;
                break;
            case KeyEvent.VK_RIGHT:
                image = setImage("/Images/speler_right.png");
                this.richting = Richting.EAST;
                break;
            case KeyEvent.VK_DOWN:
                image = setImage("/Images/speler.png");
                this.richting = Richting.SOUTH;
                break;
            case KeyEvent.VK_LEFT:
                image = setImage("/Images/speler_left.png");
                this.richting = Richting.WEST;
                break;
        }
    }

    public static int getStappen() {
        return stappen;
    }
    
    public static void setStappen(int stappen) {
        Speler.stappen = stappen;
    }
    
    public boolean validKey(int key) {
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_SPACE) {
            return true;
        } else {
            return false;
        }
    }

    public void pakItemOp(SpelItem object) {
        object.useItem();        
    }
       
    static Vakje getMyVeld() {
        return myVeld;
    }
      
    public static void setHeeftBazooka(boolean heeftBazooka) {
        Speler.heeftBazooka = heeftBazooka;
    }
   
}