package Chapter11;

/**
 * @author niushuai
 * 
 *  这个例子展示了ListIterator的用法。它可以向前向后遍历，而且可以把刚才访问过的变量给重新赋值
 *  同时也可以初始化遍历开始的位置
 */

import java.util.*;

public class ListIteration {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		ListIterator it = ints.listIterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		while(it.hasPrevious()) {
			System.out.print(it.previous() + " ");
		}
		System.out.println();
		
		it = ints.listIterator(5);
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
			it.set(new Integer(15));
		}
		System.out.println();
		System.out.println(ints);
	}
}
