package Chapter05;

import java.util.Arrays;
import java.util.Random;

/***
 * 
 * @author niushuai
 * 
 *         如果为基本类型数组，指定大小就已经在堆栈上完成了“自动变量”数组的创建；
 *         而对于非基本类型，仅仅创建了一个引用数组，没有创建任何对象。（因为JAVA将非基本类型的引用初始化为null）
 *         所以没有初始化就使用的话，肯定是空指针异常啦。
 */

public class ArrayClassObj {
	public static void main(String[] args) {
		Random random = new Random(47);
		Integer[] a = new Integer[random.nextInt(20)];
		System.out.println(a.length);
		for (int i = 0; i < a.length; ++i) {
			a[i] = random.nextInt(500);
		}
		System.out.println(Arrays.toString(a));
	}
}
