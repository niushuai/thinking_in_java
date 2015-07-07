package Chapter11;

import java.util.*;

public class Exercise05 {
	static Random random = new Random(47);

	public static void main(String[] args) {

		List<Integer> ints = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		System.out.println("1:" + ints);

		Integer integer = new Integer(10);
		// 自动扩充容量至8
		ints.add(integer);
		System.out.println("2:" + ints);
		System.out.println("3:" + ints.contains(integer));

		ints.remove(integer);
		Integer integer2 = ints.get(2);
		System.out.println("4:" + integer2 + " " + ints.indexOf(integer2));
		
		Integer integer3 = new Integer(20);
		System.out.println("5:" + ints.indexOf(integer3));
		System.out.println("6:" + ints.remove(integer3));
		
		System.out.println("7:" + ints.remove(integer2));
		System.out.println("8:" + ints);
		
		ints.add(3, new Integer(16));
		System.out.println("9:" + ints);
		
		List<Integer> sub = ints.subList(1, 4);
		System.out.println("subList: " + sub);
		System.out.println("10:" + ints.containsAll(sub));
		
		Collections.sort(sub);
		System.out.println("Sorted subList: " + sub);
		
		//跟顺序无关，只要元素全部包括就行
		System.out.println("11:" + ints.containsAll(sub));
		
		Collections.shuffle(sub, random);
		System.out.println("Shuffled subList: " + sub);
		System.out.println("12" + ints.containsAll(sub));
		
		List<Integer> copy = new ArrayList<Integer>(ints);
		System.out.println("copy: " + copy);
		sub = Arrays.asList(ints.get(1), ints.get(4));
		System.out.println("sub: " + sub);
		//retainAll就是把sub中不含有的元素从copy中全部删除
		copy.retainAll(sub);
		System.out.println("13:" + copy);
		
		copy = new ArrayList<Integer>(ints);
		copy.remove(2);
		System.out.println("14:" + copy);
		//removeAll就是把sub中含有的元素从copy中全部删除。和retainAll的作用正好相反
		copy.removeAll(sub);
		System.out.println("15:" + copy);
		
		copy.set(1, new Integer(22));
		System.out.println("16:" + copy);
		
		//从中间插入一个List。这个操作对于ArrayList来说效率很低
		copy.addAll(2, sub);
		System.out.println("17:" + copy);
		
		System.out.println("18:" + ints.isEmpty());
		ints.clear();
		System.out.println("19:" + ints);
		System.out.println("20:" + ints.isEmpty());
		
		ints.addAll(Arrays.asList(33, 44, 55, 66));
		System.out.println("21:" + ints);

		//默认转换为Object数组
		Object[] o = ints.toArray();
		System.out.println("22:" + o[3]);
		
		//转换为指定大小的数据，但如果ints为4个元素，你指定的数组<4，那么toArray会
		//创建一个具有合适尺寸（4）的数组
		Integer[] in = ints.toArray(new Integer[5]);
		System.out.println("23:" + in[3]);
		
	}
}
