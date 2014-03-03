package Chapter08;

/**
 * @author niushuai
 *  
 *  动态绑定的例子，和C的静态绑定不同。在编译的时候，shuffle返回的对象不能确定。只能在运行的时候才能确定
 */

import java.util.Random;

class A {}
class B extends A {}
class C extends A {}
class D extends A {}

class RandomNow {
	private Random random = new Random(100000);
	public A shuffle() {
		switch(random.nextInt(10)) {
		case 0:
		case 1:
		case 2:
		case 3:
			return new B();
		case 4:
		case 5:
		case 6:
			return new C();
		case 7:
		case 8:
		case 9:
			return new D();
		default:
			return null;
		}
	}
}

public class RandomMe {
	public static void main(String[] args) {
		RandomNow randomNow = new RandomNow();
		A[] a = new A[10];
		for(int i = 0; i < a.length; ++i) {
			a[i] = randomNow.shuffle();
		}
		for(int i = 0; i < a.length; ++i) {
			System.out.println(i + " " + a[i].getClass());
		}
	}
}
