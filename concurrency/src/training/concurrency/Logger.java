package training.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public class Logger implements Runnable {

	// Rule: never modify the queue in place, always copy!
	private final AtomicReference<Queue<String>> messagesRef =
		new AtomicReference<Queue<String>>(new LinkedList<String>());

	public void log(String message) {
		Queue<String> oldMessages, newMessages;
		do {
			oldMessages = messagesRef.get();
			newMessages = new LinkedList<String>(oldMessages);
			newMessages.add(message);
		} while (!messagesRef.compareAndSet(oldMessages, newMessages));
	}

	public void run() {
		lol:	 while (true) {
			Queue<String> oldMessages, newMessages;
			String message;
			do {
				oldMessages = messagesRef.get();
				if (oldMessages.isEmpty())
					continue lol;
				newMessages = new LinkedList<String>(oldMessages);
				message = newMessages.remove();
			} while (!messagesRef.compareAndSet(oldMessages, newMessages));
			System.out.println(message);
		}
	}

}
