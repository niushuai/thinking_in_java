package Chapter05;

public class Over {
	static void f(float f, Character ...characters) {
		System.out.println("first");
	}
	static void f(char c, Character ...characters) {
		System.out.println("second");
	}
	
	public static void main(String[] args) {
		f(1, 'a');
		f('a', 'b');
	}
}
