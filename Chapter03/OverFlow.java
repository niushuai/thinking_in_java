package Chapter03;

/***
 * 
 * @author niushuai
 * 
 * 溢出问题不会在编译时得到任何出错或者警告，也不会在运行出现异常。所以JAVA虽然是好东西，也并不是完美的。
 */

public class OverFlow {
	public static void main(String[] args) {
		int big = Integer.MAX_VALUE;
		System.out.println("big = " + big);
		int bigger = big * 4;
		System.out.println("bigger = " + bigger);
	}
}
