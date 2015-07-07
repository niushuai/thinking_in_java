package Chapter10;

/**
 * 
 * @author niushuai
 * 
 * 如果在内部类需要使用外部类引用（比如返回值为外部类的引用），那么就可以使用外部类名称.this来实现。
 * 在使用外部类.new创建内部类时，必须保证外部类已经被创建：在拥有外部类之前不可能拥有内部类。这是因为内部类对象
 * 会暗暗的连接到创建它的外部类上面。
 * 
 * 有一点特例就是静态内部类，这样的话直接调用即可。
 */

public class DotThis {
	void sayHello() {
		System.out.println("Outer.sayHello()");
	}
	class Inner {
		public DotThis sayHello() {
			System.out.println("Inner.sayHello()");
			return DotThis.this;
		}
	}
	
	public static void main(String[] args) {
		DotThis dotThis = new DotThis();
		DotThis.Inner inner = dotThis.new Inner();
		inner.sayHello().sayHello();
	}
}
