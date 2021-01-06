package de.hsh.genrelalg.relalg;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;

public abstract class RelationalAlgebra {

	public abstract Relation getResult();
	public abstract void checkAttributesDataTypes(List<Attribute> left , List <Attribute> right);
	public String toText(String indent, boolean results) {
		if (results)
			return getResult().contentToText(indent) + "\n";
		return "";
	}
}
