package jmp.training.three.test;

import jmp.training.three.color.ColorGenerator;
import jmp.training.three.figure.AbstractFigureFactory;
import jmp.training.three.model.*;
import jmp.training.three.frame.AwtFrame;
import jmp.training.three.move.Move;
import jmp.training.three.move.MoveImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

//        java.util.List<Ball> ballList = AbstractFigureFactory.<jmp.training.three.model.Ball>newList("r");

//        Figure figure= AbstractFigureFactory.getInstance().getRectangle(70,20);;
        Figure figure = AbstractFigureFactory.getInstance().getBall(50);

        figure = new DecoratorJson(figure);
        logger.info("construct figure with color:{}", figure.getColor().toString());

        Color gray = ColorGenerator.getInstance().getColor(120, 119, 117);

        JFrame frame = new AwtFrame.Builder().
                title("test").
                withLocationX(350).
                withLocationY(60).
                height(500).
                width(300).
                backgroung(gray).
                build();
        logger.info("construct frame:{}", frame);

        Move move = new MoveImpl(frame, figure, 150, 50, 2, 20);
        move.move();

    }
}
