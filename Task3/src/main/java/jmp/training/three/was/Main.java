package jmp.training.three.was;

import jmp.training.three.figure.AbstractFigureFactory;
import jmp.training.three.figure.Ball;
import jmp.training.three.figure.Figure;
import jmp.training.three.figure.Rectangle;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        Figure figure = new Ball();
//        Figure figure2 = new Rectangle();
        Figure figure = AbstractFigureFactory.getInstance().getBall(50);
// Figure figure = AbstractFigureFactory.getInstance().getRectangle(50,70);
//        JFrame frame = FrameHelper.getInstance().createFrame("Task", 500, 600);
        Color gray = new Color(120, 119, 117);
        JFrame frame = new FrameHelper.FrameBuilder().
                title("test").height(600).width(400).color(gray).build();

        Move move = new MoveImpl(frame, figure, 200, 50, 2, 20);
        move.move();

//        Move move2 = new MoveImpl(frame, figure2, 100, 50, 3, 50);
//        move2.move();

    }
}
