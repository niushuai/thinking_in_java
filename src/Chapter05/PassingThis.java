package Chapter05;

class Peeler {
	static Apple peel(Apple apple) {
		/*
		 * peel the apple
		 */
		return apple;
	}
}

class Apple {
	Apple getPeeled() {
		return Peeler.peel(this); // 谁调用，就给谁削皮。所以用this传递参数。而且peel是static的
	}
}

class Person {
	public void eat(Apple apple) {
		Apple peeled = apple.getPeeled();
		System.out.println("Yummy");
	}
}

public class PassingThis {
	public static void mian(String[] args) {
		new Person().eat(new Apple());
	}
}
