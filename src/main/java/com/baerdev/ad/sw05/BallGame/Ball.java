package com.baerdev.ad.sw05.BallGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ball {
    private int x;
    private int y;
    private int diameter;
    private Color color;
    private final List<Color> colorList;
    private final Random random;

    public Ball(final int x, final int y) {
        this.x = x;
        this.y = y;

        this.colorList = new ArrayList<>();
        colorList.add(Color.RED);
        colorList.add(Color.GREEN);
        colorList.add(Color.BLUE);
        this.random = new Random();
        this.setColor(colorList.get(random.nextInt(3)));


        this.diameter = (20 + random.nextInt(51));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getDiameter(){return this.diameter;}

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color){this.color = color;}
}
