package com.baerdev.ad.sw05.BallGame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.awt.Color;
import java.util.List;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball implements Runnable {
    private final List<Color> colorList;
    private final Color color;
    private final int diameter;
    private final Random random;
    private int x;
    private int y;
    private final Thread thread;
    private static final Logger LOG = LogManager.getLogger(Ball.class);

    public Ball(final int x, final int y) {
        this.thread = Thread.currentThread();
        this.colorList = new ArrayList<>();
        colorList.add(Color.RED);
        colorList.add(Color.GREEN);
        colorList.add(Color.BLUE);
        this.random = new Random();
        this.diameter = (20 + random.nextInt(51));
        this.color = colorList.get(random.nextInt(3));
        this.x = x;
        this.y = y;
    }

    public boolean isAtTheBottom() {
        return this.y <= (600 - this.diameter) ? true : false;
    }

    public Thread getThreadBehindBall() {
        return this.thread;
    }

    /**
     * Zeichnet den Kreis
     *
     * @param g
     *            Graphics2D Objekt
     */
    public void drawCircle(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }

    /**
     * run-Methode, welche den Kreis bewegt, in dem der y-Wert veraendert wird.
     */
    @Override
    public void run() {
        try {
            while (this.thread.isInterrupted() == false) {
                while (this.y <= (600 - this.diameter)) {
                    Thread.sleep(random.nextInt(10));
                    this.y = this.y + random.nextInt(5);
                }
            }
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
            this.thread.interrupt();
        }
    }
}