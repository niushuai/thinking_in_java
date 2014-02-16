package Chapter05;

public class NewArgs {
	public static void print(Object ...args) {
		for (Object object : args) {
			System.out.print(object + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		print(new Object[]{
				new Integer(2), new Integer(3), new Integer(4)
		});
		print("hello", "world", "haha");
	}
}
