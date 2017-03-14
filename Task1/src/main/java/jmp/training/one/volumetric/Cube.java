package jmp.training.one.volumetric;

import jmp.training.one.core.Volumetric;
import jmp.training.one.flat.Square;

public class Cube implements Volumetric {

	private Square base;

	public double getVolume() {
		return base.getArea() * base.getA();
	}

	public Square getBase() {
		return base;
	}

	public void setBase(Square base) {
		this.base = base;
	}

	public Cube() {
		super();
	}

	public Cube(Square base) {
		super();
		this.base = base;
	}

	@Override
	public String toString() {
		return "Cube";
	}
	
}
