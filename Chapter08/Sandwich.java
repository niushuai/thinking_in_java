package Chapter08;

class Meal {
	Meal() {
		System.out.println("Meal()");
	}
}

class Bread {
	Bread() {
		System.out.println("Bread()");
	}
}

class Cheese {
	Cheese() {
		System.out.println("Cheese()");
	}
}

class Lettuce {
	Lettuce() {
		System.out.println("Lettuce()");
	}
}

class Launch extends Meal {
	Launch() {
		System.out.println("Launch()");
	}
}

class PortableLaunch extends Launch {
	PortableLaunch() {
		System.out.println("PortableLaunch()");
	}
}

public class Sandwich extends PortableLaunch{
	
	Sandwich() {
		System.out.println("Sandwich()");
	}
	private Bread bread = new Bread();
	private Cheese cheese = new Cheese();
	private Lettuce lattuce = new Lettuce();
	public static void main(String[] args) {
		new Sandwich();
	}
}
