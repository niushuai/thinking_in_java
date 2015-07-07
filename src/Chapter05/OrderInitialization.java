package Chapter05;

class Window {
	Window(int num) {
		System.out.println("windows constructor: " + num);
	}
}
 class House {
	Window window1 = new Window(1);
	public void print() {
		Window window3 = new Window(3);
	}
	Window window2 = new Window(2);
}

public class OrderInitialization {
	public static void main(String[] args) {
		House house = new House();
		house.print();
	}
}
