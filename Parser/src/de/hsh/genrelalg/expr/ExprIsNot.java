package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Tuple;

public class ExprIsNot implements BooleanExpression{

	BooleanExpression p;
	public ExprIsNot (BooleanExpression p) {
		this.p = p;
		System.out.println("BooleanExpr Left IsNot: " + this.p.toText());
	}
	@Override
	public boolean eval(Tuple t, List<Attribute> attributes) {
		if(this.p.eval(t, attributes)) {
			return false;
		}
		return true;
	}

	@Override
	public String toText() {
		return "is Not " + p.toText();
	}
}
