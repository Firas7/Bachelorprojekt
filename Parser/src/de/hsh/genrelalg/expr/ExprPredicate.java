package de.hsh.genrelalg.expr;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Predicate;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;
import de.hsh.genrelalg.relalg.Selection;
import de.hsh.genrelalg.relalg.Union;

public class ExprPredicate implements FieldExpression{

	Predicate predicate;
	public ExprPredicate(Predicate p) {
		this.predicate = p;
	}
	
	public BooleanExpression getExpressionOfPredicate() {
		return this.predicate.getExpression();
	}
	
	@Override
	public String eval(Tuple t, List<Attribute> attributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toText() {
		// TODO Auto-generated method stub
		return predicate.toText();
	}
}
