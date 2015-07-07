package Chapter05;

public class Dog {
	public void bark() {
		System.out.println("wang wang");
	}
	
	public void bark(String str) {
		System.out.println(str);
	}
	
	public void bark(String str, int count) {
		for(int i = 0; i < count; ++i) {
			System.out.println(str);
		}
	}
	
	public void bark(int count, String str) {
		for(int i = 0; i < count; ++i) {
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.bark();
		dog.bark("wu");
		dog.bark("hu", 3);
		dog.bark(3, "huhu");
	}
}
