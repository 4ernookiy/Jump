package jmp.training.one.flat;

import jmp.training.one.core.Flat;

public class Square implements Flat{

	private double a;
	
	public double getArea() {
		return a*a;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public Square(double a) {
		super();
		this.a = a;
	}
	
}
