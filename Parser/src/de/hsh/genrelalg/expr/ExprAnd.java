package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Tuple;

public class ExprAnd implements BooleanExpression{

	
	// select (relation , ExprAnd(ExprGreater, ExprEqual()));
	BooleanExpression left, right;
	public ExprAnd (BooleanExpression p1 , BooleanExpression p2) {
		this.left = p1;
		this.right= p2;
		System.out.println("BooleanExpr Left and: " + this.left.toText());
		System.out.println("BooleanExpr Right and: " + this.right.toText());
	}
	@Override
	public boolean eval(Tuple t, List<Attribute> attributes) {
		if(this.left.eval(t, attributes) && this.right.eval(t, attributes)) {
			return true;
		}
		return false;
	}

	@Override
	public String toText() {
		return String.format("%s AND %s", this.left.toText(), this.right.toText());
	}
}
