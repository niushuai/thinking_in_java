package Chapter05;

class Book {
	boolean checkOut = false;

	Book(boolean checkOut) {
		this.checkOut = checkOut;
	}

	void checkIn() {
		checkOut = false;
	}

	protected void finalize() {
		if (checkOut == true) {
			System.out.println("Error: checked out");
		}
	}
}

public class TerminationCondition {
	public static void main(String[] args) {
		Book novelBook = new Book(true);
		novelBook.checkIn();
		new Book(true);
		System.gc();
	}
}
