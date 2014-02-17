package Chapter06;

/***
 * 
 * @author niushuai
 * 
 *         将hi修饰为private static
 *         final之后，说明全局只有一个hi对象，而且不可修改。而且不能通过构造函数创建，只能通过getInstance()取得
 */

class Hi {
	private static final Hi hi = new Hi();

	private Hi() {
	}

	public static final Hi getInstance() {
		return hi;
	}

	public void sayHello() {
		System.out.println("hi");
	}
}

public class MyPrivate {
	public static void main(String[] args) {
		// Hi hi = new Hi();
		Hi hi = Hi.getInstance();
		hi.sayHello();
	}
}
