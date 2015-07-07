package Chapter21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockedMutex {
	//使用的是重入锁，前面可是说过哦。可以尝试获取锁(时间也可设置)
	private Lock lock = new ReentrantLock();
	public BlockedMutex() {
		lock.lock();
	}
	
	// 但是调用 lock.lockInterruptilby()就可以被中断，抛出 InterruptedException
	// 前面说过，凡是抛出 InterruptedException 的都可以从阻塞状态中断
	public void f() {
		try {
			lock.lockInterruptibly();
			System.out.println("lock acquired in f()");
		} catch(InterruptedException e) {
			System.out.println("Interrupted from lock acquisition in f()");
		}
	}
}

//首先new BlockedMutex()的时候就锁住了 blocked。而且永远不释放，那么 f()就会一直阻塞
class Blocked2 implements Runnable {
	BlockedMutex blocked = new BlockedMutex();
	public void run() {
		System.out.println("Waiting for f() in BlockedMutex()");
		blocked.f();
		System.out.println("Broken out of blocked call");
	}
}

public class Interrupting2 {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Blocked2());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Issuing t.interrupt()");
		t.interrupt();
	}
}/*output:
Waiting for f() in BlockedMutex()
Issuing t.interrupt()
Interrupted from lock acquisition in f()
Broken out of blocked call
*/
