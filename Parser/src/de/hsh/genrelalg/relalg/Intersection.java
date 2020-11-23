package de.hsh.genrelalg.relalg;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;

public class Intersection extends RelationalAlgebra{

	RelationalAlgebra left, right;
	boolean matched = false;

	public Intersection(RelationalAlgebra left, RelationalAlgebra right) {
		this.left = left;
		this.right = right;
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
			System.out.println("An Intersection is not possible, because Number of attributes of both relations is unequal!");
		}
		
		if(matched) {
			for(Tuple tl: left.getTuples()) {
				if(right.contains(tl)) {
					res.addTuple(tl);
				}
			}
		}
		
		return res;
	}


	@Override
	public String toText(String indent, boolean results) {
		String res = super.toText(indent, results);
		res += indent + "(";
		res += "\n" + left.toText(indent + "  ", results);
		res += "\n" + indent + "  Intersection _{  IN  }";
		res += "\n" + right.toText(indent + "  ", results);
		res += "\n" + indent + ")";
		return res;
	}
	
public void checkAttributesNames(List<Attribute> left , List <Attribute> right) {
		
		for(int i = 0; i < left.size(); i++) {
			if(!left.get(i).getName().toUpperCase().equals(right.get(i).getName().toUpperCase())) {
				System.out.println("An Intersection is not possible, because the relations have different schemes ");
				matched = false;
				break;
			}
			matched =true;
		}
	}

	
}
