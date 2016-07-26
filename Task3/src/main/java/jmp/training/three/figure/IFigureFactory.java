package jmp.training.three.figure;

import jmp.training.three.model.Ball;
import jmp.training.three.model.Rectangle;

public interface IFigureFactory {

    Ball getBall(int radius);
    Rectangle getRectangle(int x, int y);

}
