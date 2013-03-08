package training.calculator;

import java.util.Stack;

import training.calculator.expressions.Expression;
import training.calculator.expressions.NumberExpression;
import training.calculator.expressions.OperationExpression;

public class Calculator {

	public static boolean handleNumber(String token, Stack<Expression> stack) {
		try {
			stack.push(new NumberExpression(Integer.parseInt(token)));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean handleOperator(String token, Stack<Expression> stack) {
		Operator op = Operator.fromString(token);
		if (op == null)
			return false;

		Expression rhs = stack.pop(), lhs = stack.pop();
		stack.push(new OperationExpression(lhs, rhs, op));
		return true;
	}

	public static Expression parse(String expression) {
		Stack<Expression> stack = new Stack<Expression>();
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

		Expression expression = parse(args[0]);
		System.out.println(expression + " = " + expression.calculate());
	}

}
