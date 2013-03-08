package training.calculator;

public enum Operator {
	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("*"),
	DIVIDE("/");

	private final String token;
	private Operator(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return token;
	}
}
