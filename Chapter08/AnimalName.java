package Chapter08;

class Animal {
	public void name() {
		
	}
}

class Dog extends Animal {
	@Override
	public void name() {
		System.out.println("My name is Dog");
	}
}

class Cat extends Animal {
	@Override
	public void name() {
		System.out.println("My name is Cat");
	}
}

public class AnimalName {
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.name();
		Animal animal2 = new Cat();
		animal2.name();
	}
}


