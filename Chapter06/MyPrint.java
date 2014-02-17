package Chapter06;

class Print {
	public static void print(Object obj) {
		System.out.print(obj);
	}
	
	public static void println(Object obj) {
		System.out.println(obj);
	}
}

public class MyPrint {
	public static void main(String[] args) {
		Print.println("haha");
		Print.print("hello");
		Print.print(" world");
	}
}
