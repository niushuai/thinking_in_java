package Chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {
    // true:处于抛光状态,false:处于凃蜡状态
    private boolean waxOn = false;

    // 抛光完成,等待凃蜡
    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    // 凃蜡完成
    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (!waxOn) {
            wait();
        }
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("wax on...");

                TimeUnit.SECONDS.sleep(1);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("exiting via WaxOn interruption...");
        }

        System.out.println("finish buffering.");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("wax off...");
                TimeUnit.SECONDS.sleep(1);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("exiting via WaxOff interruption...");
        }

        System.out.println("finish buffering.");
    }
}

public class WaxOMatic {
    public static void main(String... args) {

        Car car = new Car();

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(new WaxOff(car));
        exec.submit(new WaxOn(car));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdownNow();
    }
}
