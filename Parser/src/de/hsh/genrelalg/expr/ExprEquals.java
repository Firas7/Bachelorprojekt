package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Tuple;

public class ExprEquals implements BooleanExpression {
	FieldExpression left, right;

	public ExprEquals(FieldExpression left, FieldExpression right) {
		// left is an attribute
		this.left = left;
		// right is a value
		this.right = right;
	}
	
	/*diese Methode vergleicht, ob zwei die Tuple und Attribute einer leftRelation mit den Tuple und Attribute der rightRelation übereinstimmen
	hier muss nicht nur equlas aufrufen werden sondern auch andere Vergleichsoperatoren.
	*/
	@Override
	public boolean eval(Tuple t, List<Attribute> attributes) {
		return left.eval(t, attributes).equals(right.eval(t, attributes));
	}

	@Override
	public String toText() {
		return String.format("%s = %s", left.toText(), right.toText());
	}	
}
