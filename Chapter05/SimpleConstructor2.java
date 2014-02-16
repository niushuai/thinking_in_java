package Chapter05;

class Rock2 {
	public Rock2(int i) {
		System.out.println("Rock2 constructor! i is: " + i);
	}
}

public class SimpleConstructor2 {
	public static void main(String[] args) {
		for(int i = 0; i < 10; ++i) {
			new Rock2(i);
		}
	}
}
