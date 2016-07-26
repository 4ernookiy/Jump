package jmp.training.three.move;

import jmp.training.three.model.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MoveAction extends AbstractAction {
    private JFrame frame;
    private Figure figure;
    private Graphics graphics;

    private int x = 0;
    private int y = 0;
    private int step = 1;

    public MoveAction(JFrame frame, Figure figure) {
        this.frame = frame;
        this.graphics = frame.getGraphics();
        this.figure = figure;
    }

    public MoveAction(JFrame frame, Figure figure, int x, int y, int step) {
        this(frame, figure);
        this.x = x;
        this.y = y;
        this.step = step;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        System.out.println("11212");
        graphics.clearRect(0, 0, frame.getWidth(), frame.getHeight());
        graphics.setColor(figure.getColor());
        figure.fill(x, y, graphics);
        y += step;
        if (y > frame.getHeight() - figure.getHeight()) {
            step = -step;
        } else if (y < figure.getHeight() / 2) {
            step = -step;
        }
    }


}
