package Chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//所有入口的总人数
class Count {
	//count 会并发访问，所以 get/set 需要 synchronized 锁起来
	private int count = 0;
	private Random rand = new Random(47);

	//如果去掉 synchronized 那么其中的 temp 和 Thread.yield()会
	//大大增加 increment 失败的几率（也就是并发修改）
	public synchronized int increment() {
		int temp = count;
		if (rand.nextBoolean()) {
			Thread.yield();
		}
		return (count = ++temp);
	}

	public synchronized int value() {
		return count;
	}
}

//每个入口通过 number 各自统计通过当前门的人数
class Entrance implements Runnable {

	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<Entrance>();
	private int number = 0;
	private final int id;
	private static volatile boolean canceled = false;

	public static void cancel() {
		canceled = true;
	}

	public Entrance(int id) {
		this.id = id;
		entrances.add(this);
	}

	// run()的任务就是递增入口人数和总人数，验证 count 的总数是正确的。然后休眠100ms
	@Override
	public void run() {
		while (!canceled) {
			synchronized (this) {
				++number;
			}
			System.out.println(this + " Total: " + count.increment());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");
			}
		}
		System.out.println("stopping " + this);
	}

	public synchronized int getValue() {
		return number;
	}

	public String toString() {
		return "Entrace " + id + ": " + getValue();
	}

	public static int getTotalCount() {
		return count.value();
	}

	public static int sumEntrances() {
		int sum = 0;
		for (Entrance entrance : entrances) {
			sum += entrance.getValue();
		}
		return sum;
	}
}

// 5个门，运行3s 后通过 exec.shutdown()发送 interrupt()中断
public class OrnametalGarden {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new Entrance(i));
		}
		TimeUnit.SECONDS.sleep(5);
		Entrance.cancel();
		exec.shutdown();
		//等待超时时间250ms 后返回 boolean 是否任务终结
		if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
			System.out.println("some tasks were not terminated");
		}
		System.out.println("Total: " + Entrance.getTotalCount());
		System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
	}
}
