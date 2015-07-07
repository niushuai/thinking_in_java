package Chapter21;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * PipedWriter.write()和 PipedReader.read() 都可以中断，这是和普通 IO 之间最重要的区别了。
 */
class Sender implements Runnable {
    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return out;
    }

    @Override
    public void run() {
        try {
            //while (true) {
                for(Integer i = 0; i < 10000000; i++) {
                    out.write(i);
                    //TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            //}
        } catch (IOException e) {
            System.out.println(e + " Sender write exception");
        }
//        } catch (InterruptedException e) {
//            System.out.println(e + " Sender sleep interrupted");
//        }
    }
}

class Receiver implements Runnable {
    private PipedReader in;

    //必须和一个 PipedWriter 相关联
    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true) {
                //调用 P ipedReader.read()，如果管道没有数据会自动阻塞
                System.out.print("Read: " + (char) in.read() + ", ");
            }
        } catch (IOException e) {
            System.out.println(e + " Receiver read exception");
        }
    }
}

public class PipedIO {
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);

        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
}
