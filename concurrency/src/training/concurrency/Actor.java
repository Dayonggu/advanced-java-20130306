package training.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class Actor implements Runnable {

	private final BlockingQueue<Object> messages = new LinkedBlockingQueue<Object>(20);

	public static enum Messages {
		SHUTDOWN
	};

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
				Object message = messages.take();
				if (message == Messages.SHUTDOWN)
					return;
				receive(message);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

	public abstract void receive(Object message);

}
