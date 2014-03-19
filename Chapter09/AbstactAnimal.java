package Chapter09;

abstract class Animal2 {
	abstract void eatWhat();
	public String what() {
		return "Animal";
	}
}

class Tiger extends Animal2 {
	void eatWhat() {
		System.out.println("eat meat");
	}
	@Override
	public String what() {
		return "Tiger";
	}
}

class Cow extends Animal2 {
	void eatWhat() {
		System.out.println("eat grass");
	}
	@Override
	public String what() {
		return "Cow";
	}
}

public class AbstactAnimal {
	public static void main(String[] args) {
		//Animal2 animal = new Animal(); 不可以创建抽象类的对象
		Animal2 animal2 = new Tiger();
		Animal2 animal3 = new Cow();
		
		animal2.eatWhat();
		animal3.eatWhat();
	}
}
