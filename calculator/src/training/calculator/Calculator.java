package training.calculator;

import java.util.Stack;

public class Calculator {

	public static boolean handleNumber(String token, Stack<Integer> stack) {
		try {
			stack.push(Integer.parseInt(token));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean handleOperator(String token, Stack<Integer> stack) {
		if (token.equals("+")) {
			int rhs = stack.pop(), lhs = stack.pop();
			stack.push(lhs + rhs);
		} else if (token.equals("-")) {
			int rhs = stack.pop(), lhs = stack.pop();
			stack.push(lhs - rhs);
		} else if (token.equals("*")) {
			int rhs = stack.pop(), lhs = stack.pop();
			stack.push(lhs * rhs);
		} else if (token.equals("/")) {
			int rhs = stack.pop(), lhs = stack.pop();
			stack.push(lhs / rhs);
		} else {
			return false;
		}
		return true;
	}

	public static int calculate(String expression) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : expression.split(" ")) {
			if (!handleOperator(token, stack) && !handleNumber(token, stack)) {
				throw new IllegalArgumentException("invalid token: " + token);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("usage: Calculator <expression>");
			return;
		}

		System.out.println(calculate(args[0]));
	}

}
