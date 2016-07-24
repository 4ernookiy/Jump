package jmp.training.three.figure;

public interface IFigureFactory {

    Ball getBall(int radius);
    Rectangle getRectangle(int x, int y);

}
