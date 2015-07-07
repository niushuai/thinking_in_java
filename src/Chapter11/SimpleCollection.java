package Chapter11;

import java.util.Collection;
import java.util.ArrayList;

public class SimpleCollection {
	public static void main(String[] args) {
		Collection<Integer> integers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			integers.add(i);
		}
		for (Integer integer : integers) {
			System.out.print(integer + " ");
		}
	}
}
