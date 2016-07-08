package jmp.training.one;

import jmp.training.one.flat.Rectangle;
import jmp.training.one.flat.Square;
import jmp.training.one.volumetric.ComplexFigure;
import jmp.training.one.volumetric.Cube;
import jmp.training.one.volumetric.Cuboid;
import jmp.training.one.volumetric.RegularPyramid;
import jmp.training.one.volumetric.Volumetric;

public class AppExample {

	public static void main(String[] args) {

		ComplexFigure complexFigure = new ComplexFigure();

		Volumetric cube = new Cube(new Square(10));
		Volumetric regPyramid = new RegularPyramid(new Square(5), 7);
		Volumetric cuboid = new Cuboid(new Rectangle(2, 1), 3);

		complexFigure.add(cube);
		complexFigure.add(regPyramid);
		complexFigure.add(cuboid);

		System.out.println(complexFigure);
		System.out.println(complexFigure.getVolume());
	}
}
