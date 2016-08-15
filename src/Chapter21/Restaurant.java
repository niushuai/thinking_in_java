package Chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}

class Waiter implements Runnable {

    private Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                System.out.println("Waiter got " + restaurant.meal);
                // 为什么要选择 chef 作为同步控制块的锁呢？
                // 废话，想通知 chef，肯定要调用 chef.notifyAll()。因为 notifyAll()必须在
                // 同步控制块中调用，而且释放的是 chef 的锁，肯定需要先获取 chef 的锁了。。。
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // 准备下一道菜
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Waiter interrupted");
        }

        System.out.println("服务员下班。。。");
    }
}

class Chef implements Runnable {

    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }

                if (++count == 11) {
                    System.out.println("\n菜上齐了\n");
                    //这块只是向 chef 和 waiter 发送一个 interrupt 信号
                    //但是因为 synchronized 和 IO 是不能被中断的，所以这里会通过可中断的
                    //sleep()抛出 InterruptedException。
                    //而 waiter 只能通过 while(Thread.interrupted())抛出的 InterruptedException返回

                    restaurant.exec.shutdownNow();
                    TimeUnit.MILLISECONDS.sleep(100);
                }

                System.out.println("做菜ing...");

                // 因为要让服务员来端菜,所以需要在服务员上加锁。
                synchronized (restaurant.waiter) {
                    restaurant.meal = new Meal(count);
                    restaurant.waiter.notifyAll();
                }

                TimeUnit.MILLISECONDS.sleep(100);


            }
        } catch (InterruptedException e) {
            System.out.println("chef interrupted");
        }

        System.out.println("厨师下班。。。");
    }
}

public class Restaurant {
    ExecutorService exec = Executors.newCachedThreadPool();

    Chef chef = new Chef(this);
    Waiter waiter = new Waiter(this);
    Meal meal;

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waiter);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
