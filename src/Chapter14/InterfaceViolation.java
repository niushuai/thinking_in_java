package Chapter14;

class B implements A {
	public void f() {
		
	}
	public void g() {
		
	}
}

public class InterfaceViolation {
	public static void main(String[] args) {
		A a = new B();
		a.f();
		//a.g(); Compile Error
		System.out.println(a.getClass().getName());
		if( a instanceof B) {
			B b = (B)a;
			b.g();
		}
	}
}
