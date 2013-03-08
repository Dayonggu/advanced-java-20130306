package training.concurrency;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		List<Actor> actors = new LinkedList<Actor>();

		final Logger logger = new Logger();
		actors.add(logger);

		for (int i = 0; i < 10; i++) {
			Fibonacci fib = new Fibonacci(logger);
			fib.tell(Fibonacci.Messages.FIB);
			actors.add(fib);
		}

		for (Actor actor : actors) {
			pool.execute(actor);
		}

		try {
			System.in.read();
		} catch (IOException e) {
		}

		for (Actor actor : actors) {
			actor.tell(Actor.Messages.SHUTDOWN);
		}

		pool.shutdown();
	}

}
