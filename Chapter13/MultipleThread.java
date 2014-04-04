package Chapter13;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class MultipleThread {

	private static ExecutorService executorService = Executors
			.newFixedThreadPool(3);
	private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

	public static void main(String[] args) {
		for(int i = 0; i < 10000; ++i) {
			queue.add("No." + i);
		}
		executorService.execute(new Runnable() {
			public void run() {
				for(int i = 0; i < 100000; i++) {
					try {
						String str = queue.take();
						if(i == 10)
							Thread.sleep(1000);
						System.out.println(str);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}
