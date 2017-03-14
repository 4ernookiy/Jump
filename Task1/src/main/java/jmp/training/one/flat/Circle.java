package jmp.training.one.flat;

import jmp.training.one.core.Flat;

/**
 * круг
 */
public class Circle implements Flat {

    private double radius;

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
