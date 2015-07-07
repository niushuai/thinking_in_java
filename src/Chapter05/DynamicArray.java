package Chapter05;

/***
 * 
 * @author niushuai
 * 
 * 原来还可以用程序模拟命令行参数啊。传给Other函数的main就是一个绝佳的例子。
 */

public class DynamicArray {
	public static void main(String[] args) {
		Other.main(new String[]{ "fiddle", "de", "dum"});
	}
}

class Other {
	public static void main(String[] args) {
		for(String s: args) {
			System.out.print(s + " ");
		}
	}
}
