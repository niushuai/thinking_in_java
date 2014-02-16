package Chapter05;

/***
 * 
 * @author niushuai
 * 
 *         1. 通过this调用的构造函数只能放在第一行，所以不能有2个。
 *         2. 除构造函数外，编译器禁止在其它任何方法中调用构造函数
 */

public class Flower {
	int petalCount = 0;
	String s = "initial value";

	Flower(int petals) {
		petalCount = petals;
		System.out.println("Constructor w/ int arg only, petalCount= "
				+ petalCount);
	}

	Flower(String ss) {
		System.out.println("Constructor w/ String arg only, s = " + ss);
	}

	Flower(String s, int petals) {
		this(petals);
		// this(s); //不能调用2个！说明(1)
		this.s = s; // this的另一种用法
		System.out.println("String & int args");
	}

	Flower() {
		this("hi", 47);
		System.out.println("default constructor (no args)");
	}

	void printPetalCount() {
		//this(11); 不是构造函数，所以禁止调用构造函数。说明(2)
		System.out.println("petalCount = " + petalCount + " s = " + s);
	}

	public static void main(String[] args) {
		Flower x = new Flower();
		x.printPetalCount();
	}
}
