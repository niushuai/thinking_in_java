package Chapter11;

/**
 * @author niushuai
 * 
 *  原来next返回的是跨越的元素的引用。迭代器只是指向元素的首地址
 */

import java.util.*;

public class Exercise14 {
	public static void main(String[] args) {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		ListIterator<Integer> it = ints.listIterator();
		for(int i = 0; i < 10; ++i) {
			it.add(i + 1);
			if(i % 2 == 1) {
				it.previous();
			}
		}
		System.out.println(ints);
	}
}
