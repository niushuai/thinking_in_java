package Chapter05;

class InitTest {
	public static int number = 2014;
	public int i;
	public int j = 3;
	
	InitTest(int i) {
		this.i = i;
		j = 10;
	}
	
	public void print() {
		System.out.println(number);
		System.out.println(i);
		System.out.println(j);
	}
}

public class InitOrder {
	public static void main(String[] args) {
		InitTest initTest = new InitTest(20);
		initTest.print();
	}
}
