/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Danny
 */
public final class Doolhof extends JPanel implements ActionListener {

    private final Timer timer;
    private final Level level = new Level();
    private Speler speler;
    private boolean speelbaar = true;

    public Doolhof() {
        maakDoolhof();

        //speler referentie ophalen
        Point point = level.getBeginPunt();
        Vakje[][] doolhofArray = level.getDoolhofArray();
        speler = (Speler) doolhofArray[point.x][point.y].getObject();

        addKeyListener(new Doolhof.KeyListener());
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
    }

    public void maakDoolhof() {
        GroupLayout gl = new GroupLayout(this);
        GroupLayout.ParallelGroup horizontal = gl.createParallelGroup();
        GroupLayout.ParallelGroup vertical = gl.createParallelGroup();



        for (Vakje[] Array : level.getDoolhofArray()) {
            for (Vakje subArray : Array) {
                horizontal.addComponent(subArray);
                vertical.addComponent(subArray);

            }
        }

        gl.setHorizontalGroup(horizontal);
        gl.setVerticalGroup(vertical);
        this.setLayout(gl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(getSpeler().getImage(), getSpeler().getObjectPositie().x * level.getGrootte(), getSpeler().getObjectPositie().y * level.getGrootte(), null);
    }

    public void reset() {
       // System.out.println("Reset");
    }

    public void repaintDoolhof() {
        removeAll();
        maakDoolhof();
    }

    /**
     * @return the speler
     */
    public Speler getSpeler() {
        return speler;
    }

    class KeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (speelbaar) {
                speler.actie(e, level);

            }
        }
    }

    public void setSpeelbaar(boolean speelbaar) {
        this.speelbaar = speelbaar;
    }
}
