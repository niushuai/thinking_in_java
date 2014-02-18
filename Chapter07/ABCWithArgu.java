package Chapter07;

class AA {
	public AA(int i) {
		System.out.println("AA() and i is: " + i);
	}
}

class BB extends AA{
	public BB(int i) {
		super(i);
		i = i + 1;
		System.out.println("BB() and i is: " + i);
	}
}

public class ABCWithArgu {
	public static void main(String[] args) {
		BB bb = new BB(16);
	}
}
