package Chapter08;

class Shape {
	public void draw() {}
	public void erase() {}
}

class Circle extends Shape {
	public void draw() {
		System.out.println("Circle draw");
	}
	public void erase() {
		System.out.println("Circle erase");
	}
}

class Triangle extends Shape {
	public void draw() {
		System.out.println("Triangle draw");
	}
	public void erase() {
		System.out.println("Triangle erase");
	}
}

public class ShuffleShape {
	public static void main(String[] args) {
		Shape shape = new Circle();
		Shape shape2 = new Triangle();
		
		shape.draw();
		shape.erase();
		shape2.draw();
		shape2.erase();
	}
}
