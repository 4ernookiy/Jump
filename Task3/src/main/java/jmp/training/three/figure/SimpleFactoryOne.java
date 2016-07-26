package jmp.training.three.figure;

import jmp.training.three.color.ColorGenerator;
import jmp.training.three.color.ColorMode;
import jmp.training.three.model.Ball;
import jmp.training.three.model.Rectangle;

public class SimpleFactoryOne implements IFigureFactory {
    @Override
    public Ball getBall(int radius) {
        Ball b = new Ball(radius);
        b.setColor(ColorGenerator.getInstance().getColor(ColorMode.RED));
        return b;
    }

    @Override
    public Rectangle getRectangle(int x, int y) {
        Rectangle r = new Rectangle(x, y);
        r.setColor(ColorGenerator.getInstance().getColor());
        return r;
    }
}
