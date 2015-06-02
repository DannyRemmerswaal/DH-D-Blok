/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Doolhof;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author danny
 */
public final class Level {

    private final ArrayList<String> map = new ArrayList<>();
    private Vakje[][] doolhof;
    private final int grootte = 40;
    private Point beginPunt;
    private Point eindPunt;

    public Level() {
        openLevel();
        maakArray();
        setBuren();
    }

    public void openLevel() {
        try {
            Scanner in = new Scanner(new File("src/Levels/level1.txt"));
            while (in.hasNextLine()) {
                map.add(in.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Level kon niet worden geladen.");
        }
    }

    public void maakArray() {
        int rijen = map.size();
        int kolommen = map.get(0).length();
        doolhof = new Vakje[rijen][kolommen];
        for (int i = 0; i < rijen; i++) {
            for (int j = 0; j < kolommen; j++) {
                if (Character.toString(map.get(i).charAt(j)).equals("s")) {
                    beginPunt = new Point(j, i);
                    Vakje vakje = new Vakje(getGrootte() * i, getGrootte() * j, null);
                    vakje.setObject(new Speler(beginPunt, vakje));
                    doolhof[i][j] = vakje;
                }
                if (Character.toString(map.get(i).charAt(j)).equals("g")) {
                    Vakje vakje = new Vakje(getGrootte() * i, getGrootte() * j, null);
                    doolhof[i][j] = vakje;
                }
                if (Character.toString(map.get(i).charAt(j)).equals("W")) {
                    Vakje muur = new Vakje(getGrootte() * i, getGrootte() * j, new Muur(true));
                    doolhof[i][j] = muur;
                }
                if (Character.toString(map.get(i).charAt(j)).equals("w")) {
                    Vakje muur = new Vakje(getGrootte() * i, getGrootte() * j, new Muur(false));
                    doolhof[i][j] = muur;
                }
                if (Character.toString(map.get(i).charAt(j)).equals("f")) {
                    Vakje vriend = new Vakje(getGrootte() * i, getGrootte() * j, new Vriend());
                    doolhof[i][j] = vriend;
                    eindPunt = new Point(j, i);
                }
                if (Character.toString(map.get(i).charAt(j)).equals("b")) {
                    Vakje bazooka = new Vakje(getGrootte() * i, getGrootte() * j, new Bazooka());
                    doolhof[i][j] = bazooka;
                }
            }
        }
    }

    private void setBuren() {
        int rijen = map.size();
        int kolommen = map.get(0).length();
        for (int i = 1; i < rijen -1; i++) {
            for (int j = 1; j < kolommen -1; j++) {
                Vakje veld = doolhof[i][j];
                veld.setBuren(i, j, doolhof);
            }
        }
    }

    public Vakje[][] getDoolhofArray() {
        return doolhof;
    }

    public int getGrootte() {
        return grootte;
    }

    public Point getBeginPunt() {
        return beginPunt;
    }

    public Point getEindPunt() {
        return eindPunt;
    }
}
