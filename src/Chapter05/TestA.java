package Chapter05;

/***
 * 
 * @author niushuai
 * 
 * 局部变量没有初始化就使用的话，编译时候会报错。而C++则是运行的时候都正常。排查问题难度显而易见。
 */

public class TestA {
	public static void f() {
		int i;
		//i++;
		//System.out.println(i);
	}
	
	public static void main(String[] args) {
		f();
	}
}
