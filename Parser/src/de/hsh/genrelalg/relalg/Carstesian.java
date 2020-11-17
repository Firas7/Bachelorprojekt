package de.hsh.genrelalg.relalg;

import java.util.ArrayList;
import java.util.List;


import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;
import de.hsh.genrelalg.expr.BooleanExpression;

public class Carstesian extends RelationalAlgebra{

	RelationalAlgebra left, right;
	BooleanExpression cond;
	double spread;
	
	public Carstesian(RelationalAlgebra left, RelationalAlgebra right ,double spread) {
		this.left = left;
		this.right = right;
		this.spread =spread;
	}
	
	@Override
	public Relation getResult() {
		Relation l = left.getResult();
		Relation r = right.getResult();
		List <Attribute> attributesLeft = l.getAttributes();
		List <Attribute> attributRight = r.getAttributes();
		List <Attribute> listFinal = new ArrayList<>();
		listFinal.addAll(attributesLeft);
		listFinal.addAll(attributRight);
		Relation res = new Relation(listFinal);
		for (Tuple tl : l.getTuples()) {
			for (Tuple tr : r.getTuples()) {
				Tuple joined = tl.join(tr);
				res.addTuple(joined);
			}
			
		}
		return res;
	}

	@Override
	public String toText(String indent, boolean results) {
		String res = super.toText(indent, results);
		res += indent + "Carstesian_{";
		res += "\n" + left.toText(indent + "  ", results);
		res += "\n X";
		res += "\n" + right.toText(indent + "  ", results);
		res += "\n" + indent + "}";
		return res;
	}


}
