package Chapter08;

/**
 * 
 * @author niushuai
 * 
 *         理想输出是public fun()，但是结果是Private
 *         fun()。因为private的fun对于Derived是不可见的，所以它实现的fun不是覆盖，而是一个全新的方法。
 *         那么，显然对于基类中没有被子类覆盖的方法，调用的时候肯定还是基类的。所以最终结果是Private fun()
 */

public class PrivateOverride {
	private void fun() {
		System.out.println("Private fun()");
	}

	public static void main(String[] args) {
		PrivateOverride privateOverride = new Derived();
		privateOverride.fun();
	}
}

class Derived extends PrivateOverride {
	public void fun() {
		System.out.println("Public fun()");
	}
}
