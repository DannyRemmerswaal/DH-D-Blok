/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author danny
 */
public class Helper extends SpelItem {
    
    private ArrayList<Vakje> pad = new ArrayList<>();
    private ArrayList<Vakje> kortstePad;   
    private int padLengte;
    
    public Helper() {
        image = setImage("/Images/helper.png");
    }
    
    @Override
    public void useItem(){  
        Vakje v = Speler.getMyVeld();
        zoekPad(v);
        printPad(kortstePad);
        System.out.println(kortstePad.size());
    }
        
    private void zoekPad(Vakje v) {
        
        if (!(v.getObject() instanceof Muur) && !(pad.contains(v))) {
            this.pad.add(v);
            if (v.getObject() instanceof Vriend) {
                System.out.println("Vriend gevonden");
                if (this.pad.size() < padLengte || padLengte == 0) {
                    kortstePad = (ArrayList<Vakje>) pad.clone();
                    padLengte = this.pad.size();
                }
            } else {
                for (Richting richting : Richting.values()) {
                    zoekPad(v.getBuur(richting));
                }
            }
            pad.remove(v);
        }
        
    }
    
    private void printPad(ArrayList<Vakje> pad) {
        for (Vakje vakje : pad) {
            vakje.setSnelleRoute(true);
        }
    }
    
}
