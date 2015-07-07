package Chapter21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Toast {
    public enum Status {
        DRY, BUTTERED, JAMMED
    };

    private Status status = Status.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Toast " + id + ": " + status;
    }

}

/**
 * ToastQueue 充当别名的作用。就好像 typedef
 *
 */
class ToastQueue extends LinkedBlockingQueue<Toast> {
    
}

//制造吐司
class Toaster implements Runnable {
    
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);
    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }
    
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.add(toast);
            }
        } catch(InterruptedException e) {
            System.out.println("制造吐司 is interrupted!");
        }
        System.out.println("Toaster off");
    }
}

//抹黄油
class Butterer implements Runnable {
    
    private ToastQueue dryQueue, butteredQueue;
    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }
    
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butteredQueue.put(toast);
            }
        } catch(InterruptedException e) {
            System.out.println("抹黄油 is interrupted!");
        }
        System.out.println("Butterer off");
    }
}

//抹果酱
class Jammer implements Runnable {
    
    private ToastQueue butteredQueue, finishedQueue;
    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }
    
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Toast toast = butteredQueue.take();
                toast.jam();
                System.out.println(toast);
                finishedQueue.put(toast);
            }
        } catch(InterruptedException e) {
            System.out.println("抹果酱 is interrupted!");
        }
        System.out.println("Jammer off");
    }
}

//吃吃吃
class Eater implements Runnable {
    
    private ToastQueue finishedQueue;
    private int count = 0;
    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }
    
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Toast toast = finishedQueue.take();
                //检查吐司是否按照 order 送来，而且所有都是经过黄油、果酱加工
                if(toast.getId() != count++ || toast.getStatus() != Toast.Status.JAMMED) {
                    System.err.println("Error: " + toast);
                    System.exit(1);
                } else {
                    System.out.println("真好吃啊！！！");
                }
                
            }
        } catch(InterruptedException e) {
            System.out.println("吃吃吃 is interrupted!");
        }
        System.out.println("Eater off");
    }
}

public class ToastMatic {
    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
