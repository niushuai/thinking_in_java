package Chapter21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ThreadLocalTask implements Runnable {
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			ThreadLocalTest.increment();
			System.out.println(this);
		}
	}

	public String toString() {
		return "thread is: " + Thread.currentThread() + ", value is: " + ThreadLocalTest.get();
	}
}

public class ThreadLocalTest {
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		private Random random = new Random(47);

		protected synchronized Integer initialValue() {
			return random.nextInt(10000);
		}
	};

	public static void increment() {
		value.set(value.get() + 1);
	}

	public static int get() {
		return value.get();
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; i++) {
			exec.execute(new ThreadLocalTask());
		}
		TimeUnit.SECONDS.sleep(3);
		exec.shutdownNow();
	}
}
