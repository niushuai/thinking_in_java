package Chapter07;

class Component1 {
	public Component1() {
		System.out.println("Component1()");
	}
}

class Component2 {
	public Component2() {
		System.out.println("Component2()");
	}
}

class Robot {
	public Component1 component1 = new Component1();
	public Component2 component2 = new Component2();
	
	public Robot() {
		System.out.println("Robot()");
	}
}

public class Root extends Robot{
	public Root() {
		System.out.println("Root()");
	}
	public static void main(String[] args) {
		Root root = new Root();
	}
}
