package Chapter05;

/***
 * 
 * @author niushuai
 * 
 *         第一个构造函数的第一行被注释了，如果没有注释，就会提示错误：Constructor call must be the first
 *         statement in a
 *         constructor。所以，通过this调用构造函数时，必须注意：调用在构造函数的第一行，调用this构造函数的函数也必须是构造函数
 */

class Niu {
	Niu(String str) {
		// System.out.println("hehe");
		this(str, 3);
	}

	Niu(String str, int number) {
		for (int i = 0; i < number; ++i) {
			System.out.println(str);
		}
	}
}

public class ConstructorThis {
	public static void main(String[] args) {
		new Niu("hehe");
	}
}
