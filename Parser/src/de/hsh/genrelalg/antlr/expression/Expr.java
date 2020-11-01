package de.hsh.genrelalg.antlr.expression;

import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.relalg.RelationalAlgebra;

public interface Expr {

	public RelationalAlgebra getBase();
	public Relation getResult();
}
