/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

/**
 *
 * @author Danny
 */

public class Vakje{
    private SpelItem object;
    
    public Vakje() {
        this.object = null;
    }
    
    public Vakje(SpelItem object) {
        this.object = object;
    }

    /**
     * @return the object
     */
    public SpelItem getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(SpelItem object) {
        this.object = object;
    }
}
