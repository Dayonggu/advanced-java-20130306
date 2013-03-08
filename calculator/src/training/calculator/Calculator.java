package training.calculator;

import java.util.Stack;

public class Calculator {

	/*
	 * 1. tokenize the string
	 * 2. for each token
	 *    - if it's a number, push it on stack
	 *    - if it's an operator, pop two elements from stack
	 *      perform operation (remember order of lhs and rhs!)
	 *      push result
	 *    - if it's neither: throw
	 * 3. pop last element from stack
	 * 
	 * "1 2 3 + - 4 5 * 6 / +"  ==>  -1
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("usage: Calculator <expression>");
			return;
		}

		Stack<Integer> stack = new Stack<Integer>();
		for (String token : args[0].split(" ")) {
			try {
				stack.push(Integer.parseInt(token));
			} catch (NumberFormatException e) {
				int rhs = stack.pop(), lhs = stack.pop();
				if (token.equals("+")) {
					stack.push(lhs + rhs);
				} else if (token.equals("-")) {
					stack.push(lhs - rhs);
				} else if (token.equals("*")) {
					stack.push(lhs * rhs);
				} else if (token.equals("/")) {
					stack.push(lhs / rhs);
				} else {
					throw new IllegalArgumentException("invalid token: " + token);
				}
			}
		}
		System.out.println(stack.pop());
	}

}
