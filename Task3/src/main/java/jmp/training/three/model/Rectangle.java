package jmp.training.three.model;

import jmp.training.three.figure.AbstractFigure;

import java.awt.*;

public class Rectangle extends AbstractFigure {

    public Rectangle(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    @Override
    public void fill(int x, int y, Graphics graphics) {
        graphics.fillRect (x, y, getWidth(), getHeight());
    }
}
