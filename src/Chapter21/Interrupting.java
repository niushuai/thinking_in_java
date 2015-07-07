package Chapter21;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// Sleep()阻塞
class SleepBlocked implements Runnable {
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch(InterruptedException e) {
			System.out.println("InterruptedException!");
		}
		System.out.println("Exiting SleepBlocked.run()\n");
	}
}

// IO阻塞
class IOBlocked implements Runnable {
	private InputStream in;
	public IOBlocked(InputStream in) {
		this.in = in;
	}
	@Override
	public void run() {
		try {
			System.out.println("Waiting for read():");
			in.read();
		} catch(IOException e) {
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("Interrupted from blocked I/O");
			} else {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Exiting IOBlocked.run()\n");
	}
}

// 同步锁阻塞
class SynchronizedBlocked implements Runnable {
	public synchronized void f() {
		while(true) {
			Thread.yield();
		}
	}
	
	//启动的时候，new 一个线程去抢占锁。
	public SynchronizedBlocked() {
		new Thread() {
			public void run() {
				f();
			}
		}.start();
	}
	@Override
	public void run() {
		System.out.println("Trying to call f()");
		f();
		System.out.println("Exiting SynchronizedBlocked.run()\n");
	}
}

public class Interrupting {
	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	//送出中断
	static void test(Runnable r) throws InterruptedException {
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Interrupting " + r.getClass().getName());
		f.cancel(true);
		System.out.println("Interrupt sent to " + r.getClass().getName());
	}
	
	//分别对三中阻塞送出一记漂亮的中断
	public static void main(String[] args) throws InterruptedException {
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Abortin with System.exit(0)");
		System.exit(0);
	}
}
