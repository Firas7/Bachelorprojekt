package de.hsh.genrelalg.antlr.expression;

import de.hsh.genrelalg.data.Predicate;
import de.hsh.genrelalg.expr.BooleanExpression;
import de.hsh.genrelalg.expr.ExprAnd;
import de.hsh.genrelalg.expr.ExprOr;
import de.hsh.genrelalg.parser.RelAlgebraBaseVisitor;
import de.hsh.genrelalg.parser.RelAlgebraParser.ConditionsContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.PredicateContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.SubPredicateContext;

public class VisitorPredicate extends RelAlgebraBaseVisitor<BooleanExpression>{


	public  VisitorPredicate() {
		
	}
	@Override
	public BooleanExpression visitSubPredicate(SubPredicateContext ctx) {
		System.out.println("SubPredicate");
		BooleanExpression p = null;
			if(ctx.getChildCount() == 1) {
				p = visit(ctx.predicate());
				System.out.println("+++++ "+ p.toText());
				return p;
			}else {
				if(ctx.getChild(1).getText().equals("&")) {
					System.out.println("AND");
					ExprAnd and  = new ExprAnd(visit(ctx.predicate()), visit(ctx.subPredicate()));
					System.out.println("AND Expression: " + and.toText());
					return and;
				}else {
					p = visit(ctx.conditions());
					System.out.println("Condition boolean: " + p.toText());
					return p;
				}
			}
	}

	@Override
	public BooleanExpression visitConditions(ConditionsContext ctx) {
		System.out.println("Conditions");
		
		if(ctx.getChildCount() == 1) {
			BooleanExpression p  = visit(ctx.subPredicate());
			return p;
		}else {
			System.out.println("OR muss erstellt werden");
			ExprOr or = new ExprOr(visit(ctx.subPredicate()),visit(ctx.conditions()));
			System.out.println("OR Expression: " + or.toText());
			return or;
		}
	}
	
	@Override
	public BooleanExpression visitPredicate(PredicateContext ctx) {
		System.out.println("Predicate");
		Predicate p = new Predicate(ctx.attribut(0).getText(), ctx.comparator().getText() ,ctx.attribut(1).getText());
		System.out.println("Predicate in visitPredicate: " + p.getExpression().toText());
		return p.getExpression();
	}
	
}
