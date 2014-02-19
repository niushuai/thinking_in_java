package Chapter07;

class Shape {
	public Shape(int i) {
		System.out.println("Shape Constructor");
	}

	public void dispose() {
		System.out.println("Shape Dispose");
	}
}

class Circle extends Shape {
	public Circle(int i) {
		super(i);
		System.out.println("Circle Constructor");
	}

	public void dispose() {
		System.out.println("erasing circle");
		super.dispose();
	}
}

class Triangle extends Shape {
	public Triangle(int i) {
		super(i);
		System.out.println("Triangle Consturctor");
	}

	public void dispose() {
		System.out.println("erasing trigangle");
		super.dispose();
	}
}

public class CADSystem extends Shape {
	public CADSystem(int i) {
		super(i);
		System.out.println("CADSystem Constructor");
	}

	public void dispose() {
		circle.dispose();
		triangle.dispose();
		super.dispose();
		System.out.println("CADSystem dispose");
	}

	int i = 5;
	private Circle circle = new Circle(i);
	private Triangle triangle = new Triangle(i);

	public static void main(String[] args) {
		CADSystem cadSystem = new CADSystem(47);
		try {
			// do something
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cadSystem.dispose();
		}
	}
}
