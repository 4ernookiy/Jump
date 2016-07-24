package jmp.training.three.color;

import java.awt.*;

public interface IColorGenerator {
    Color getColor();
    Color getColor(int r, int g, int b);
    Color getColor(ColorMode mode);

}
