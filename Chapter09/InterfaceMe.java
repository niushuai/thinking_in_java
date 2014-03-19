package Chapter09;

interface HelloNiu {
	public void print();

	public void hello();
}

class HelloNiuImpl implements HelloNiu {
	public void print() {
		System.out.println("HelloNiuImpl print");
	}

	public void hello() {
		System.out.println("HelloNiuImpl hello");
	}
}

class HelloNiuImpl2 implements HelloNiu {
	public void print() {
		System.out.println("HelloNiuImpl2 print");
	}

	public void hello() {
		System.out.println("HelloNiuImpl2 hello");
	}
}

public class InterfaceMe {
	public static void main(String[] args) {
		// HelloNiu helloNiu = new HelloNiu();
		HelloNiu helloNiu2 = new HelloNiuImpl();
		HelloNiu helloNiu3 = new HelloNiuImpl2();
		helloNiu2.print();
		helloNiu2.hello();
		helloNiu3.print();
		helloNiu3.hello();
	}
}
