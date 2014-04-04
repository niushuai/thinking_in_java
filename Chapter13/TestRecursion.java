package Chapter13;

public class TestRecursion {
	public String toString() {
		return "address is: " + super.toString();
	}
	public static void main(String[] args) {
		System.out.println(new TestRecursion());
		System.out.println(new Object());
	}
}
