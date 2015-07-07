package Chapter11;

import java.util.HashSet;
import java.util.Collection;

public class Exercise02 {
	public static void main(String[] args) {
		Collection<Integer> integers = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			integers.add(i);
		}
		for (Integer integer : integers) {
			System.out.print(integer + " ");
		}
	}
}
