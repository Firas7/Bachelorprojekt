package de.compiler.parser;

import de.compiler.parser.RelAlgebraParser.ExpressionContext;


public class MyVisitor extends RelAlgebraBaseVisitor{

	@Override
	public Object visitExpression(ExpressionContext ctx) {
		// TODO Auto-generated method stub
		for(int i = 0; i < ctx.getChildCount(); i++) {
			System.out.println(ctx.getChild(i));
		}
		
		
		return null;
	}
}
