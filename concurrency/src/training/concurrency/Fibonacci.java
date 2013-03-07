package training.concurrency;

import java.math.BigInteger;
import java.util.Random;

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
		// TODO: on ten separate threads, print a randomFib
	}
}
