package Chapter11;

import java.util.*;

public class AddingGroups {
	public static void main(String[] args) {
		Collection<Integer> integers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Integer[] moreInts = {6, 7, 8, 9, 10};
		
		Collections.addAll(integers, 11, 12, 13, 14, 15);
		Collections.addAll(integers, moreInts);
		System.out.println(integers);
		
		List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
		list.set(1, 99);
		System.out.println(list);
	}
}
