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


	@Override
	public BooleanExpression visitSubPredicate(SubPredicateContext ctx) {
		System.out.println("SubPredicate");
		Predicate p = new Predicate();
		
		System.out.println("Anzahl Kinder in SubPreidcate:" + ctx.getChildCount());
			if(ctx.getChildCount() == 1) {
				p.setBooleanexprisson(visit(ctx.predicate()));
				return p.getBooleanExpression();
			}else if(ctx.getChildCount()==3) {
				if(ctx.getChild(1).getText().equals("&")) {
					System.out.println("AND muss erstellt werden.");
					ExprAnd and  = new ExprAnd(visit(ctx.predicate()), visit(ctx.subPredicate()));
					return and;
				}else {
					p.setBooleanexprisson(visit(ctx.conditions()));
				}
			}
		return p.getExpression();
	}

	@Override
	public BooleanExpression visitPredicate(PredicateContext ctx) {
		System.out.println("Predicate");
		Predicate p = new Predicate(ctx.attribut(0).getText(), ctx.comparator().getText() ,ctx.attribut(1).getText());
		System.out.println("Predicate in visitPredicate: " + p.getExpression().toText());
		return p.getExpression();
	}

	@Override
	public BooleanExpression visitConditions(ConditionsContext ctx) {
		System.out.println("Conditions");
		Predicate p = new Predicate();
		if(ctx.getChildCount() == 1) {
			p.setBooleanexprisson(visit(ctx.subPredicate()));
			return p.getExpression();
		}else if (ctx.getChildCount() == 3) {
			System.out.println("OR muss erstellt werden");
			ExprOr or = new ExprOr(visit(ctx.subPredicate()),visit(ctx.conditions()));
			return or;
		}
		return p.getExpression();
	}

	
	
}
