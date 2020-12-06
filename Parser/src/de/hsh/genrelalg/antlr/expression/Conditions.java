package de.hsh.genrelalg.antlr.expression;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.expr.BooleanExpression;

public class Conditions {

	List<BooleanExpression> list;
	
	public Conditions() {
		list = new ArrayList<>();
	}
	
	public void addExpression(BooleanExpression exp) {
		list.add(exp);
	}
	
	public List<BooleanExpression> getExpressions(){
		return this.list;
	}
}

