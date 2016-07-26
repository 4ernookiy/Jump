package jmp.training.three.model;

import jmp.training.three.figure.AbstractFigure;

import java.awt.*;

public class Ball extends AbstractFigure {
    private int radius;

    public Ball(int radius) {
        this.radius = radius;
        this.setWidth(radius);
        this.setHeight(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void fill(int x, int y, Graphics graphics) {
        graphics.setColor(getColor());
        graphics.fillOval(x,y,radius,radius);
    }

}
