package de.hsh.genrelalg.relalg;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;
import de.hsh.genrelalg.expr.BooleanExpression;
import de.hsh.genrelalg.expr.ExprAnd;

public class Selection extends RelationalAlgebra {

	public RelationalAlgebra base;
	public BooleanExpression expr;
	
	public Selection(RelationalAlgebra base, BooleanExpression expr) {
		this.base = base;
		this.expr = expr;
	}

	@Override
	public Relation getResult() {
		Relation baserel = base.getResult();
		Relation res = new Relation(baserel.getAttributes());
		System.out.println("Expr is: " + this.expr.toText());
		for (Tuple t : baserel.getTuples()) {
			if (expr.eval(t, baserel.getAttributes()) == true) {
				res.addTuple(t);
			}
		}
		return res;
	}

	@Override
	public String toText(String indent, boolean results) {
		String res = super.toText(indent, results);
		res += indent + "select_{" + expr.toText() + "} (";
		res += "\n" + base.toText(indent + "  ", results);
		res += "\n" + indent + ")";
		return res;
	}

	@Override
	public void checkAttributesNames(List<Attribute> left, List<Attribute> right) {
		// TODO Auto-generated method stub
		
	}

}
