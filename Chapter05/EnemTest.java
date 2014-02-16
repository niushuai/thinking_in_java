package Chapter05;

enum Status {
	WIN, LOSE, PING
}

public class EnemTest {
	public static void main(String[] args) {
		Status status = Status.LOSE;
		switch(status) {
			case WIN:
				System.out.println("WIN");
				break;
			case LOSE:
				System.out.println("LOSE");
				break;
			case PING:
				System.out.println("PING");
				break;
			default:
				System.out.println("I don't know the result");
		}
	}
}
