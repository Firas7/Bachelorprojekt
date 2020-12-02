package de.hsh.genrelalg.relalg;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Predicate;
import de.hsh.genrelalg.data.Relation;

public class AND extends RelationalAlgebra{

	Predicate left, right;
	public RelationalAlgebra base;
	
	public AND(RelationalAlgebra base,Predicate left, Predicate right) {
		this.left = left;
		this.right = right;
		this.base = base;
	}
	
	public Predicate getLeftPredicate() {
		return left;
	}

	public Predicate getRightPredicate() {
		return right;
	}

	@Override
	public Relation getResult() {
		Selection s = new Selection(this.base,this.left.getExpression());
		s = new Selection(s.getResult(),this.right.getExpression());
		return s.getResult();
	}

	@Override
	public void checkAttributesNames(List<Attribute> left, List<Attribute> right) {
		// TODO Auto-generated method stub
		
	}
	
}
