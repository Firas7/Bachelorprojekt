package de.hsh.genrelalg.relalg;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;

public class SetMinus extends RelationalAlgebra {

	RelationalAlgebra left, right;
	double spread;
	boolean matched = false;

	
	public SetMinus(RelationalAlgebra left, RelationalAlgebra right, double spread) {
		this.left = left;
		this.right = right;
		this.spread = spread;
	}

	@Override
	public Relation getResult() {
		Relation left = this.left.getResult();
		Relation right = this.right.getResult();
		Relation res = new Relation(left.getAttributes());
		int numberOfAttributesRight = right.getAttributes().size();
		int numberOfAttributesLeft = left.getAttributes().size();
		
		// check count of attributes in every relation
		if(numberOfAttributesLeft == numberOfAttributesRight) {
			//Compare the contents of the attributes			
			checkAttributesNames(left.getAttributes(), right.getAttributes());
		}else { 
				System.out.println("An Difference is not possible, because Number of attributes of both relations is unequal!");
		}
		
		if(matched) {
			for (Tuple tl : left.getTuples()) {
				if (!right.contains(tl))
					res.addTuple(tl);
			}
		}
		return res;
	}

	@Override
	public String toText(String indent, boolean results) {
		String res = super.toText(indent, results);
		res += indent + "minus (";
		res += left.toText(indent + "  ", results);
		res += "\n" + indent + "  Difference _{  DI  }";
		res += right.toText(indent + "  ", results);
		res += "\n" + indent + ")";
		return res;
	}

	@Override
	public void checkAttributesNames(List<Attribute> left, List<Attribute> right) {

		for(int i = 0; i < left.size(); i++) {
			if(!left.get(i).getName().toUpperCase().equals(right.get(i).getName().toUpperCase())) {
				System.out.println("A Difference is not possible, because the relations have different schemes ");
				matched = false;
				break;
			}
			matched =true;
		}
	}
	
}
