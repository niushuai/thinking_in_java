package Chapter10;

public class InnerClasses {
	class InnerClass1 {
		public void sayHello() {
			System.out.println("InnerClasses.InnerClass1 sayHello()");
		}
	}
	class InnerClass2 {
		public void sayHello() {
			System.out.println("InnerClasses.InnerClass2 sayHello()");
		}
	}
	
	public void fun() {
		InnerClass1 innerClass1 = new InnerClass1();
		InnerClass2 innerClass2 = new InnerClass2();
		innerClass1.sayHello();
		innerClass2.sayHello();
	}
	
	public static void main(String[] args) {
		InnerClasses innerClasses = new InnerClasses();
		innerClasses.fun();
	}
}
