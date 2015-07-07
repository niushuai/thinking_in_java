package Chapter05;

/***
 * 
 * @author niushuai
 * 可变参数列表可以用于命令行读取配置。
 */

public class ToyCode {

	public static void getToy(int n, String... str) {
		System.out.println("total is :" + n);
		for (String string : str) {
			System.out.println("name is :" + string);
		}
	}

	public static void main(String[] args) {
		getToy(3, "a", "b", "c");
		getToy(1, "d");
		getToy(0);
	}

}
