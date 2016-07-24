package jmp.training.three.figure;

import java.awt.*;

public class Rectangle extends AbstractFigure {
    public Rectangle() {
    }

    @Override
    public void fill(int x, int y, Graphics graphics) {
        graphics.fillRect (x, y, getWidth(), getHeight());
    }
}
