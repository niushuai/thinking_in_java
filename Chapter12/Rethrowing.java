package Chapter12;

/**
 * 
 * @author niushuai
 *
 * 仔细看就会发现，第二种情况下main函数捕获的异常抛出的地方是fillInStackTrace()抛出的地方，而不是f()
 * 抛出异常的地方
 */

public class Rethrowing {
	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("Throw from f()");
	}
	
	public static void g() throws Exception {
		try {
			f();
		} catch(Exception e) {
			System.out.println("Inside g(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void h() throws Exception {
		try {
			f();
		} catch(Exception e) {
			System.out.println("Inside h(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			g();
		} catch(Exception e) {
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
		try {
			h();
		} catch(Exception e) {
			System.out.println("main: pintStackTrace()");
			e.printStackTrace(System.out);
		}
	}
}
