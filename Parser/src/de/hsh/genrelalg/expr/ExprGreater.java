package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Tuple;

/*
 * this class is an Expression Greater when the comparator in Selection predicate is (>)
 * */
public class ExprGreater implements BooleanExpression{

	FieldExpression left, right;
	
	// left is an attribute and right is a value
	public ExprGreater(FieldExpression left, FieldExpression right) {
		// left is an attribute
		this.left = left;
		// right is a value
		this.right = right;
	}
	
	@Override
	public boolean eval(Tuple t, List<Attribute> attributes) {
	String a = left.eval(t, attributes);
	String b = right.eval(t, attributes);
	for(int i = 0; i < attributes.size(); i++) {
		int num = Integer.parseInt(a);
		int value = Integer.parseInt(b);
		if(num > value) {
			return true;
		}
	}	
	return false;
	}

	@Override
	public String toText() {
		return String.format("%s > %s", left.toText(), right.toText());
	}

}
