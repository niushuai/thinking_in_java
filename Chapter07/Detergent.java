package Chapter07;

/***
 * 
 * @author niushuai
 * 
 *         在使用继承时，一般的规则是将父类的数据成员设置为private，将所有的方法设置为public。这样当其它包中的类继承时，
 *         就可以完整的获得类的方法
 */

class Cleanser {
	private String s = "cleanser";

	public void append(String a) {
		s += a;
	}

	public void a() {
		System.out.println("cleanser a()");
	}

	public void b() {
		System.out.println("cleanser b()");
	}

	public void c() {
		System.out.println("cleanser c()");
	}

	@Override
	public String toString() {
		return s;
	}

	public static void main(String[] args) {
		Cleanser cleanser = new Cleanser();
		cleanser.a();
		cleanser.b();
		cleanser.c();
	}
}

public class Detergent extends Cleanser {
	public void a() {
		System.out.println("Detergent a()");
		super.a();
	}

	public static void main(String[] args) {
		Detergent detergent = new Detergent();
		detergent.a();
		detergent.b();
		detergent.c();
		System.out.println("father");
		Cleanser.main(args);
	}
}
