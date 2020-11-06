package de.hsh.genrelalg.relalg;

import java.util.LinkedList;
import java.util.List;

import de.hsh.genrelalg.antlr.expression.Expr;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;

public class Projection extends Expr{

	List<Attribute> attributes = new LinkedList<>();
	RelationalAlgebra base;
	
	/* this constructor will get a list of attributes and a base and both have the type String */
	public Projection() {
		
	}

	public Projection(RelationalAlgebra base, Attribute ... attributes) {
		this.base = base;
		for (Attribute att : attributes)
			this.attributes.add(att);
	}
	
	@Override
	public Relation getResult() {
		Relation rbase = base.getResult();
		Relation result = new Relation();
		int [] indices = new int[attributes.size()]; 
		int j = 0;
		for (Attribute attribute : attributes) {
			boolean ok = false;
			for (int i = 0; i < rbase.getAttributes().size(); i++) {
				if (rbase.getAttributes().get(i).equals(attribute)) {
					ok = true;
					indices[j++] = i;
					result.addAttribute(rbase.getAttributes().get(i));	
				}
			}
			if (!ok) {
				result.addAttribute(attribute);
				indices[j++] = -1;
			}
		}
		
		for (Tuple t : rbase.getTuples()) {
			Tuple pt = new Tuple();
			for (j = 0; j < indices.length; j++) {
				if (indices[j] >= 0)
					pt.addField(t.getField(indices[j]));
				else
					pt.addField("UNKNOWN");
			}
			result.addTuple(pt);
		}
		
		return result;
	}

	@Override
	public String toText(String indent, boolean results) {
		String res = super.toText(indent, results);
		res += indent + "project_{";
		for (int i = 0; i < attributes.size(); i++) {
			if (i > 0)
				res += ",";
			res += attributes.get(i).toText();
		}
		res += "} (";
		res += "\n" + base.toText(indent + "  ", results);
		res += "\n" + indent + ")";
		return res;
	}
	
	@Override
	public RelationalAlgebra getRelation(){
		return this.base;
	}

	@Override
	public String printSomething() {
		// TODO Auto-generated method stub
		return "Here is a proejktion";
	}

	
}
