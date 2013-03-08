package training.calculator;

import training.calculator.expressions.Expression;
import training.calculator.expressions.ExpressionProcessor;
import training.calculator.expressions.NumberExpression;
import training.calculator.expressions.OperationExpression;

public class ExpressionEvaluator implements ExpressionProcessor<Integer> {

	@Override
	public Integer process(Expression expression) {
		if (expression instanceof NumberExpression) {
			NumberExpression e = (NumberExpression) expression;
			return e.value;
		} else if (expression instanceof OperationExpression) {
			OperationExpression e = (OperationExpression) expression;
			return e.op.operate(process(e.lhs), process(e.rhs));
		}
		return null;
	}

}
