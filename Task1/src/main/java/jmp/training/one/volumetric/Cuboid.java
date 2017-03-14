package jmp.training.one.volumetric;

import jmp.training.one.core.Volumetric;
import jmp.training.one.flat.Rectangle;

/**
 * Прямоугольный параллелепипед 
 */
public class Cuboid implements Volumetric {

	private Rectangle rectangle;
	private double hight;

	public double getVolume() {
		return rectangle.getArea() * hight;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	public Cuboid(Rectangle rectangle, double hight) {
		super();
		this.rectangle = rectangle;
		this.hight = hight;
	}

	@Override
	public String toString() {
		return "Cuboid";
	}
	
	
	
}
