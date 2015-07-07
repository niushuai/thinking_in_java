package Chapter21;

import java.util.concurrent.TimeUnit;

class NeedsCleanup {
	private final int id;

	public NeedsCleanup(int ident) {
		id = ident;
		System.out.println("NeedsCleanup " + id);
	}

	public void cleanup() {
		System.out.println("Cleaning up " + id);
	}
}

// 模拟一个计算密集型的任务
class Blocked3 implements Runnable {
	private volatile double d = 0.0;

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Point1 在需要清理的资源后，需要立即跟上 try-catch-finally
				NeedsCleanup n1 = new NeedsCleanup(1);
				try {
					System.out.println("Sleeping");
					TimeUnit.SECONDS.sleep(1);

					// Point2 同上
					NeedsCleanup n2 = new NeedsCleanup(2);
					try {
						System.out.println("Calculating");
						for (int i = 1; i < 2500000; i++) {
							d = d + (Math.PI + Math.E) / d;
						}
						System.out.println("Finished time-consuming operation");
					} finally {
						n2.cleanup();
					}
				} finally {
					n1.cleanup();
				}
			}
			System.out.println("Exiting via while() test");
		} catch (InterruptedException e) {
			System.out.println("Exiting via InterruptedException");
		}
	}
}

// 通过传入不同的时间，来让 interrupt 发生在 Point1和 Point2的前后
// 当在 P1和 P2之间传入中断，会在 while 循环结束后达到 while 条件退出
// 当在 P1前面调用，会在视图调用阻塞(sleep()操作)或者在阻塞中(正在 sleep())通过 InterruptedException 退出阻塞
// 那么，紧接着 n1和n2的 try-catch-finally 就会正确的清理资源
public class IntererptingIdiom {
	public static void main(String[] args) throws NumberFormatException,
			InterruptedException {
		if (args.length != 1) {
			System.out.println("Usage: java InterruptingIdiom delay-in-mS");
			System.exit(1);
		}
		Thread t = new Thread(new Blocked3());
		t.start();
		TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
		t.interrupt();
	}
}
