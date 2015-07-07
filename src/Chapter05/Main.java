package Chapter05;

public class Main {
	public static void main(String ...args) {
		System.out.println(args.length);
		for (String string : args) {
			System.out.println(string);
		}
	}
}
