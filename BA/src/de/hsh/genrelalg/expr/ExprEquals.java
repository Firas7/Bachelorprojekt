package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Tuple;

public class ExprEquals implements BooleanExpression {
	FieldExpression left, right;

	public ExprEquals(FieldExpression left, FieldExpression right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public boolean eval(Tuple t, List<Attribute> attributes) {
		return left.eval(t, attributes).equals(right.eval(t, attributes));
	}

	@Override
	public String toText() {
		return String.format("%s = %s", left.toText(), right.toText());
	}	
}
