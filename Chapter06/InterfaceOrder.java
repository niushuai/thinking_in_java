package Chapter06;

/***
 * 
 * @author niushuai
 * 
 *         先public、然后protected、然后包访问权限、最后private
 * 		   这样别人阅读代码的时候，就可以专注于与自己实现相关的方法、属性而不比关心不能改变的东西
 *         
 *         另外一种方法是不让代码阅读者看到源码，这时候我们可以使用javadoc功能。就像常用的API文档。
 */

public class InterfaceOrder {
	public void hello() {
	}

	public void world() {
	}

	public void haha() {
	}

	protected void xixi() {
	}

	void hi() {
	}

	void hihi() {
	}

	private String name;
	private int order;

	public static void main(String... args) {
		System.out.println("Interface order!");
	}

}
