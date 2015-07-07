package Chapter11;

/**
 * @author niushuai
 * 
 *  虽然我们没有用到size()方法，但是我们继承的AbstractCollection必须实现size()
 *  和iterator()。所以对于非Collection类型的序列，可以使用迭代器版本
 */

import java.util.*;

public class CollectionSequence extends AbstractCollection<Integer> {
	private Integer[] ints = new Integer[]{1, 2, 3, 4, 5};
	public int size() {
		return ints.length;
	}
	//匿名内部类用法
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int index = 0;
			public boolean hasNext() {
				return index < ints.length;
			}
			public Integer next() {
				return ints[index++];
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void display(Iterator<Integer> it) {
		while(it.hasNext()) {
			Integer i = it.next();
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void display(Collection<Integer> c) {
		for(Integer i : c) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		CollectionSequence c = new CollectionSequence();
		display(c);
		display(c.iterator());
	}
}
