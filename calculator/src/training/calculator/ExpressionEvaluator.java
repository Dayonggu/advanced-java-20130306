package training.calculator;

import training.calculator.expressions.ExpressionVisitor;
import training.calculator.expressions.NumberExpression;
import training.calculator.expressions.OperationExpression;

public class ExpressionEvaluator implements ExpressionVisitor<Integer> {

	@Override
	public Integer visitNumber(NumberExpression expression) {
		return expression.value;
	}

	@Override
	public Integer visitOperation(OperationExpression expression) {
		return expression.op.operate(
			expression.lhs.accept(this),
			expression.rhs.accept(this));
	}

}
