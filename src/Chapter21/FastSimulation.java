package Chapter21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FastSimulation {
    static final int N_ELEMENTS = 100000;
    static final int N_GENES = 30;
    static final int N_EVOLVERS = 50;
    static final AtomicInteger[][] GRID = new AtomicInteger[N_ELEMENTS][N_GENES];

    static Random rand = new Random(47);

    static class Evolver implements Runnable {
        public void run() {
            while (!Thread.interrupted()) {
                int element = rand.nextInt(N_ELEMENTS);
                for (int i = 0; i < N_GENES; i++) {
                    int previous = element - 1;
                    if (previous < 0) {
                        previous = N_ELEMENTS - 1;
                    }
                    int next = element + 1;
                    if (next >= N_ELEMENTS) {
                        next = 0;
                    }

                    int oldValue = GRID[element][i].get();
                    int newValue = oldValue + GRID[previous][i].get() + GRID[next][i].get();
                    newValue /= 3;

                    // 如果 GRID[element][i]的值已经发生变化，不和 oldValue 相同， 就打印
                    if (!GRID[element][i].compareAndSet(oldValue, newValue)) {
                        System.out.println("Old value changed from " + oldValue + " to " + GRID[element][i]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < N_ELEMENTS; i++)
            for (int j = 0; j < N_GENES; j++)
                GRID[i][j] = new AtomicInteger(rand.nextInt(1000));

        // 进化50次
        for (int i = 0; i < N_EVOLVERS; i++)
            exec.execute(new Evolver());

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
