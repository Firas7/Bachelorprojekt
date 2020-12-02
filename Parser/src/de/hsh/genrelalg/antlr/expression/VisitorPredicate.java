package de.hsh.genrelalg.antlr.expression;


import de.hsh.genrelalg.data.Predicate;
import de.hsh.genrelalg.parser.RelAlgebraBaseVisitor;
import de.hsh.genrelalg.parser.RelAlgebraParser.PredicateContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.SubPredicateContext;
import de.hsh.genrelalg.relalg.AND;

public class VisitorPredicate extends RelAlgebraBaseVisitor<Predicate>{


	@Override
	public Predicate visitSubPredicate(SubPredicateContext ctx) {
		Predicate p = null;
		AND and = null;
		System.out.println("Anzahl Kinder in SubPreidcate:" + ctx.getChildCount());
			if(ctx.getChildCount() == 1) {
				p = visit(ctx.predicate());
				return p;
			}else if(ctx.getChildCount()==3) {
				if(ctx.getChild(1).getText().equals("&")) {
					System.out.println("AND muss erstellt werden.");
					//and = new AND(visit(ctx.predicate()), visit(ctx.subPredicate()));
					System.out.println("Left Predicate in AND: " + p.getLeftPredicate().getExpression().toText());
					System.out.println("Right Predicate in AND: " + p.getRightPredicate().getExpression().toText());
				}else {
					p = visit(ctx.conditions());
				}
			}
		return p;
	}

	@Override
	public Predicate visitPredicate(PredicateContext ctx) {
		Predicate p = new Predicate(ctx.attribut(0).getText(), ctx.comparator().getText() ,ctx.attribut(1).getText());
		System.out.println("Predicate in visitPredicate: " + p.getExpression().toText());
		return p;
	}

	
	
}
