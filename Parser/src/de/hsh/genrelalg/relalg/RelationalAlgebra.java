package de.hsh.genrelalg.relalg;

import de.hsh.genrelalg.data.Relation;

public abstract class RelationalAlgebra {

	public abstract Relation getResult();

	public String toText(String indent, boolean results) {
		if (results)
			return getResult().contentToText(indent) + "\n";
		return "";
	}
	public abstract String getName();
}
