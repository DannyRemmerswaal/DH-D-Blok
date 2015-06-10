/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Danny
 */

public class Vakje extends JComponent {

    private final BufferedImage veldImage = setImage("/Images/vloer.png");
    private final Image helperPadImage = setImage("/Images/helperPad.png");
    private SpelItem object;
    private final Point veldPositie;
    private Vakje buurUp;
    private Vakje buurRight;
    private Vakje buurDown;
    private Vakje buurLeft;
    private boolean snelleRoute = false;

    public Vakje(int x, int y, SpelItem object) {
        veldPositie = new Point(x, y);       
        this.object = object;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(veldImage, getVeldPositie().y, getVeldPositie().x, null);
            if (snelleRoute) {
            g.drawImage(helperPadImage, getVeldPositie().y, getVeldPositie().x, null);
        }
        if (getObject() != null) {
            g.drawImage(getObject().getImage(), getVeldPositie().y, getVeldPositie().x, null);
        }
    }

    public BufferedImage setImage(String path) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(this.getClass().getResource(path));
        } catch (IOException e) {
        }
        return bi;
    }

    public SpelItem getObject() {
        return object;
    }

    public void setObject(SpelItem object) {
        this.object = object;
    }

    public Vakje getBuur(Richting richting) {
        Vakje veld = null;
        switch (richting) {
            case NORTH:
                veld = buurUp; break;
            case EAST:
                veld = buurRight; break;
            case SOUTH:
                veld = buurDown; break;
            case WEST:
                veld = buurLeft; break;
        }
        return veld;
    }
    
    public void setBuren(int i, int j, Vakje[][] doolhof) {
        this.buurUp = doolhof[i-1][j];
        this.buurDown = doolhof[i+1][j];
        this.buurLeft = doolhof [i][j-1];
        this.buurRight = doolhof [i][j+1];
    }

    /**
     * @return the veldPositie
     */
    public Point getVeldPositie() {
        return veldPositie;
    }
    
        public void setSnelleRoute(boolean snelleRoute) {
        this.snelleRoute = snelleRoute;
    }
}
