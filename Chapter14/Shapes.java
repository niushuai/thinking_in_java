package Chapter14;

import java.util.*;

abstract class Shape {
	void draw() {
		System.out.println(this + ".draw()");
	}
	abstract public String toString();
}

class Circle extends Shape {
	public String toString() {
		return "Circle";
	}
}

class Triangle extends Shape {
	public String toString() {
		return "Trangle";
	}
}

class Square extends Shape {
	public String toString() {
		return "Square";
	}
}

public class Shapes {
	public static void main(String[] args) {
		List<Shape> shapes = Arrays.asList(new Circle(), new Square(), new Triangle());
		for(Shape shape : shapes) {
			shape.draw();
		}
	}
}
