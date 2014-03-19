package Chapter11;

/**
 *  @author niushuai
 *  
 *   容器的iterator()要求容器返回一个Iterator。Iterator将准备好返回容器的第一个元素
 *   所以在最后一个for循环前要重新定位it的位置，因为第一次while迭代后it已经指向了最后
 *   一个元素了
 */

import java.util.*;

public class SimpleIteration {
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
		Iterator<Integer> it = ints.iterator();
		
		while(it.hasNext()) {
			Integer i = it.next();
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(Integer i : ints) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		it = ints.iterator();
		for(int i = 0; i < 6; i++) {
			it.next();
			it.remove();
		}
		System.out.println(ints);
	}
}
