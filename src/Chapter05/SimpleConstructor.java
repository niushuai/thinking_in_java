package Chapter05;

class Rock {
	public Rock() {
		System.out.println("Rock constructor!");
	}
}

public class SimpleConstructor {
	public static void main(String[] args) {
		for(int i = 0; i < 10; ++i) {
			new Rock();
		}
	}
}
