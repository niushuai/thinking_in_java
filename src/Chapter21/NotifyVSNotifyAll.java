package Chapter21;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Blocker {
	synchronized void waitingCall() {
		try {
			while(!Thread.interrupted()) {
				wait();
				System.out.print(Thread.currentThread() + " ");
			}
		} catch(InterruptedException e) {
			
		}
	}
	
	synchronized void prod() {
		notify();
	}
	
	synchronized void prodAll() {
		notifyAll();
	}
}

class Task implements Runnable {
	static Blocker blocker = new Blocker();
	public void run() {
		blocker.waitingCall();
	}
}

class Task2 implements Runnable {
	static Blocker blocker = new Blocker();
	public void run() {
		blocker.waitingCall();
	}
}

public class NotifyVSNotifyAll {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			exec.execute(new Task());
		}
		exec.execute(new Task2());
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			boolean prod = true;
			public void run() {
				if(prod) {
					System.out.println("\nnotify() ");
					Task.blocker.prod();
				} else {
					System.out.print("\nnotifyAll() ");
					Task.blocker.prodAll();
					prod = true;
				}
			}
		}, 400, 400);
		TimeUnit.SECONDS.sleep(5);
		timer.cancel();
		System.out.println("\nTimer canceled");
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.print("Task2.blcoker.prodAll() ");
		Task2.blocker.prodAll();
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.println("\nShutting down");
		exec.shutdownNow();
	}
}
