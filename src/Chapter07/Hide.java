package Chapter07;

/***
 * 
 * @author niushuai
 * 
 *         子类的f不会隐藏父类的f。这点和C++不同，具体可参见《C/C++高质量编程指南》中的那一节
 */

class Homer {
	public int f(int i) {
		System.out.println("f(int)");
		return 1;
	}

	public char f(char ch) {
		System.out.println("f(char)");
		return 'c';
	}
}

class MyHomer {

}

class Now extends Homer {
	public void f(MyHomer myHomer) {
		System.out.println("f(MyHomer)");
	}
}

public class Hide {
	public static void main(String[] args) {
		Now now = new Now();
		now.f(3);
		now.f('a');
		now.f(new MyHomer());
	}
}
