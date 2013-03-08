package training.calculator.expressions;

public interface Expression {
	<V> V accept(ExpressionVisitor<V> visitor);
}
