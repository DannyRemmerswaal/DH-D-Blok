/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.Point;

/**
 *
 * @author Danny R
 */
public class Speler {

    private final Point startPositie;
    private Point positie;

    public Speler() {
        this.startPositie = new Point (1, 1);
        this.positie = startPositie;
    }
    
    public Point getPositie() {
        return this.positie;
    }

    public void setPositie(Point positie) {
        this.positie = new Point(positie);
    }

}
