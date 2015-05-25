/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Danny
 */
public class KeyFrame extends JFrame {

    private Listener listener;

    public KeyFrame() {
        createComponents();
        setSize(300, 100);
    }

    class startListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            Listener.doe = true;
        }
    }

    class stopListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            Listener.doe = false;
        }
    }

    private void createComponents() {
        listener = new Listener();
        ActionListener actionStart = new startListener() {
        };
        ActionListener actionStop = new stopListener() {
        };

        JButton jbStart = new JButton("Start");
        jbStart.addActionListener(actionStart);
        jbStart.setFocusable(false);

        JButton jbStop = new JButton("Stop");
        jbStop.addActionListener(actionStop);
        jbStop.setFocusable(false);

        JPanel panel = new JPanel();
        panel.add(jbStart);
        panel.add(jbStop);
        panel.add(listener);

        add(panel);
    }

}
