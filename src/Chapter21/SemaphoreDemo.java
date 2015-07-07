package Chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// 抽象成一个资源池
class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<T>();
    private volatile boolean[] checkedOut;
    private Semaphore available;

    // 要放入资源池的资源数目，如果请求线程数目大于资源池资源数目，就需要阻塞等待
    public Pool(Class<T> classObject, int size) {
        this.size = size;
        checkedOut = new boolean[size];
        /**
         * 第二个参数的含义:<br>
         * 
         * true: 代表的是公平竞争<br>
         * 没有第二个参数或者false：代表随机选中等待许可证的线程
         */
        available = new Semaphore(size, true);
        // Load pool with objects that can be checked out:
        for (int i = 0; i < size; i++) {
            try {
                // Assumes a default constructor:
                items.add(classObject.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public T checkOut() throws InterruptedException {
        available.acquire();
        return getItem();
    }

    public void checkIn(T x) {
        if (releaseItem(x))
            available.release();
    }

    private synchronized T getItem() {
        for (int i = 0; i < size; i++)
            if (!checkedOut[i]) {
                checkedOut[i] = true;
                return items.get(i);
            }
        return null;
    }

    // 回收资源
    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        // not in the list
        if (index == -1)
            return false;
        if (checkedOut[index]) {
            checkedOut[index] = false;
            return true;
        }
        return false; // wasn't checked out
    }

}

class Fat {
    private volatile double d; // 阻止指令优化
    private static int counter = 0;
    private final int id = counter++;

    public Fat() {
        // Expensive, interruptible operation
        for (int i = 1; i < 10000; i++) {
            d += (Math.PI + Math.E) / (double) i;
        }
    }

    public void operation() {
        System.out.println(this);
    }

    public String toString() {
        return "Fat id: " + id;
    }

}

class CheckoutTask<T> implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            T item = pool.checkOut();
            System.out.println(this + "checked out " + item);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + "checked in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            // 终止
        }
    }

    @Override
    public String toString() {
        return "checkoutTask " + id + " ";
    }
}

public class SemaphoreDemo {
    final static int SIZE = 25;

    public static void main(String[] args) throws Exception {
        // 创建一个 Fat 的资源池，大小为25
        final Pool<Fat> pool = new Pool<Fat>(Fat.class, SIZE);

        // 启动25个线程开始玩，从25个资源池 checkout
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new CheckoutTask<Fat>(pool));
        }
        System.out.println("All CheckoutTasks created");

        // 然后用主线程把所有的 Fat 全灌到 list 中了，资源池为空
        List<Fat> list = new ArrayList<Fat>();
        for (int i = 0; i < SIZE; i++) {
            Fat fat = pool.checkOut();
            System.out.println(i + ": main() thread checked out ");
            fat.operation();
            list.add(fat);
        }

        // 还记得 Future 会阻塞吗？因为主线程把25个资源全 checkout 了，所以再 checkOut 肯定阻塞了
        Future<?> blocked = exec.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    // Semaphore prevents additional checkout,
                    // so call is blocked:
                    pool.checkOut();
                } catch (InterruptedException e) {
                    System.out.println("checkOut() Interrupted");
                }
            }
        });
        // 因为 Semaphore 是阻塞的，所以10s 还拿不到的情况下，就取消 blocked 线程的工作
        TimeUnit.SECONDS.sleep(10);
        blocked.cancel(true); // Break out of blocked call
        System.out.println("\n\n\nChecking in objects in " + list);
        for (Fat f : list) {
            pool.checkIn(f);
        }
        for (Fat f : list) {
            pool.checkIn(f); // Second checkIn ignored
        }
        exec.shutdown();
    }

}
