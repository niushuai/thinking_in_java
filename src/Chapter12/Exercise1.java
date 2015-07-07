package Chapter12;

public class Exercise1 {
	
	public void fun(String str) throws NullPointerException {
		if(str == null) {
			throw new NullPointerException("str can't be null !!!");
		}
	}
	public static void main(String[] args) {
		try {
			Exercise1 exercise1 = new Exercise1();
			exercise1.fun(null);
		} catch(Exception e) {
			System.out.println("Exception coming!");
			e.printStackTrace();
		} finally {
			System.out.println("wangzheguilai!");
		}
	}
}
