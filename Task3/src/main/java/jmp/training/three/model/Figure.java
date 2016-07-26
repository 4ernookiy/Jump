package jmp.training.three.model;

import java.awt.*;

public interface Figure {
    Color getColor();

    void fill(int x, int y, Graphics graphics);

    int getHeight();

    int getWidth();
}
