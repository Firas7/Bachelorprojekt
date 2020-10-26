package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Tuple;

public class ExprIsNull implements BooleanExpression {
	FieldExpression expr;

	public ExprIsNull(FieldExpression expr) {
		this.expr = expr;
	}
	
	@Override
	public boolean eval(Tuple t, List<Attribute> attributes) {
		return expr.eval(t, attributes) == null;
	}

	@Override
	public String toText() {
		return String.format("%s IS NULL", expr.toString());
	}	
}
