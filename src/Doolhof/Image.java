/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Image extends JFrame {
    
    private BufferedImage dummy;

    public Image() {
        createButton();
        
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private void createButton() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Doolhof/images/wall.png")));
        
        //Friend friend = new Friend("/Doolhof/images/wall.png");
        BufferedImage image = setImage("/Doolhof/images/wall");
        Wall wall = new Wall(image);
        
        JButton button = new JButton("asdf");
        panel.add(label);
        this.add(panel);
        //add(panel);
    }
    
    private BufferedImage setImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getResource(path));
        } catch (IOException e) {
        }
        return image;
    }
    
    public class Wall {
        
        private BufferedImage image;
        
        public Wall(BufferedImage image) {
            this.image = image;
            this.image.createGraphics();
        }
        
        
        
        
        
        
    }
    
}
