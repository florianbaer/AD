package com.baerdev.ad.sw05.BallGame;

import javax.swing.*;
import java.awt.*;

public class Program extends JFrame {

    private final JPanel panel = new BallGamePanel(600, 600);

    /**
     * Konstruktor.
     */
    public Program() {
        super("Moving Balls");
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    /**
     * main-Methode.
     *
     * @param args
     *            nicht verwendet.
     */
    public static void main(final String[] args) {
        new Program();
    }
}
