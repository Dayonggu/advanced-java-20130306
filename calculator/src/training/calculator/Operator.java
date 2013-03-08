package training.calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
	ADD("+") {
		public int operate(int lhs, int rhs) {
			return lhs + rhs;
		}
	},
	SUBTRACT("-") {
		public int operate(int lhs, int rhs) {
			return lhs - rhs;
		}
	},
	MULTIPLY("*") {
		public int operate(int lhs, int rhs) {
			return lhs * rhs;
		}
	},
	DIVIDE("/") {
		public int operate(int lhs, int rhs) {
			return lhs / rhs;
		}
	};

	private static final Map<String, Operator> operators;
	static {
		operators = new HashMap<String, Operator>();
		for (Operator op : Operator.values()) {
			operators.put(op.toString(), op);
		}
	}

	private final String token;
	private Operator(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return token;
	}

	public static Operator fromString(String token) {
		return operators.get(token);
	}

	public abstract int operate(int lhs, int rhs);
}
