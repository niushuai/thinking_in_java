package Chapter14;

import java.lang.reflect.*;

class MethodSelector implements InvocationHandler {
	private Object proxied;
	MethodSelector(Object proxied) {
		this.proxied = proxied;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		if(method.getName().equals("interesting")) {
			System.out.println("Proxy detected the interesting method");
		}
		return method.invoke(proxied, args);
	}
}

interface SomeMethods {
	void boring1();
	void boring2();
	void interesting(String arg);
	void boring3();
}

class Implementation implements SomeMethods {
	public void boring1() {
		System.out.println("boring1");
	}
	public void boring2() {
		System.out.println("boring2");
	}
	public void interesting(String arg) {
		System.out.println("interesting " + arg);
	}
	public void boring3() {
		System.out.println("boring3");
	}
}

public class SelectingMethods {
	public static void main(String[] args) {
		SomeMethods proxy = (SomeMethods)Proxy.newProxyInstance(
					SomeMethods.class.getClassLoader(),
					new Class[] { SomeMethods.class },
					new MethodSelector(new Implementation())
				);
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("bonobo");
		proxy.boring3();
	}
}
