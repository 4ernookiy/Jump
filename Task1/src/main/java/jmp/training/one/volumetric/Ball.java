package jmp.training.one.volumetric;

import jmp.training.one.core.Volumetric;

public class Ball implements Volumetric {

	private double radius;
	
	public Ball(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getVolume() {
		return 4*Math.PI*radius*radius*radius/3;
	}

	@Override
	public String toString() {
		return "Ball";
	}

	
}
