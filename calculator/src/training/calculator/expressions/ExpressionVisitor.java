package training.calculator.expressions;

public interface ExpressionVisitor<V> {
	V visitNumber(NumberExpression expression);
	V visitOperation(OperationExpression expression);
}
