package de.hsh.genrelalg.antlr.expression;

import de.hsh.genrelalg.data.Predicate;
import de.hsh.genrelalg.expr.BooleanExpression;
import de.hsh.genrelalg.expr.ExprAnd;
import de.hsh.genrelalg.expr.ExprIsNot;
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
		BooleanExpression p = null;
			if(ctx.getChildCount() == 1) {
				p = visit(ctx.predicate());
				return p;
			}else {
				if(ctx.getChild(1).getText().equals("&")) {
					ExprAnd and  = new ExprAnd(visit(ctx.predicate()), visit(ctx.subPredicate()));
					return and;
				}else if (ctx.getChild(0).getText().equals("<>")){
					ExprIsNot isnot = new ExprIsNot(visit(ctx.conditions()));
					return isnot;
				}else {
					p = visit(ctx.conditions());
					return p;
				}
			}
	}

	@Override
	public BooleanExpression visitConditions(ConditionsContext ctx) {
		
		if(ctx.getChildCount() == 1) {
			BooleanExpression p  = visit(ctx.subPredicate());
			return p;
		}else {
			ExprOr or = new ExprOr(visit(ctx.subPredicate()),visit(ctx.conditions()));
			return or;
		}
	}
	
	@Override
	public BooleanExpression visitPredicate(PredicateContext ctx) {
		Predicate p = new Predicate(ctx.attribut(0).getText(), ctx.comparator().getText() ,ctx.attribut(1).getText());
		return p.getExpression();
	}
	
	
}