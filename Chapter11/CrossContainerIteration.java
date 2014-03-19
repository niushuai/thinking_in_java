package Chapter11;

import java.util.*;

public class CrossContainerIteration {
	public static void display(Iterator<Integer> it) {
		while(it.hasNext()) {
			Integer integer = it.next();
			System.out.print(integer + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		LinkedList<Integer> ints2 = new LinkedList<Integer>(ints);
		HashSet<Integer> ints3 = new HashSet(ints);
		TreeSet<Integer> ints4 = new TreeSet(ints);
		
		display(ints.iterator());
		display(ints2.iterator());
		display(ints3.iterator());
		display(ints4.iterator());
	}
}
