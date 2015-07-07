package Chapter11;

import java.util.*;

class IntSequence {
	protected Integer[] ints = new Integer[]{1, 2, 3, 4, 5};
}

public class NonCollectionSequence extends IntSequence {
	
	private class MyIterator implements Iterator<Integer> {

		private int index = 0;
		@Override
		public boolean hasNext() {
			return index < ints.length;
		}

		@Override
		public Integer next() {
			return ints[index++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int index = 0;
			public boolean hasNext() {
				return index < ints.length;
			}
			public Integer next() {
				return ints[index++];
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void display(Iterator<Integer> it) {
		while(it.hasNext()) {
			Integer i = it.next();
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		NonCollectionSequence nc = new NonCollectionSequence();
		display(nc.iterator());
	}
}
