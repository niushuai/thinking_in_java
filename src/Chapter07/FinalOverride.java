package Chapter07;

/**
 * 
 * @author niushuai
 * 
 *         不能使用@Override注解是因为FinalOverride根本“看不到”FinalData的fun()方法，所以@Override找不到它需要覆盖的基类的fun
 *         ()，就报错了
 */

class FinalData {
	private void fun() {
		System.out.println("FinalData");
	}
}

public class FinalOverride extends FinalData {
	// @Override
	private void fun() {
		System.out.println("FinalOverride");
	}

	public static void main(String[] args) {
		FinalOverride finalOverride = new FinalOverride();
		finalOverride.fun();
	}
}
