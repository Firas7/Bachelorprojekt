package de.hsh.genrelalg.relalg;

import java.util.LinkedList;
import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;
import de.hsh.genrelalg.expr.BooleanExpression;

public class Join extends RelationalAlgebra {

	RelationalAlgebra left, right;
	BooleanExpression cond;
	double spread;
	boolean leftOuter, rightOuter;
	
	public Join(RelationalAlgebra left, RelationalAlgebra right, BooleanExpression cond, double spread) {
		this(left, right, cond, spread, false, false);
	}
	public Join(RelationalAlgebra left, RelationalAlgebra right, BooleanExpression cond, double spread, boolean leftOuter, boolean rightOuter) {
		this.left = left;
		this.right = right;
		this.cond = cond;
		this.spread = spread;
		this.leftOuter = leftOuter;
		this.rightOuter = rightOuter;
	}
	

	@Override
	public Relation getResult() {
		Relation l = left.getResult();
		Relation r = right.getResult();
		Relation res = new Relation(l.getAttributes());
		for (Attribute att : r.getAttributes()) {
			res.addAttribute(att);
		}

		// for right outer join, initialize a list unused tuples.
		List<Tuple> unused = new LinkedList<>();
		for (Tuple tr : r.getTuples())
			unused.add(tr);
		
		for (Tuple tl : l.getTuples()) {
			boolean matched = false;
			for (Tuple tr : r.getTuples()) {
				Tuple joined = tl.join(tr);
				if (cond.eval(joined, res.getAttributes())) {
					res.addTuple(joined);
					matched = true;
					unused.remove(tr);
				}
			}
			if (!matched && leftOuter) {
				Tuple joined = tl.joinLeftOuter(r);
				res.addTuple(joined);
			}
		}
		
		if (rightOuter) {
			for (Tuple tr : unused) {
				Tuple joined = tr.joinRightOuter(l);
				res.addTuple(joined);
			}
		}
			
		return res;
	}

	@Override
	public String toText(String indent, boolean results) {
		String res = super.toText(indent, results);
		String symbol;
		if (leftOuter && rightOuter)
			symbol = "full join";
		else if (leftOuter)
			symbol = "left join";
		else if (rightOuter)
			symbol = "right join";
		else
			symbol = "join";

		res += indent + "(";
		res += "\n" + left.toText(indent + "  ", results);
		res += "\n" + indent + "  " + symbol + "_{" + cond.toText() + "}";
		res += "\n" + right.toText(indent + "  ", results);
		res += "\n" + indent + ")";
		return res;
	}
	@Override
	public void checkAttributesDataTypes(List<Attribute> left, List<Attribute> right) {}

}
