package Chapter11;

import java.util.*;

public class PriorityQueueDemo {
	public static void printQueue(Queue queue) {
		while(queue.peek() != null) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random random = new Random(47);
		for(int i = 0; i < 10; ++i) {
			priorityQueue.offer(random.nextInt(i + 10));
		}
		printQueue(priorityQueue);
		
		List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
		priorityQueue = new PriorityQueue<Integer>(ints);
		printQueue(priorityQueue);
		
		priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
		priorityQueue.addAll(ints);
		printQueue(priorityQueue);
		
		//教育可以远离困惑。。。。。。英语烂成渣！
		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		
		List<String> strings = Arrays.asList(fact.split(" "));
		PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
		printQueue(stringPQ);
		
		//按照指定容量添加元素，优先级按照Comparator实现的顺序。如果继续add，还会按照
		//指定的Comparator顺序添加元素
		stringPQ = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
		stringPQ.addAll(strings);
		printQueue(stringPQ);
		stringPQ.addAll(strings);
		stringPQ.add("NIUSHUAI");
		printQueue(stringPQ);
		
		Set<Character> charSet = new HashSet<Character>();
		for(char c : fact.toCharArray()) {
			charSet.add(c);
		}
		PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(charSet);
		printQueue(characterPQ);
		
	}
}
