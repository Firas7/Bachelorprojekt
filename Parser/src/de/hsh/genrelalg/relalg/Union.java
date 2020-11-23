package de.hsh.genrelalg.relalg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;

public class Union extends RelationalAlgebra{

	
	RelationalAlgebra left, right;
	boolean matched = false;
	
	// constructor of Union
	public Union(RelationalAlgebra left, RelationalAlgebra right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public Relation getResult() {
		Relation left = this.left.getResult();
		Relation right = this.right.getResult();
		Relation result = new Relation(left.getAttributes());
		int numberOfAttributesRight = right.getAttributes().size();
		int numberOfAttributesLeft = left.getAttributes().size();
		
		
		// check count of attributes in every relation
		if(numberOfAttributesLeft == numberOfAttributesRight) {
			//Compare the contents of the attributes			
			checkAttributesNames(left.getAttributes(), right.getAttributes());
		}else { 
			System.out.println("Number of attributes of both relations is unequal!");
		}
			if(matched) {
				for(Tuple tl : left.getTuples()) {
					result.addTuple(tl);
				}
				for(Tuple tr : right.getTuples()) {
					result.addTuple(tr);
				}
			}
		return result;
	}

	@Override
	public String toText(String indent, boolean results) {
		String res = super.toText(indent, results);
		res += indent + "(";
		res += "\n" + left.toText(indent + "  ", results);
		res += "\n" + indent + "  Union _{  UN  }";
		res += "\n" + right.toText(indent + "  ", results);
		res += "\n" + indent + ")";
		return res;
	}

	@Override
	public void checkAttributesNames(List<Attribute> left , List <Attribute> right) {
		
		for(int i = 0; i < left.size(); i++) {
			if(!left.get(i).getName().toUpperCase().equals(right.get(i).getName().toUpperCase())) {
				System.out.println("A union is not possible, because the relations have different schemes ");
				matched = false;
				break;
			}
			matched =true;
		}
	}
	
}
