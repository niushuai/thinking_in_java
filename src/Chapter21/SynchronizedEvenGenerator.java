package Chapter21;

public class SynchronizedEvenGenerator extends IntGenerator {
	
	private int currentEvenValue = 0;

	@Override
	public synchronized int next() {
		++currentEvenValue;
		Thread.yield(); // Cause failure faster
		++currentEvenValue;
		return currentEvenValue;
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new SynchronizedEvenGenerator());
	}

}
