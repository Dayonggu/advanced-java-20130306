package training.calculator;

import training.calculator.expressions.ExpressionVisitor;
import training.calculator.expressions.NumberExpression;
import training.calculator.expressions.OperationExpression;

public class ExpressionToInfix implements ExpressionVisitor<String> {

	@Override
	public String visitNumber(NumberExpression expression) {
		return String.valueOf(expression.value);
	}

	@Override
	public String visitOperation(OperationExpression expression) {
		return String.format("(%s %s %s)",
			expression.lhs.accept(this),
			expression.op,
			expression.rhs.accept(this));
	}

}
