package jmp.training.three.figure;

public class SimpleFactoryOne implements IFigureFactory {
    @Override
    public Ball getBall(int radius) {
        return new Ball(radius);
    }

    @Override
    public Rectangle getRectangle(int x, int y) {
        return new Rectangle();
    }
}
