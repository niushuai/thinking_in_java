package Chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<List<Integer>> exchanger = new Exchanger<>();
        new Consumer(exchanger).start();
        new Producer(exchanger).start();
    }

}

class Producer extends Thread {
    List<Integer> list = new ArrayList<>();
    Exchanger<List<Integer>> exchanger = null;

    public Producer(Exchanger<List<Integer>> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        System.out.println("this is Producer");
        Random rand = new Random();
        for (int i = 0; i < 1; i++) {
            list.clear();
            list.add(rand.nextInt(10000));
            list.add(rand.nextInt(10000));
            list.add(rand.nextInt(10000));
            list.add(rand.nextInt(10000));
            list.add(rand.nextInt(10000));
            try {
                System.out.println("producer exchanger...");
                list = exchanger.exchange(list);
                System.out.println("Producer is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    List<Integer> list = new ArrayList<>();
    Exchanger<List<Integer>> exchanger = null;

    public Consumer(Exchanger<List<Integer>> exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        System.out.println("this is Consumer");
        for (int i = 0; i < 1; i++) {
            try {
                System.out.println("consumer blocking...");
                list = exchanger.exchange(list);
                System.out.println("consumer is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(list.get(0) + ", ");
            System.out.print(list.get(1) + ", ");
            System.out.print(list.get(2) + ", ");
            System.out.print(list.get(3) + ", ");
            System.out.println(list.get(4) + ", ");
        }
    }
}
