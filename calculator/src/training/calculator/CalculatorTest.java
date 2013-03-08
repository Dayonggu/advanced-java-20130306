package training.calculator;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testHandleNumber() {
		Stack<Integer> stack = new Stack<Integer>();
		assertTrue(Calculator.handleNumber("1", stack));
		assertEquals(1, (int) stack.pop());
	}

	@Test
	public void testHandleOperator() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(1);
		assertTrue(Calculator.handleOperator("+", stack));
		assertEquals(2, (int) stack.pop());
	}

	@Test
	public void onePlusOneMustEqualTwo() {
		assertEquals(2, Calculator.calculate("1 1 +"));
	}

}
