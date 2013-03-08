package training.concurrency;

public class Logger extends Actor {

	@Override
	public void receive(Object message) {
		System.out.println(message);
	}

}
