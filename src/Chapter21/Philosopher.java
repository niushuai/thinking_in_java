package Chapter21;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 每个哲学家都是一个 Runnable 任务
 */
public class Philosopher implements Runnable {

    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFctor;
    private Random rand = new Random(47);

    public Philosopher(Chopstick left, Chopstick right, int id, int ponder) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFctor = ponder;
    }

    // 思考的时间
    private void pause() throws InterruptedException {
        //不思考
        if (ponderFctor == 0) {
            return;
        }
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFctor * 250));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // 思考
                System.out.print(this + " thinking...");
                pause();
                
                // 饿了
                System.out.println(this + " grabbing right");
                right.take();
                System.out.println(this + " garbbing left");
                left.take();
                System.out.println(this + " eating...");
                pause();
                
                //吃完了
                right.drop();
                left.drop();

            }
        } catch (InterruptedException e) {
            System.out.println(this + " exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "Philosopher " + id + "号";
    }
}
