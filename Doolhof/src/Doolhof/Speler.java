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
    private KeyEvent richting;
    private Vakje myVeld;

    public Speler(Point beginPunt, Vakje veld) {
        image = setImage("/Images/speler.png");
        objectPositie = beginPunt;
        this.myVeld = veld;
    }

    public void actieBeweeg(KeyEvent e, Level level) {
        int key = e.getKeyCode();
        if (validKey(key) == true) {
            if (key != KeyEvent.VK_SPACE) {
                this.richting = e;
                setRichting();
                if (!(myVeld.getBuur(e).getObject() instanceof Muur)) {
                    Vakje nieuw = myVeld.getBuur(e);
                    if (nieuw.getObject() != null){
                        pakItemOp(nieuw.getObject());
                    }
                    Vakje oud = myVeld;
                    myVeld = nieuw;
                    oud.setObject(null);
                    nieuw.setObject(this);
                    this.objectPositie = new Point(myVeld.getVeldPositie().x, myVeld.getVeldPositie().y);
                    stappen++;
                    RunSpel.aantalStappenGezet.setText(Integer.toString(stappen));
                }
            } 
            if(key == KeyEvent.VK_SPACE) {
                schiet((myVeld.getVeldPositie().y /40) , (myVeld.getVeldPositie().x /40 ), level );  //TODO: map referentie ophalen!!!
                heeftBazooka = false;
            }
        }
        else {
         
        }
    }
    
    
    /**
     * @return the richting
     */
    
    public KeyEvent getRichting() {
        return richting;
    }

    /**
     * @param richting the richting to set
     */
    public void setRichting() {
        int keyCode = richting.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                image = setImage("/Images/speler_back.png");
                break;
            case KeyEvent.VK_RIGHT:
                image = setImage("/Images/speler_right.png");
                break;
            case KeyEvent.VK_DOWN:
                image = setImage("/Images/speler.png");
                break;
            case KeyEvent.VK_LEFT:
                image = setImage("/Images/speler_left.png");
                break;
        }
    }

    public void schiet(int raketX, int raketY, Level level) {
        if (heeftBazooka){
        int x = raketX;
        int y = raketY;
        while (!(level.getDoolhofArray()[y][x].getObject() instanceof Muur)) {

            int key = getRichting().getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    y--;
                    break;
                case KeyEvent.VK_RIGHT:
                    x++;
                    break;
                case KeyEvent.VK_DOWN:
                    y++;
                    break;
                case KeyEvent.VK_LEFT:
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
            JOptionPane.showMessageDialog(null, "Nog geen bazooka opgepakt!", "Oeps!", JOptionPane.PLAIN_MESSAGE);
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
}