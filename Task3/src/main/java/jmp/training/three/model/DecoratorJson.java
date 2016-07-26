package jmp.training.three.model;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class DecoratorJson implements Figure {
    private static final Logger logger = LoggerFactory.getLogger(DecoratorJson.class);
    private Gson gson = new Gson();
    private Figure figure;

    public DecoratorJson(Figure figure) {
        this.figure = figure;
    }

    @Override
    public Color getColor() {
        return figure.getColor();
    }

    @Override
    public void fill(int x, int y, Graphics graphics) {
        String json = gson.toJson(figure);
        logger.info("drawning figure: {}", json);
        figure.fill(x, y, graphics);
    }

    @Override
    public int getHeight() {
        return figure.getHeight();
    }

    @Override
    public int getWidth() {
        return figure.getWidth();
    }


    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}
