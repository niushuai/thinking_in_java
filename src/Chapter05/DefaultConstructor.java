package Chapter05;

class Default {
	Default() {
		System.out.println("Default constructor!");
	}
	
	Default(String str) {
		System.out.println("constructor argument is:" + str);
	}
}

public class DefaultConstructor {
	public static void main(String[] args) {
		new Default();
		new Default("Hello");
	}
}
