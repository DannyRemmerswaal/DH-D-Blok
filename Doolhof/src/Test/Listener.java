/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Listener extends JPanel {

    public static boolean doe = false;
    public static String fiets;

    public String iets(String fiets) {
        String value = fiets;
        return value;
    }
    
    public Listener() {
        KeyListener listener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent event) {
                KeyFrame kf = new KeyFrame();
                
                if (doe) {
                    switch (event.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            System.out.println("Key: up");
                            break;
                        case KeyEvent.VK_DOWN:
                            System.out.println("Key: down");
                            break;
                        case KeyEvent.VK_RIGHT:
                            System.out.println("Key: right");
                            break;
                        case KeyEvent.VK_LEFT:
                            System.out.println("Key: left");
                            break;
                        case KeyEvent.VK_SPACE:
                            System.out.println("Key: space");
                            break;
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        addKeyListener(listener);
        setFocusable(true);
    }
}
