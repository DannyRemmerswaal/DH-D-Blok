/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Danny
 */
public abstract class SpelItem extends JComponent {

    public BufferedImage image;
    public Point objectPositie;
    //public boolean buitenMuur;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawImage(image, getObjectPositie().x, getObjectPositie().y, null);
    }

    public BufferedImage getImage() {
        return image;
    }

    public BufferedImage setImage(String path) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(this.getClass().getResource(path));
        } catch (IOException e) {
        }
        return bi;
    }

    /**
     * @return the objectPositie
     */
    public Point getObjectPositie() {
        return objectPositie;
    }
    
    public void setObjectPositie(Point objectPositie) {
        this.objectPositie = objectPositie;
    }
    
    
}
