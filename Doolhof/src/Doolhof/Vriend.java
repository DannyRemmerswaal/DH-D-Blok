/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.Point;

/**
 *
 * @author Danny
 */
public class Vriend {
    
    private final Point eindpositie;
    
    public Vriend() {
        this.eindpositie = new Point (7, 1);
    }
    
    public Point getEindpositie() {
        return this.eindpositie;
    }

}
