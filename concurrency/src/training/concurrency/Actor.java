package training.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class Actor implements Runnable {

	private final BlockingQueue<Object> messages = new LinkedBlockingQueue<Object>(20);

	public void tell(Object message) {
		try {
			messages.put(message);
		} catch (InterruptedException e) {
			return;
		}
	}

	public void run() {
		while (true) {
			try {
				receive(messages.take());
			} catch (InterruptedException e) {
				return;
			}
		}
	}

	public abstract void receive(Object message);

}
