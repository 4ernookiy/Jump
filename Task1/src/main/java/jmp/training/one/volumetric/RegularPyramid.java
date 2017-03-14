package jmp.training.one.volumetric;

import jmp.training.one.core.Volumetric;
import jmp.training.one.flat.Square;

/**
 * правильная пирамида 
 */
public class RegularPyramid implements Volumetric {

	private Square square;
	private double hight;

	public double getVolume() {
		return hight * square.getArea() / 3;
	}

	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	public RegularPyramid(Square square, double hight) {
		super();
		this.square = square;
		this.hight = hight;
	}

	@Override
	public String toString() {
		return "RegularPyramid";
	}
	
	

}
