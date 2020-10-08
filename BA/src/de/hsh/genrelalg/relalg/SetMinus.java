package de.hsh.genrelalg.relalg;

import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;

public class SetMinus extends RelationalAlgebra {

	RelationalAlgebra left, right;
	double spread;
	
	public SetMinus(RelationalAlgebra left, RelationalAlgebra right, double spread) {
		this.left = left;
		this.right = right;
		this.spread = spread;
	}

	@Override
	public Relation getResult() {
		Relation l = left.getResult();
		Relation r = right.getResult();
		Relation res = new Relation(l.getAttributes());
		for (Tuple tl : l.getTuples()) {
			if (!r.contains(tl))
				res.addTuple(tl);
		}
		return res;
	}

	@Override
	public String toText(String indent, boolean results) {
		String res = super.toText(indent, results);
		res += indent + "minus (";
		res += left.toText(indent + "  ", results) + ",";
		res += right.toText(indent + "  ", results);
		res += "\n" + indent + ")";
		return res;
	}
	
}
