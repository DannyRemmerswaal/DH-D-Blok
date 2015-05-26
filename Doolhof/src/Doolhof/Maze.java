/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class Maze {

    private static Grid grid;
    private static Speler speler;
    private static Vriend vriend;
    private static JFrame venster;
    private static boolean start = true;
    private static final Veld[][] velden = {
        {new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur())},
        {new Veld(new Muur()), new Veld(), new Veld(), new Veld(new Muur()), new Veld(), new Veld(new Muur()), new Veld(new Muur()), new Veld(), new Veld(new Muur())},
        {new Veld(new Muur()), new Veld(), new Veld(new Muur()), new Veld(new Muur()), new Veld(), new Veld(), new Veld(), new Veld(), new Veld(new Muur())},
        {new Veld(new Muur()), new Veld(), new Veld(), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(), new Veld(new Muur())},
        {new Veld(new Muur()), new Veld(), new Veld(new Muur()), new Veld(), new Veld(), new Veld(), new Veld(new Muur()), new Veld(), new Veld(new Muur())},
        {new Veld(new Muur()), new Veld(), new Veld(), new Veld(), new Veld(new Muur()), new Veld(), new Veld(), new Veld(), new Veld(new Muur())},
        {new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur()), new Veld(new Muur())
        }
    };

    public static void main(String[] a) {
        grid = new Grid();
        grid.setPreferredSize(new Dimension(300, 300));

        KeyListener listener = new Keys();
        ActionListener actionStart = new StartListener() {
        };
        ActionListener actionStop = new StopListener() {
        };
        ActionListener actionReset = new ResetListener() {
        };

        JPanel knoppen = new JPanel();
        JButton jbStart = new JButton("Start");
        jbStart.addActionListener(actionStart);
        jbStart.setFocusable(false);
        JButton jbStop = new JButton("Stop");
        jbStop.addActionListener(actionStop);
        jbStop.setFocusable(false);
        JButton jbReset = new JButton("Reset");
        jbReset.addActionListener(actionReset);
        jbReset.setFocusable(false);
        knoppen.add(jbStart);
        knoppen.add(jbStop);
        knoppen.add(jbReset);

        venster = new JFrame();
        venster.setTitle("Doolhof");
        venster.setLayout(new BorderLayout());
        venster.addKeyListener(listener);
        venster.setSize(500, 500);
        venster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        venster.add(knoppen, BorderLayout.NORTH);
        venster.add(grid, BorderLayout.CENTER);
        venster.setVisible(true);

        gridVullen();

        speler = new Speler();
        vriend = new Vriend();
        grid.drawSpeler(speler.getPositie());
        grid.drawVriend(vriend.getEindpositie());
    }
    
    public static void gridVullen() {
        for (int i = 0; i < velden.length; i++) {
            for (int j = 0; j < velden[i].length; j++) {
                if (velden[i][j].getObject() instanceof Muur) {
                    grid.veldVullen(j, i);
                }
            }
        }
    }

    static class Keys extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {

            Point oud = speler.getPositie();
            int x = oud.x;
            int y = oud.y;

            if (start) {
                switch (event.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        y = y - 1;
                        break;
                    case KeyEvent.VK_DOWN:
                        y = y + 1;
                        break;
                    case KeyEvent.VK_RIGHT:
                        x = x + 1;
                        break;
                    case KeyEvent.VK_LEFT:
                        x = x - 1;
                        break;
                    case KeyEvent.VK_SPACE:
                        System.out.println("Key: space"); //bazooka afvuren
                        velden[1][3].setObject(null);
                        gridVullen();
                        
                        break;
                }
                // Muur check
                boolean muur = velden[y][x].getObject() instanceof Muur;
                if (!muur) {
                    Point nieuw = new Point(x, y);
                    speler.setPositie(nieuw);
                }
                // Vriend check
                if (speler.getPositie().equals(vriend.getEindpositie())) {
                    System.out.println("Gewonnen!");
                    start = false;
                }
                // Speler tekenen
                grid.drawSpeler(speler.getPositie());
            }
        }
    }

    static class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            start = true;
        }
    }

    static class StopListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            start = false;
        }
    }

    static class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            start = true;
            Point reset = new Point(1, 1);
            speler.setPositie(reset);
            grid.drawSpeler(speler.getPositie());
        }
    }

}
