package Chapter07;

class A {
	public A() {
		System.out.println("A()");
	}
}

class B {
	public B() {
		System.out.println("B()");
	}
}

public class ABC extends A{
	public static void main(String[] args) {
		ABC abc = new ABC();
		B b = new B();
	}
}
