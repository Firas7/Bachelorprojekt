package de.compiler.tester;

import de.compiler.tester.GramParser.AdditionContext;
import de.compiler.tester.GramParser.PlusContext;
import de.compiler.tester.GramParser.ZahlContext;

public class MyVisitor extends GramBaseVisitor<String>{

	
	@Override
	public String visitPlus(PlusContext ctx) {
		return visitChildren(ctx) + "\n" +
			ctx.rechts.getText() + "\n" +
			"addition";
	}
	
	@Override
	public String visitZahl(ZahlContext ctx) {
		return ctx.zahl.getText(); 
	}
	
	
	// aggregate beschreibt ein vorhandenes Ergebnis und nextResult ist ein Ergebnis, was hinzugefügt werden soll
	
	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		if(aggregate == null) {
			return nextResult;
		}if(nextResult == null) {
			return aggregate;
		}
		
		return aggregate + "\n" + nextResult;
	}
	
	
	
	// Die Konstruktur bekommt einen ParseTree von der main Klasse
	/*@Override
	public String visitAddition(AdditionContext ctx) {
		// Kindknoten durchgehen mit Post-Order: also zuerst den Kindknoten durchgehen dann den Wurzelknoten
		
		visitChildren(ctx);
		if(ctx.getChildCount() == 1) {
			
		}else {
			
		}
		return null;
	}*/
}
