package jmp.training.one;

import jmp.training.one.core.Figure;
import jmp.training.one.core.Volumetric;
import jmp.training.one.flat.Circle;
import jmp.training.one.flat.Rectangle;
import jmp.training.one.flat.Square;
import jmp.training.one.volumetric.*;

public class AppExample {

	public static void main(String[] args) {

		Figure complexFigure = new ComplexFigure();

		Volumetric cube = new Cube(new Square(10));
		Volumetric regPyramid = new RegularPyramid(new Square(5), 7);
		Volumetric cuboid = new Cuboid(new Rectangle(2, 1), 3);
		Volumetric cylinder = new Cylinder(new Circle(2), 5);
		Volumetric ball = new Ball(3);

		complexFigure.add(cube);
		complexFigure.add(regPyramid);
		complexFigure.add(cuboid);
		complexFigure.add(cylinder);
		complexFigure.add(ball);

		System.out.println(complexFigure);
		System.out.println(complexFigure.getVolume());
	}
}
