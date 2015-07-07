package Chapter05;

class Test {
	String str;
}

public class StringInit {
	public static void main(String[] args) {
		Test test = new Test();
		if(test.str == null) {
			System.out.println("String Init null");
		} else {
			System.out.println("String Init isn't null");
		}
	}
}
