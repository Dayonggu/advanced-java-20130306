package training.concurrency;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fibonacci {

	private static final Random RANDOM = new Random();

	public static BigInteger fib(int n) {
		return (n == 0 || n == 1)
			? BigInteger.ONE
			: fib(n-1).add(fib(n-2));
	}

	public static BigInteger randomFib() {
		return fib(RANDOM.nextInt(35));
	}

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(10);
		final Logger logger = new Logger();
		pool.execute(logger);

		while (true) {
			Runnable task = new Runnable() {
				public void run() {
					logger.tell(randomFib().toString());
				}
			};
			pool.execute(task);
		}

		// pool.shutdown();
	}
}
