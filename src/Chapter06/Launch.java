package Chapter06;

/***
 * 
 * @author niushuai
 * 
 * Soup1调用makeSoup就产生一个新对象；
 * Soup2是经典的单例模式，但一般实现单例模式的时候都会指定final关键字，防止修改，只能调用。
 */

class Soup1 {
	private Soup1() {
	}

	public static Soup1 makeSoup() {
		return new Soup1();
	}
}

class Soup2 {
	private Soup2() {
	}

	private static Soup2 ps1 = new Soup2();

	public static Soup2 access() {
		return ps1;
	}

	public void f() {
	}
}

public class Launch {
	void testPrivate() {
		//can't do this!
		//Soup1 soup1 = new Soup1();
	}
	
	void testStatic() {
		Soup1 soup1 = Soup1.makeSoup();
	}
	
	void testSingleton() {
		Soup2.access().f();
	}
}
