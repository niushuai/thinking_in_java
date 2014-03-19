package Chapter11;

import java.util.*;

public class UseHashMap {
	public static void main(String[] args) {
		HashMap<String, Integer> animal = new HashMap<String, Integer>();
		int count = 0;
		for(int i = 0; i < 100; ++i) {
			String str = i % 10 + "i";
			if(animal.containsKey(str)) {
				System.out.print("youle" + " ");
				count++;
			} else {
				animal.put(str, i);
			}
		}
		System.out.println();
		System.out.println(count);
		System.out.println(animal);
	}
}
