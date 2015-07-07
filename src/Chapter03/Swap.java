package Chapter03;

class Point {
	int x;
	int y;
}

public class Swap {
	public static void swap1(Point x, Point y) {
		Point temp;
		temp = x;
		x = y;
		y = temp;
	}
	
	public static void swap2(Point x, Point y) {
		Point temp = new Point();
		temp.x = x.x;
		temp.y = x.y;
		x.x = y.x;
		x.y = y.y;
		y.x = temp.x;
		y.y = temp.y;
	}
	
	public static void main(String[] args) {
		Point x = new Point();
		Point y = new Point();
		x.x = 10;
		x.y = 20;
		y.x = 30;
		y.y = 40;
		
		swap1(x, y);
		System.out.println(x.x);
		System.out.println(x.y);
		System.out.println(y.x);
		System.out.println(y.y);
		
		swap2(x, y);
		System.out.println(x.x);
		System.out.println(x.y);
		System.out.println(y.x);
		System.out.println(y.y);
		
	}
}
