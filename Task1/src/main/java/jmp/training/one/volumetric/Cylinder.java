package jmp.training.one.volumetric;

import jmp.training.one.core.Volumetric;
import jmp.training.one.flat.Circle;

/**
 * Created by D on 10.07.2016.
 */
public class Cylinder implements Volumetric{

    private Circle circle;

    private double hight;

    @Override
    public double getVolume() {
        return circle.getArea()*hight;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public Cylinder() {
    }

    public Cylinder(Circle circle, double hight) {
        this.circle = circle;
        this.hight = hight;
    }

    @Override
    public String toString() {
        return "Cylinder";
    }
}
