package de.hsh.genrelalg.antlr.expression;

import de.hsh.genrelalg.parser.RelAlgebraBaseVisitor;
import de.hsh.genrelalg.parser.RelAlgebraParser.ProgramContext;

/* visitor class of the program rule 
 * here we will instantiate this to a program <Program>
 * */

public class AntlrToProgram extends RelAlgebraBaseVisitor<Program>{

	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog = new Program();
		// helper visitor for transforming each subtree into an Expression object
		AntlrToExpression exprVisitor = new AntlrToExpression();
		for (int i = 0; i < ctx.getChildCount(); i++) {
			if(ctx.getChildCount() == 0) {
				System.out.println("Answer of student doesn't exist");
				System.exit(0);
			}else {
				prog.setResult(exprVisitor.visit(ctx.getChild(i)));
			}
		}
		
		return prog;
	}
	
	
}
