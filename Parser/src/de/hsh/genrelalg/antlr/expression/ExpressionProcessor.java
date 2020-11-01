package de.hsh.genrelalg.antlr.expression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionProcessor {

	List<Expr> list;
	
	public Map<String, Integer> values;
	
	public ExpressionProcessor(List<Expr> list) {
		this.list = list;
		values = new HashMap<>();
		
	}
}
