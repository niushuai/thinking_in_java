package Chapter13;

import java.io.*;
import java.net.*;

public class SocketClient {
	public void talk() {
		try {
			Socket s = new Socket("127.0.0.1", 5000);
			InputStreamReader input = new InputStreamReader(s.getInputStream());
			BufferedReader buffer = new BufferedReader(input);
			String advice = buffer.readLine();
			System.out.println(advice);
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SocketClient client = new SocketClient();
		client.talk();
	}
}
