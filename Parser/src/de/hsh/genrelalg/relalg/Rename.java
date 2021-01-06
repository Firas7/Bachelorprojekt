package de.hsh.genrelalg.relalg;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;

public class Rename extends RelationalAlgebra {

	RelationalAlgebra base;
	String name;
	String attributeName;
	boolean changeAttribut = false;

	public Rename(RelationalAlgebra base, String name) {
		this.base = base;
		this.name = name;
	}
	
	public Rename(RelationalAlgebra base, String name, String attributeName) {
		this.base = base;
		this.name = name;
		this.attributeName = attributeName;
		this.changeAttribut = true;
	}
	
	@Override
	public Relation getResult() {
		Relation rbase = base.getResult();
		Relation result = new Relation();
	
			for (Attribute att : rbase.getAttributes()) {
				if(!changeAttribut) {
					result.setName(name);
					result.addAttribute(new Attribute(name, att.getName()));
				}else {
					System.out.println("Attribut muss geändert werden " + this.attributeName);
				}
			}
 		for (Tuple t : rbase.getTuples()) {
			result.addTuple(t);
		}
		return result;
	}

	@Override
	public String toText(String indent, boolean results) {
		String res = super.toText(indent, results);
		res += indent + "rename_{" + name + "} (";
		res += "\n" + base.toText(indent + "  ", results);
		res += "\n" + indent + ")";
		return res;
	}

	@Override
	public void checkAttributesDataTypes(List<Attribute> left, List<Attribute> right) {
		// TODO Auto-generated method stub
		
	}
	

}
