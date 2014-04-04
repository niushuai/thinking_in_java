package Chapter13;

public class SimpleFormat {
	public static void main(String[] args) {
		int x = 5;
		double y = 5.33333;
		System.out.println("Row 1 : [" + x + " " + y + "]");
		
		//new way
		
		System.out.format("[%d %f]\n", x, y);
		System.out.printf("%d %f\n", x, y);
	}
}
