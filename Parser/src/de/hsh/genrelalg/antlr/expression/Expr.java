package de.hsh.genrelalg.antlr.expression;

import java.util.List;
import de.hsh.genrelalg.data.Relation;

/* a model class for expression */
public abstract class Expr{

	public abstract String getName();
	public abstract String getBase();
	public abstract List<String> getAttributes();
	public abstract String printSomething();
	public abstract Relation getRelation();
	public abstract void setRelation(Relation r);
	
}
