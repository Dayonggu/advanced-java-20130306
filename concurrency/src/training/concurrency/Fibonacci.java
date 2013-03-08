package training.concurrency;

import java.math.BigInteger;
import java.util.Random;

public class Fibonacci extends Actor {

	private static final Random RANDOM = new Random();
	private final Logger logger;

	public static enum Messages {
		FIB
	}

	public Fibonacci(Logger logger) {
		this.logger = logger;
	}

	@Override
	public void receive(Object message) {
		if (message == Messages.FIB) {
			logger.tell(randomFib());
			this.tell(Messages.FIB);
		}
	}

	private static BigInteger fib(int n) {
		return (n == 0 || n == 1)
			? BigInteger.ONE
			: fib(n-1).add(fib(n-2));
	}

	private static BigInteger randomFib() {
		return fib(RANDOM.nextInt(35));
	}

}
