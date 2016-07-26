package jmp.training.three.figure;

import jmp.training.three.model.Figure;

import java.awt.*;

public abstract class AbstractFigure implements Figure {
    private Color color;
    private int width;
    private int height;

    @Override
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
