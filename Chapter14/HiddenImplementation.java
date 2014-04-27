package Chapter14;

/**
 * @author niushuai
 * 我们发现对于反射来说，没有进不去的方法。不管你是public package protected private 匿名，
 * 我全部都能调用你。即使你只发布了编译后的代码，这是很不幸，使用javap -private C，反编译器
 * 会突破这个限制的。。。它会显示你所有的函数。
 * 
 * 因此任何人都可以获得你最私有的方法的名字和签名，然后调用它们。
 */

import java.lang.reflect.Method;

import Chapter14.packageaccess.HiddenC;

public class HiddenImplementation {
	public static void main(String[] args) throws Exception {
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		
		//Compile Error: cannot find symbol 'C'
		/* if(a instanceof C) {
		 * C c = (C)a;
		 * c.g();
		 */
		
		//Oops!Reflection still allow us to call g();
		callHiddenMethod(a, "g");
		callHiddenMethod(a, "u");
		callHiddenMethod(a, "v");
		callHiddenMethod(a, "w");
	}
	
	static void callHiddenMethod(Object a, String methodName) throws Exception {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
}
