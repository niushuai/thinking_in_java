package Chapter05;

/***
 * 
 * @author niushuai
 * 
 *         如果定义时将某个变量赋值，那么在构造函数作用前该变量已经完成初始化，而构造函数是在分配内存后进行的。
 */

class Test2 {
	String str;

	public Test2(String str) {
		this.str = str;
		System.out.println("argument constructor is: " + str);
	}

	public Test2() {
		System.out.println("none argument constructor!");
	}
}

public class StringInit2 {
	public static void main(String[] args) {
		new Test2();
		new Test2("hello");
	}
}
