package Chapter08;

/**
 * 
 * @author niushuai
 * 
 * 因为静态方法是在编译期确定的，而且是类的属性。所以不是动态绑定，不能用于多态。要使用的话，必须显式指定
 */

class StaticSuper {
	public static void staticGet() {
		System.out.println("Base staticGet()");
	}
	public void dynamicGet() {
		System.out.println("Base dynamicGet()");
	}
}

class StaticSub extends StaticSuper {
	public static void staticGet() {
		System.out.println("Derived staticGet()");
	}
	public void dynamicGet() {
		System.out.println("Derived dynamicGet()");
	}
}

public class StaticPolymorphism {
	public static void main(String[] args) {
		StaticSuper staticSuper = new StaticSub();
		staticSuper.staticGet();
		staticSuper.dynamicGet();
	}
}
