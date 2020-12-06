package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Tuple;

public class ExprOr implements BooleanExpression{

	
	BooleanExpression left, right;
	public ExprOr (BooleanExpression p1 , BooleanExpression p2) {
		this.left = p1;
		this.right= p2;
	}
	
	@Override
	public boolean eval(Tuple t, List<Attribute> attributes) {
		if(this.left.eval(t, attributes) || this.right.eval(t, attributes)) {
			return true;
		}
		return false;
	}

	@Override
	public String toText() {
		return String.format("%s OR %s", this.left.toText(), this.right.toText());
	}

	
}
