package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Tuple;

public class ExprConstant implements FieldExpression {

	private String value;

	public ExprConstant(String value) {
		this.value = value;
	}
	
	@Override
	public String eval(Tuple t, List<Attribute> attributes) {
		return value;
	}

	@Override
	public String toText() {
		return String.format("'%s'", value);
	}

}
