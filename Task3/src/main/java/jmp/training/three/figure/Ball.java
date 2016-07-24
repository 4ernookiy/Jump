package jmp.training.three.figure;

import java.awt.*;

public class Ball extends AbstractFigure {
    private int radius;

    public Ball(int radius) {
        this.radius = radius;
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
