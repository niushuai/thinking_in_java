package Chapter09;

/**
 * 
 * @author niushuai
 *
 * 还是在告诉我们，不要在基类的构造函数干太多的事情。要保持简单，最多调用final方法
 */

abstract class Oh {
	Oh() {
		print();
	}
	abstract void print();
}

class No extends Oh {
	private int num = 10;
	void print() {
		System.out.println(num);
	}
}

public class TestAbstract {
	public static void main(String[] args) {
		No no = new No();
		no.print();
	}
}
