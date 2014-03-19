package Chapter11;

import java.util.*;

class Huhu {
}

class HelloWorld implements Iterable<Huhu> {
	private Huhu[] huhus = {
			new Huhu(),
			new Huhu(),
			new Huhu(),
			new Huhu()
	};
	
	public Iterator<Huhu> iterator() {
		return new Iterator<Huhu>() {
			private int index = 0;

			public boolean hasNext() {
				return index < huhus.length;
			}

			public Huhu next() {
				return huhus[index++];
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}

public class TestForeach {
	public static void main(String[] args) {
		for(Huhu s : new HelloWorld()) {
			System.out.print("hi ");
		}
	}
}
