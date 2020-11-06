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
			if(i == ctx.getChildCount()) {
				/* last child of the start symbol prog is EOF*/
				// Do not visit this child and attempt to convert it to an Expression object
				System.out.println("Program has no Input");
			}else {
				prog.addExpression(exprVisitor.visit(ctx.getChild(i)));
				System.out.println("OUTPUT LIST: "+ prog.getExpressions().get(i).getResult().toText("", true));
			}
		}
		return prog;
	}
	
	
}
