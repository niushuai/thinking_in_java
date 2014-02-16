package Chapter05;

import java.util.Arrays;

/***
 * 
 * @author niushuai
 * 
 * 两种不同的初始化方法，注意里面最后哪个,是可选的（这一特性使维护长列表变得更容易了）
 */

public class ArrayInit {
	public static void main(String[] args) {
		Integer[] a = {
				new Integer(1),
				new Integer(2),
				3,
		};
		
		Integer[] b = new Integer[]{
				new Integer(1),
				new Integer(2),
				3,
		};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}
