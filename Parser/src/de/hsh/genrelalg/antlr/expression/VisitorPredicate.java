package de.hsh.genrelalg.antlr.expression;

import de.hsh.genrelalg.data.Predicate;
import de.hsh.genrelalg.parser.RelAlgebraBaseVisitor;
import de.hsh.genrelalg.parser.RelAlgebraParser.Predicate_Context;

public class VisitorPredicate extends RelAlgebraBaseVisitor<Predicate>{

	@Override
	public Predicate visitPredicate_(Predicate_Context ctx) {
		Predicate p = new Predicate(ctx.attribut(0).getText(), ctx.comparator().getText() ,ctx.attribut(1).getText());
		return p;
	}

	
	
}
