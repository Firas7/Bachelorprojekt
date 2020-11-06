package de.hsh.genrelalg.antlr.expression;

import java.util.ArrayList;
import java.util.List;

/* a model class for a program 
 * 
 * */
public class Program {
	
	public List<Expr> expressions;
	
	public Program() {
		this.expressions = new ArrayList<>();
	}
	
	public void addExpression(Expr exp) {
		expressions.add(exp);
	}
	
	public List<Expr> getExpressions(){
		return this.expressions;
	}
}
