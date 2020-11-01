package de.hsh.genrelalg.antlr.expression;

import de.compiler.parser.RelAlgebraBaseVisitor;
import de.compiler.parser.RelAlgebraParser.ProgramContext;

public class AntlrToProgram extends RelAlgebraBaseVisitor<Program>{

	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog = new Program();
		// helper visitor to transforming each subtree into an Expression object
		AntlrToExpression exprVisitor = new AntlrToExpression();
		for (int i = 0; i < ctx.getChildCount(); i++) {
			if(i == ctx.getChildCount()) {
				/* last child of the start symbol prog is EOF*/
				// Do not visit this child and attempt to convert it to an Expression object
			}else {
				prog.addExpression(exprVisitor.visit(ctx.getChild(i)));
				System.out.println("List: "+ prog.getExpressions().get(0));
			}
		}
		return prog;
	}
	
	
}
