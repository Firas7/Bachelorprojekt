package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Tuple;

public class ExpGreater implements BooleanExpression{

	FieldExpression left, right;
	
	// left is an attribute and right is a value
	public ExpGreater(FieldExpression left, FieldExpression right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public boolean eval(Tuple t, List<Attribute> attributes) {
	
	
		return false;
	}

	@Override
	public String toText() {
		// TODO Auto-generated method stub
		return null;
	}

}
