package Chapter10;

/**
 * 
 * @author niushuai
 *
 * 其实这是一个简单的迭代器模型，Sequence好比一个ArrayList，而Selector相当于Iterator的作用。
 * 它只是一个接口，可以用来迭代各种容器。而容器内部自己实现即可。而这个就是SequenceSelector的作用。
 * 
 * 通过内部类来实现迭代器接口是一个通用的标准。
 */

interface Selector {
	boolean end();
	Object current();
	void next();
}

public class Sequence {
	private Object[] items;
	private int next = 0;
	public Sequence(int size) {
		items = new Object[size];
	}
	public void add(Object x) {
		if(next < items.length) {
			items[next++] = x;
		}
	}
	
	private class SequenceSelector implements Selector {
		private int i = 0;
		public boolean end() {
			return i == items.length;
		}
		public Object current() {
			return items[i];
		}
		public void next() {
			if(i < items.length) {
				i++;
			}
		}
	}
	public Selector selector() {
		return new SequenceSelector();
	}
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for(int i = 0; i < 10; ++i) {
			sequence.add(Integer.toString(i));
		}
		Selector selector = sequence.selector();
		while(!selector.end()) {
			System.out.println(selector.current() + " ");
			selector.next();
		}
	}
}
