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

    public static int stappen;
    public static boolean heeftBazooka = false;
    private Bazooka bazooka = new Bazooka();
    private Richting richting;
    static Vakje myVeld;

    public Speler(Point beginPunt, Vakje veld) {
        image = setImage("/Images/speler.png");
        objectPositie = beginPunt;
        this.myVeld = veld;
    }

    public void actieBeweeg(KeyEvent e, Level level) {
        int key = e.getKeyCode();
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
                    RunSpel.aantalStappenGezet.setText(Integer.toString(stappen));
                }
            } 
            if(key == KeyEvent.VK_SPACE) {
                schiet((myVeld.getVeldPositie().y /40) , (myVeld.getVeldPositie().x /40 ), level );
                heeftBazooka = false;
            }
        }
        else {
         
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

    public void schiet(int raketX, int raketY, Level level) {
        if (heeftBazooka){
        int x = raketX;
        int y = raketY;
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
        else
        {
            JOptionPane.showMessageDialog(null, "Oeps, je hebt geen bazooka bij de hand!", "Waarschuwing!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public int getStappen() {
        return stappen;
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
}