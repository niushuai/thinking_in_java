package Chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 顺序执行的 Executor，是 FixedThreadPool 的特例化
 * @author niushuai
 *
 */
public class SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 5; ++i) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
		
	}
}
