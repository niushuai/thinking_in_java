package Chapter14;

interface Interface {
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface {
	public void doSomething() {
		System.out.println("doSomething");
	}
	public void somethingElse(String arg) {
		System.out.println("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proxy;
	public SimpleProxy(Interface realInterface) {
		proxy = realInterface;
	}
	public void doSomething() {
		System.out.println("SimpleProxy doSomething");
		proxy.doSomething();
	}
	public void somethingElse(String arg) {
		System.out.println("SimpleProxy somethingElse");
		proxy.somethingElse(arg);
	}
}

public class SimpleProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}
