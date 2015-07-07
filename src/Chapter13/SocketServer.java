package Chapter13;

import java.io.*;
import java.net.*;
import java.util.Random;

public class SocketServer {

	private final String advices[] = { "天天吃钙，我有健康的膝盖", "程序写的好，要饭要到老",
			"饭前勤洗手，便后常漱口" };
	private Random random = new Random(10);

	public String advice() {
		return advices[random.nextInt(3)];
	}

	public void work() {
		try {
			System.out.println("Server startup!");
			ServerSocket server = new ServerSocket(5000);

			while (true) {
				Socket s = server.accept();
				PrintWriter pw = new PrintWriter(s.getOutputStream());
				String str = advice();
				pw.write(str);
				pw.close();
				System.out.println("send :" + str);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		SocketServer server = new SocketServer();
		server.work();
	}
}
