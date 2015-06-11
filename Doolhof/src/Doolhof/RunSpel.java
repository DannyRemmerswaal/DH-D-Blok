/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.BorderLayout;
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
    
    
    private static final Doolhof doolhof = new Doolhof();
    static JLabel aantalStappenGezet;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel menu = new JPanel();
        JPanel aantalstappen = new JPanel();
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
        aantalStappenGezet = new JLabel("" + Speler.stappen);
        
        aantalstappen.add(text);
        aantalstappen.add(aantalStappenGezet);
        
        frame.add(menu, BorderLayout.NORTH);
        frame.add(doolhof, BorderLayout.CENTER);
        frame.add(aantalstappen, BorderLayout.SOUTH);
        frame.setSize(660, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            doolhof.reset();
        }
    }
    
}
