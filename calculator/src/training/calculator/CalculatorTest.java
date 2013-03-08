package training.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

import training.calculator.expressions.Expression;
import training.calculator.expressions.NumberExpression;
import training.calculator.expressions.OperationExpression;

public class CalculatorTest {

	private static final NumberExpression ONE = new NumberExpression(1);

	@Test
	public void testHandleNumber() {
		Stack<Expression> stack = new Stack<Expression>();
		assertTrue(Calculator.handleNumber("1", stack));
		assertEquals(ONE, stack.pop());
	}

	@Test
	public void testHandleOperator() {
		Stack<Expression> stack = new Stack<Expression>();
		stack.push(ONE);
		stack.push(ONE);
		assertTrue(Calculator.handleOperator("+", stack));
		assertEquals(new OperationExpression(ONE, ONE, Operator.ADD),
				stack.pop());
	}

	@Test
	public void onePlusOneMustEqualTwo() {
		assertEquals(2, (int) Calculator.parse("1 1 +").accept(new ExpressionEvaluator()));
	}

}
