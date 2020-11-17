package de.hsh.genrelalg.antlr.expression;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Relation;

/* a model class for a program 
 * 
 * */
public class Program {
	
	public List<Relation> expressions;
	
	public Program() {
		this.expressions = new ArrayList<>();
	}
	
	public void addExpression(Relation exp) {
		expressions.add(exp);
	}
	
	public List<Relation> getExpressions(){
		return this.expressions;
	}
}
