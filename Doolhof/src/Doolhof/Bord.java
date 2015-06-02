
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Danny
 */
public class Bord extends JComponent {

    private final ArrayList<Point> cellen;
    private final int afmeting = 40;
    private Point spelerPositie;
    private Point vriendPositie;
    
    public Bord() {
        cellen = new ArrayList<>();
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point cel : cellen) {
            int cellX = afmeting + (cel.x * afmeting);
            int cellY = afmeting + (cel.y * afmeting);
            
            g.setColor(Color.RED);
            g.fillRect(cellX, cellY, afmeting, afmeting);
        }
        
        int celX;
        int celY;
        
        //vriend tekenen
        g.setColor(Color.BLUE);
        celX = afmeting + (vriendPositie.x * afmeting);
        celY = afmeting + (vriendPositie.y * afmeting);
        g.fillOval(celX, celY, 38, 38);
        
        // speler tekenen
        g.setColor(Color.BLACK);
        celX = afmeting + (spelerPositie.x * afmeting);
        celY = afmeting + (spelerPositie.y * afmeting);
        g.fillOval(celX, celY, 38, 38); 
    }

    public void veldVullen(int x, int y) {
        cellen.add(new Point(x, y));
        repaint();
    }

    public void drawSpeler(Point positie) {
        this.spelerPositie = positie;
        repaint();
    }

    public void drawVriend(Point positie) {
        this.vriendPositie = positie;
        repaint();
    }
    
    public void drawBazooka(Point positie){
       
    }
}
