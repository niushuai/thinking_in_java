package Chapter08;

/**
 * 
 * @author niushuai
 * 
 *         运行程序会在第36号报错：ClassCastException。因为x[1]的类型是MoreUseful，向上转型后再向下转型是没有错误的
 *         ；但是X[0]是Useful类型， 向下转型为MoreUseful肯定是错误的。所以会运行报错
 */

class Useful {
	public void f() {

	}

	public void g() {

	}
}

class MoreUseful extends Useful {
	public void f() {
	}

	public void g() {
	}

	public void u() {
	}

	public void v() {
	}

	public void w() {
	}
}

public class RTTI {
	public static void main(String[] args) {
		Useful[] x = { new Useful(), new MoreUseful() };
		x[0].f();
		x[1].g();
		((MoreUseful) x[1]).u(); // downcast/RTTI
		//((MoreUseful) x[0]).u(); // throw Exception
	}
}
