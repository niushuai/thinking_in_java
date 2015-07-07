package Chapter07;

class Simple {
	String string;
}

public class LazyInit {
	static Simple simple;

	public static void main(String[] args) {
		if (simple != null) {
			System.out.println("Init already");
		} else {
			simple = new Simple();
			System.out.println("lazy Init");
		}
	}
}
