package de.hsh.genrelalg.relalg;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Predicate;
import de.hsh.genrelalg.data.Relation;

public class OR extends RelationalAlgebra{

	Predicate left, right;
	RelationalAlgebra base;
	public OR(RelationalAlgebra base , Predicate left, Predicate right) {
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
		Selection s1 = new Selection(this.base, this.left.getExpression());
		Selection s2 = new Selection(this.base,this.right.getExpression());
		Union u = new Union(s1.getResult(),s2.getResult());
		return u.getResult();
	}

	@Override
	public void checkAttributesNames(List<Attribute> left, List<Attribute> right) {
		// TODO Auto-generated method stub
		
	}
	
	
}
