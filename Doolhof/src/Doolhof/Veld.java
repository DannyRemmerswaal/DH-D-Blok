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

public class Veld{
    private DoolhofObject object;
    
    public Veld() {
        this.object = null;
    }
    
    public Veld(DoolhofObject object) {
        this.object = object;
    }

    /**
     * @return the object
     */
    public DoolhofObject getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(DoolhofObject object) {
        this.object = object;
    }
}
