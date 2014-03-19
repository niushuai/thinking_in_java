package Chapter11;

import java.util.*;

public class ReverseIterator {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		ArrayList<Integer> ints2 = new ArrayList<Integer>();
		
		ListIterator it = ints.listIterator(ints.size());
		while(it.hasPrevious()) {
			Integer i = (Integer) it.previous();
			System.out.print(i + " ");
			ints2.add(i);
		}
		System.out.println();
		
		System.out.println(ints);
		System.out.println(ints2);
		
	}
}
