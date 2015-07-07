package Chapter21;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Player implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private Random rand = new Random(47);

    public Player(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            // 运输2个球
            TimeUnit.SECONDS.sleep(rand.nextInt(5));

            // 等待其他队友完成
            System.out.println(Thread.currentThread() + " 完成任务！等待队友 ing...");
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            System.out.println("BrokenBarrierException " + e);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e);
        }
    }
}

public class CyclicBarrierGame {
    public static void main(String[] args) {
        // 定义 CyclicBarrier
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                // 全部完成
                System.out.println("\n全部完成！ 举手报告 ing...\n");
                System.out.println("谁来执行 Barrier 的 Runnable？(猜测是最后一个) : " + Thread.currentThread());
            }
        });

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Player(cyclicBarrier));
        }

        try {

            TimeUnit.SECONDS.sleep(5);
            for (int i = 0; i < 5; i++) {
                exec.execute(new Player(cyclicBarrier));
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        exec.shutdown();
    }
}/*
  * output: Thread[pool-1-thread-3,5,main] 完成任务！等待队友 ing... Thread[pool-1-thread-2,5,main] 完成任务！等待队友 ing...
  * Thread[pool-1-thread-5,5,main] 完成任务！等待队友 ing... Thread[pool-1-thread-1,5,main] 完成任务！等待队友 ing...
  * Thread[pool-1-thread-4,5,main] 完成任务！等待队友 ing...
  * 
  * 全部完成！ 举手报告 ing...
  * 
  * 谁来执行 Barrier 的 Runnable？(猜测是最后一个) : Thread[pool-1-thread-4,5,main]
  */
