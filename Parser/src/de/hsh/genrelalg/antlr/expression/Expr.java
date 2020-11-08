package de.hsh.genrelalg.antlr.expression;

import java.util.List;


/* a model class for expression */
public abstract class Expr {

	public abstract String getName();
	public abstract String getBase();
	public abstract List<String> getAttributes();
	
	public abstract String printSomething();
	
}
