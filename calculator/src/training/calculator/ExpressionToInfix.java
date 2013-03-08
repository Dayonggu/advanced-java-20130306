package training.calculator;

import training.calculator.expressions.ExpressionVisitor;
import training.calculator.expressions.NumberExpression;
import training.calculator.expressions.OperationExpression;

public class ExpressionToInfix implements ExpressionVisitor<String> {

	@Override
	public String visitNumber(NumberExpression expression) {
		return null; // TODO
	}

	@Override
	public String visitOperation(OperationExpression expression) {
		return null; // TODO
	}

}
