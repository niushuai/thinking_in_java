package Chapter11;

import java.util.*;

public class Exercise11 {
	public static void print(Iterator<Integer> it) {
		while(it.hasNext()) {
			Integer i = it.next();
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
		LinkedList<Integer> ints2 = new LinkedList<Integer>(ints);
		HashSet<Integer> ints3 = new HashSet<Integer>(ints);
		TreeSet<Integer> ints4 = new TreeSet<Integer>(ints);
		
		print(ints.iterator());
		print(ints2.iterator());
		print(ints3.iterator());
		print(ints4.iterator());
	}
}
