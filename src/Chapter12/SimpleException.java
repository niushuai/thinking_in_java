package Chapter12;

class HohoHo extends Exception {
	
}

public class SimpleException {
	public void fun() throws HohoHo {
		System.out.println("SimpleException throws fun()");
		throw new HohoHo();
	}
	
	public static void main(String[] args) {
		try {
			SimpleException simple = new SimpleException();
			simple.fun();
		} catch(NullPointerException h) {
			System.out.println("NullPointer catch it!");
		} catch(HohoHo e) {
			System.out.println("HohoHo catch it!");
		} catch(Exception e) {
			System.out.println("Exception catch it!");
		}
	}
	
}

