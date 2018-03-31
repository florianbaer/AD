package com.baerdev.ad.sw05.BallGame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;
import java.awt.Graphics2D;
import java.util.Random;

public class BallBehavior implements PanelDrawable, Runnable {
    private final Thread thread;
    private static final Logger LOG = LogManager.getLogger(BallBehavior.class);
    private Ball ball;
    private int panelHeight;
    private final Random random = new Random();

    public BallBehavior(Ball ball, int panelHeight) {
        this.ball = ball;
        this.panelHeight = panelHeight;
        this.thread = Thread.currentThread();

    }

    public boolean isAtTheBottom(Ball ball) {
        return ball.getY() <= (panelHeight - ball.getDiameter()) ? true : false;
    }

    public Thread getThreadBehindBall() {
        return this.thread;
    }


    /**
     * run-Methode, welche den Kreis bewegt, in dem der y-Wert veraendert wird.
     */
    @Override
    public void run() {
        try {
            while (this.thread.isInterrupted() == false) {
                while (this.ball.getY() <= (this.panelHeight - this.ball.getDiameter())) {
                    Thread.sleep(random.nextInt(10));
                    this.ball.setY(this.ball.getY() + random.nextInt(5));
                }
            }
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
            this.thread.interrupt();
        }
    }

    public Ball getBall(){return this.ball;}

    @Override
    public void drawCircle(Graphics2D g) {
        g.setColor(this.ball.getColor());
        g.fillOval(this.ball.getX(), this.ball.getY(), this.ball.getDiameter(), this.ball.getDiameter());

    }
}