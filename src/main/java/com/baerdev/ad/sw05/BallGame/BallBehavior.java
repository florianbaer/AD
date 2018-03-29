package com.baerdev.ad.sw05.BallGame;

import javax.swing.*;
import java.awt.*;
/*
public class BallBehavior implements Runnable {

    private Ball ball;
    private JPanel panel;
    private int gravity = 5;

    public BallBehavior(Ball ball, JPanel panel){
        this.ball = ball;
        this.panel = panel;
    }

    @Override
    public void run() {
        // Initialisierungsphase
        /*try {
            while (Thread.currentThread().isInterrupted() == false && this.isOnGround()) {
                this.calcNewLocation();
                this.ball.draw();
            }
        } catch (InterruptedException ex) {
            // Thread wurde in einer Wartemethode unterbrochen
        } finally { // Aufräumphase
        }
    }

    private void calcNewLocation() {
        for(int counter = 1; counter<= 5 && this.getLowestY() >= this.panel.getHeight(); counter++){
            ball.setX(ball.getX());
            ball.setY(ball.getY()-1);
        }
    }

    private int getLowestY() {
        return this.ball.getY()-this.ball.getRadius();
    }

    private boolean isOnGround() {
        return false;
    }
}
*/