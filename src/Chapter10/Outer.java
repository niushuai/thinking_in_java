package Chapter10;

public class Outer {
	
	class Inner {
		public void sayHello() {
			System.out.println("Hello");
		}
	}
	
	public Inner getInner() {
		return new Inner();
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.getInner();
		inner.sayHello();
	}

}
