package jmp.training.three.figure;

import java.awt.*;

public abstract class AbstractFigure implements Figure {
    protected final Color color = Color.BLUE;
    protected final int width = 15;
    protected final int height = 15;

    public AbstractFigure() {
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }


}
