package jmp.training.three.was;

import jmp.training.three.figure.Figure;

import javax.swing.*;
import java.awt.*;

public class MoveImpl implements Move {
    private final JFrame frame;
    private final Figure figure;
    private final Graphics graphics;


    private int x = 0;
    private int y = 0;
    private int step = 1;
    private int delay = 1;


    public MoveImpl(JFrame frame, Figure figure) {
        this.frame = frame;
        this.graphics = frame.getGraphics();
        this.figure = figure;
    }


    public MoveImpl(JFrame frame, Figure figure, int x, int y, int step, int delay) {
        this(frame, figure);
        this.x = x;
        this.y = y;
        this.step = step;
        this.delay = delay;
    }


    @Override
    public void move() {
        new Timer(delay, new MoveAction(frame, figure, 200, 50, 2)).start();
    }



}
