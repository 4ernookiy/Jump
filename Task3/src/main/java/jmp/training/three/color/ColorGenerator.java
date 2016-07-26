package jmp.training.three.color;

import java.awt.*;
import java.util.Random;

public class ColorGenerator implements IColorGenerator{

    private ColorGenerator() {
    }

    private static class GeneratorHolder{
        private final static IColorGenerator instance = new ColorGenerator();
    }
    public static IColorGenerator getInstance() {
        return GeneratorHolder.instance;
    }

    @Override
    public Color getColor() {
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        return new Color(r,g,b);
    }

    @Override
    public Color getColor(int r, int g, int b) {
        return new Color(r,g,b);
    }

    @Override
    public Color getColor(ColorMode mode) {
        switch (mode){
            case RED:
                return Color.RED;
            case BLUE:
                return Color.BLUE;
            case GREEN:
                return Color.GREEN;
        }
        return Color.BLACK;
    }
}
