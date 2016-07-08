package jmp.training.one.flat;

public class Rectangle implements Flat{

	private double a;
	private double b;
	
	public double getArea() {
		return a*b;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public Rectangle(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}
	
}
