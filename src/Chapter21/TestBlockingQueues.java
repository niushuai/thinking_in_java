package Chapter21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    //生产者
    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch(InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }
    
    //消费者——注意后面的程序先启动了消费者。
    public void run() {
        try {
            while(!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch(InterruptedException e) {
            System.out.println("waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}

public class TestBlockingQueues {
    /**
     * 其实getkey()仅仅是为了隔开 BlockingQueue 的不同实现类。
     */
    static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    static void getkey(String message) {
        System.out.println(message);
        getkey();
    }
    
    /**
     * 每次测试一种 BlockingQueue 的实现。其中先调用t.start()是为了启动消费者。
     * 因为没有启动生产者，所以 BlockingQueue 会自动挂起。然后使用 for 循环生产 rockets 的元素。
     * 
     * 所以不仅实例了 BlockingQueue 作为一个 Queue 的使用，也演示了当生产者或者消费者阻塞时，BlockingQueue
     * 会自动帮我们处理，使我们可以专注于业务逻辑。
     */
    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for(int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getkey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        System.out.println("Finished " + msg + " test");
    }
    
    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingDeque<LiftOff>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue", new SynchronousQueue<LiftOff>());
    }
}
