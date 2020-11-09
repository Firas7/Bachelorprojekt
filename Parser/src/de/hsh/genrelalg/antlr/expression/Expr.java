package de.hsh.genrelalg.antlr.expression;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.relalg.RelationalAlgebra;

/* a model class for expression */
public abstract class Expr extends RelationalAlgebra{

	public abstract String printSomething();
	public abstract RelationalAlgebra getRelation();
	@Override
	public Relation getResult() {
		return this.getResult();
	}
	
	public abstract List<Attribute> getAttributes();
}
