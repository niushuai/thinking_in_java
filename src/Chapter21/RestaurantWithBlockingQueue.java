package Chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * 这个例子的一个收获是：
 * 
 * 想要抛出异常必须得有载体。比如：
 * 
 * while(!Thread.interrupted()) {
 * }
 * 
 * 是不会抛出异常的。
 * 
 * 只有当里面有 sleep()/wait()/join()在运行（让线程处于阻塞状态），然后才能从阻塞状态退出，
 * 并抛出一个 InterruptedException。
 * 
 */

class NewMeal {
    private final int orderNum;

    public NewMeal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}

class NewWaiter implements Runnable {
    private RestaurantWithBlockingQueue restaurant;

    public NewWaiter(RestaurantWithBlockingQueue restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                while (!restaurant.meal.isEmpty()) {
                    NewMeal meal = restaurant.meal.take();
                    System.out.println("Waiter got " + meal);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted waiter");
        }
    }
}

class NewChef implements Runnable {
    private RestaurantWithBlockingQueue restaurant;

    public NewChef(RestaurantWithBlockingQueue restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 1; i <= 11; i++) {

                    if (i == 11) {
                        restaurant.exec.shutdownNow();
                        continue;
                    }

                    System.out.println("做菜...");
                    restaurant.meal.add(new NewMeal(i));
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted chef");
        }
    }
}

public class RestaurantWithBlockingQueue {
    LinkedBlockingQueue<NewMeal> meal = new LinkedBlockingQueue<NewMeal>();
    ExecutorService exec = Executors.newCachedThreadPool();
    NewWaiter waiter = new NewWaiter(this);
    NewChef chef = new NewChef(this);

    public RestaurantWithBlockingQueue() {
        exec.execute(waiter);
        exec.execute(chef);

    }

    public static void main(String[] args) {
//        while(!Thread.interrupted()) {
//            System.out.println("ehl");
//        }
        new RestaurantWithBlockingQueue();
    }
}
