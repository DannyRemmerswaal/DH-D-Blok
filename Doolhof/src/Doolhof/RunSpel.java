/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author danny
 */
public class RunSpel {
    private static int nummer = 1;
    private static final JFrame frame = new JFrame();
    private static final JPanel menu = new JPanel();
    private static final JPanel aantalstappen = new JPanel();
    private static Doolhof doolhof;
    private static String huidiglevel;
    private static int breedte = 660;
    private static int hoogte = 600;
    static JLabel aantalStappenGezet;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        huidiglevel = "src/Levels/level" + nummer + ".txt";
        doolhof = new Doolhof(huidiglevel);
        frame.setTitle("Maze game");
        frame.setLayout(new BorderLayout());
        
        ActionListener actionStart = new StartListener() {
        };
        ActionListener actionStop = new StopListener() {
        };
        ActionListener actionReset = new ResetListener() {
        };
        
        JButton start = new JButton("Start");
        start.addActionListener(actionStart);
        start.setFocusable(false);
        JButton stop = new JButton("Pauze");
        stop.addActionListener(actionStop);
        stop.setFocusable(false);
        JButton reset = new JButton("Reset");
        reset.addActionListener(actionReset);
        reset.setFocusable(false);
        
        menu.add(start);
        menu.add(stop);
        menu.add(reset);
        
        JLabel text = new JLabel ("Aantal stappen gezet: ");
        aantalStappenGezet = new JLabel("" + Speler.getStappen());
        
        aantalstappen.add(text);
        aantalstappen.add(aantalStappenGezet);
        
        frame.add(menu, BorderLayout.NORTH);
        frame.add(doolhof, BorderLayout.CENTER);
        frame.add(aantalstappen, BorderLayout.SOUTH);
        frame.setSize(breedte, hoogte);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void reset() {
        huidiglevel = "src/Levels/level" + nummer + ".txt";
        frame.remove(doolhof);
        doolhof = new Doolhof(huidiglevel);  
        Speler.setStappen(0);
        frame.add(doolhof, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(breedte, hoogte);
        doolhof.requestFocusInWindow();
    }
    
    
    static class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            doolhof.setSpeelbaar(true);
        }
    }

    static class StopListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            doolhof.setSpeelbaar(false);
        }
    }
    
    static class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            RunSpel.reset();
        }
    }
    
    
    public static int getNummer() {
        return nummer;
    }

    public static void setNummer(int nummer) {
        RunSpel.nummer = nummer;
    }
    
}
