package training.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class Logger implements Runnable {

	private final Queue<String> messages = new LinkedList<String>();

	public void log(String message) {
		synchronized (this) {
			messages.add(message);
			notify();
		}
	}

	public void run() {
		while (true) {
			synchronized (this) {
				if (!messages.isEmpty()) {
					System.out.println(messages.remove());
				} else {
					try {
						wait();
					} catch (InterruptedException e) {
						return;
					}
				}
			}
		}
	}

}
