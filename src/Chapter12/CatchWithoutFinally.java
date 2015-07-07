package Chapter12;

class NSException extends Exception {

}

public class CatchWithoutFinally {

	public static boolean open(String name) throws NSException {
		if (name.equals("C++")) {
			throw new NSException();
		}
		return true;
	}

	public static void gun() {
		String[] strings = { "Java", "C++", "C", "C#" };
		for (int i = 0; i <= 3; ++i) {
			try {
				boolean flag = open(strings[i]);
				if (flag == false) {
					return;
				}
			} catch (NSException e) {
				e.printStackTrace();
			} finally {
				System.out.println("file :" + strings[i] + " close");
			}
		}
	}

	public static void main(String[] args) {
		gun();
	}
}