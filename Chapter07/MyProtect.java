package Chapter07;

/***
 * 
 * @author niushuai
 * 
 *         对于Ding中的hello()，因为是protected修饰的。所以只能是包内和子类能使用；包外是无法使用的
 */

class Ding {
	protected void hello() {
		System.out.println("hello world");
	}

	public void hi() {
		System.out.println("hi");
	}
}

class Xiao {
	Ding ding = new Ding();

	public void hihi() {
		ding.hello();
	}
}

public class MyProtect extends Ding {
	public static void main(String[] args) {
		Ding ding = new Ding();
		ding.hello();
		ding.hi();
	}
}
