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
public final class Speler extends SpelItem {

    private int stappen;
    private boolean heeftBazooka = false;
    private Bazooka bazooka = null;
    private KeyEvent richting;
    private Vakje myVeld;

    public Speler(Point beginPunt, Vakje veld) {
        image = setImage("/Images/speler.png");
        objectPositie = beginPunt;
        this.myVeld = veld;
    }

    public void actie(KeyEvent e, Level level) {
        int key = e.getKeyCode();
        if (validKey(key) == true) {
            if (key != KeyEvent.VK_SPACE) {
                this.richting = e;
                setRichting();
                if (!(myVeld.getBuur(e).getObject() instanceof Muur)) {
                    Vakje nieuw = myVeld.getBuur(e);
                    if (nieuw.getObject() != null){
                        pakOp(nieuw.getObject());
                    }
                    Vakje oud = myVeld;
                    myVeld = nieuw;
                    oud.setObject(null);
                    nieuw.setObject(this);
                    this.objectPositie = new Point(myVeld.getVeldPositie().x, myVeld.getVeldPositie().y);
                    stappen++;
                }
            } else {
                System.out.println("Schiet simulatie");
                schiet((myVeld.getVeldPositie().y /40) , (myVeld.getVeldPositie().x /40 ), level );  //TODO: map referentie ophalen!!!
            }
        }
        else {
         
        }
    }

//        myVeld.setObject(null);
//        this.objectPositie = new Point(getObjectPositie().x + x, getObjectPositie().y + y);
//        stappen += 1;
    

    private void lopen(KeyEvent e) {
        setRichting();
        if (!(myVeld.getBuur(e).getObject() instanceof Muur)) {
            this.objectPositie = new Point(objectPositie.x, objectPositie.y - 1);
            Vakje nieuw = myVeld.getBuur(e);
            Vakje oud = myVeld;
            myVeld = nieuw;
            oud.setObject(null);
            nieuw.setObject(this);
            stappen++;
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
    private void setRichting() {
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

    private void schiet(int raketX, int raketY, Level level) {
        //if (heeftBazooka) {
        //int raket = bazooka.getRaketAantal();
        //if (raket > 0) {
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


        //}
        //}
    }

    public int getStappen() {
        return stappen;
    }

    private boolean validKey(int key) {
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_SPACE) {
            return true;
        } else {
            return false;
        }
    }

    private void pakOp(SpelItem object) {
        if (object instanceof Vriend) {
            JOptionPane.showMessageDialog(this, "Je hebt gewonnen in " + this.getStappen() + " stappen.", "Gewonnen!", JOptionPane.PLAIN_MESSAGE);
        }
    }
}