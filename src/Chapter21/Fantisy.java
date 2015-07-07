package Chapter21;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Food implements Delayed {
    private String foodName;
    private long saveTime;// 保存时间
    private long expireTime;// 过期时刻=当前时间+保存时间

    public Food(String foodName, long saveTime) {
        this.foodName = foodName;
        this.saveTime = saveTime;
        this.expireTime = TimeUnit.NANOSECONDS.convert(saveTime, TimeUnit.SECONDS) + System.nanoTime();
    }

    @Override
    public int compareTo(Delayed o) {
        Food that = (Food) o;
        if (this.expireTime > that.expireTime) {// 过期时刻越靠后，越排在队尾.
            return 1;
        } else if (this.expireTime == that.expireTime) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expireTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public String getFoodName() {
        return this.foodName;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public long getSaveTime() {
        return this.saveTime;
    }
}

class FoodChecker implements Runnable {
    private DelayQueue<Food> queue;

    public FoodChecker(DelayQueue<Food> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("开始检查!");
            boolean flag = true;
            while (flag) {
                Food food = queue.take();// 此处会阻塞,没有时过期食品时不会取出
                System.out.println(food.getFoodName() + "食品过期!保存时间:" + food.getSaveTime() + "天.");
                if (queue.isEmpty()) {
                    flag = false;
                }
            }
            System.out.println("检查完毕!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Fantisy {

    public static long getRandomDay(Random r) {
        return r.nextInt(20);
    }

    public static void main(String[] args) {
        DelayQueue<Food> queue = new DelayQueue<Food>();
        Random r = new Random(47);
        queue.add(new Food("A", getRandomDay(r)));
        queue.add(new Food("B", getRandomDay(r)));
        queue.add(new Food("C", getRandomDay(r)));
        queue.add(new Food("D", getRandomDay(r)));
        queue.add(new Food("E", getRandomDay(r)));
        queue.add(new Food("F", getRandomDay(r)));

        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(new FoodChecker(queue));
        es.shutdown();
    }
}
