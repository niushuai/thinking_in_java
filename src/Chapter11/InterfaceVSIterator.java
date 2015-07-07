package Chapter11;

import java.util.*;

public class InterfaceVSIterator {
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
		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
		Set<Integer> intSet = new HashSet<Integer>(intList);
		Map<String, Integer> intMap = new LinkedHashMap<String, Integer>();
		String[] names = {"first", "second", "third", "fourth"};
		for(int i = 0; i < names.length; i++) {
			intMap.put(names[i], intList.get(i));
		}
		
		display(intList);
		display(intSet);
		
		display(intList.iterator());
		display(intSet.iterator());
		
		System.out.println(intMap);
		System.out.println(intMap.keySet());
		System.out.println(intMap.values());
		
		display(intMap.values());
		display(intMap.values().iterator());
	}
}
