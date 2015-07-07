package Chapter06;

class Connection {
	private Connection() {
	}

	public static Connection access() {
		return new Connection();
	}
}

public class ConnectionManager {

	private static Connection[] connections = new Connection[10];
	private static int count = 10;

	private ConnectionManager() {
		for (int i = 0; i < 10; i++) {
			connections[i] = Connection.access();
		}
	}

	public static Connection getConnection() {
		if (count > 0) {
			count--;
			System.out.println("OK");
			return connections[9 - count];
		} else {
			System.out.println("Empty!");
			return null;
		}
	}
	
	public static void main(String... args) {
		for(int i = 0; i < 12; i++) {
			ConnectionManager.getConnection();
		}
	}
}
