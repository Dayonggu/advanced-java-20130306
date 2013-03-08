package training.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger implements Runnable {

	private final BlockingQueue<String> messages = new LinkedBlockingQueue<String>(20);

	public void log(String message) {
		try {
			messages.put(message);
		} catch (InterruptedException e) {
			return;
		}
	}

	public void run() {
		while (true) {
			try {
				System.out.println(messages.take());
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
