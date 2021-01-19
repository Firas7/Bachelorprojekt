package de.hsh.genrelalg.antlr.expression;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.database.DBFactory;
import de.hsh.genrelalg.expr.BooleanExpression;
import de.hsh.genrelalg.parser.RelAlgebraBaseVisitor;
import de.hsh.genrelalg.parser.RelAlgebraParser.CarstesianContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Difference_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.Intersection_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.Join_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.NestedContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.ProjectionContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Rename_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.SelectionContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.SimpleContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Union_Context;
import de.hsh.genrelalg.relalg.Projection;
import de.hsh.genrelalg.relalg.RelationalAlgebra;
import de.hsh.genrelalg.relalg.Rename;
import de.hsh.genrelalg.relalg.Selection;
import de.hsh.genrelalg.relalg.SetMinus;
import de.hsh.genrelalg.relalg.Union;
import de.hsh.genrelalg.relalg.Carstesian;
import de.hsh.genrelalg.relalg.Intersection;
import de.hsh.genrelalg.relalg.Join;

/* visitor class of the expression rule
 * here we will instantiate this to an expression <Expr>
 */

public class AntlrToExpression extends RelAlgebraBaseVisitor<Relation>{
	
	VisitorPredicate visitorPredicate = new VisitorPredicate();
	
	public AntlrToExpression() {
		
	}
	
	/* Implementation of Rename Operation */
	@Override
	public Relation visitRename_(Rename_Context ctx) {
		Relation relation = visit(ctx.rename().relation());
		String newName = ctx.rename().ID().getText();
		Rename rename = new Rename(relation,newName);
		//writeOutput(rename, "Rename: ");
		return rename.getResult();
	}


	/* Implementation of Difference Operation */
	@Override
	public Relation visitDifference_(Difference_Context ctx) {
		Relation left =  visit(ctx.difference().relation(0));
		Relation right =  visit(ctx.difference().relation(1));
		SetMinus difference = new SetMinus(left, right, 16);
		//writeOutput(difference, "Difference :");
		return difference.getResult();
	}

	/* Implementation of Carstesian Operation */
	@Override
	public Relation visitCarstesian(CarstesianContext ctx) {
		Relation relationLeft = visit(ctx.cartesian().relation(0));
		Relation relationRight = visit(ctx.cartesian().relation(1));
		Carstesian carstesian = new Carstesian(relationLeft,relationRight, 12);
		//writeOutput(carstesian, "Carstesian :");
		return carstesian.getResult();
	}
	
	/* this method is visited, if the relation is a simple relation name */
	@Override
	public Relation visitSimple(SimpleContext ctx) {
		String relationName = ctx.getText();
		Relation relation = DBFactory.getRelationByName(relationName.toUpperCase());
		return relation;
	}

	/* this method is visited, if the relation is an Expression  
	 * Here visit.expr is called to visit the expression in the relation
	 * 
	 */
	@Override
	public Relation visitNested(NestedContext ctx) {
		return super.visit(ctx.expr());
	}

	/*
	 *  Implementation of join operation
	 */
	@Override
	public Relation visitJoin_(Join_Context ctx) {
				
		// variables to save the input
		BooleanExpression booelanExpr = visitorPredicate.visit(ctx.join().conditions());
		
		Relation relationLeft = visit(ctx.join().relation().get(0));
		Relation relationRight = visit(ctx.join().relation().get(1));
		
		// initial a join Operation  
		Join join = new Join(relationLeft,relationRight,booelanExpr,12,false,false);
		if(ctx.join().var().getText().toUpperCase().equals("F")) {
			join = new Join(relationLeft, relationRight,
					 booelanExpr, 12,true,true);
		}if(ctx.join().var().getText().toUpperCase().equals("R")) {
			join = new Join(relationLeft, relationRight,
					booelanExpr, 12,false,true);
		}if(ctx.join().var().getText().toUpperCase().equals("L")) {
			join = new Join(relationLeft, relationRight,
					booelanExpr,12,true,false);
		}
		//writeOutput(join, "Join :");
		return join.getResult();
	}

	/*
	 * Implementation of Union operation
	 * */
	@Override
	public Relation visitUnion_(Union_Context ctx) {
		Relation left = visit(ctx.union().relation(0));
		Relation right = visit(ctx.union().relation(1));
		Union union = new Union(left,right);
		//writeOutput(union, "Union :");
		return union.getResult();
	}


	/* Implementation of Intersection Operation */
	@Override
	public Relation visitIntersection_(Intersection_Context ctx) {
		Relation left = visit(ctx.intersection().relation(0));
		Relation right = visit(ctx.intersection().relation(1));
		Intersection intersection = new Intersection(left,right);
		//writeOutput(intersection, "Intersection :");
		return intersection.getResult();
	}

	/*
	 * Implementation of selection operation
	 */
	@Override
	public Relation visitSelection(SelectionContext ctx) {

		Relation relation = visit(ctx.select().relation());
		BooleanExpression bol = visitorPredicate.visit(ctx.select().conditions());
		Selection selection = new Selection(relation,bol);
		//writeOutput(selection, "Selection :");
		return selection.getResult();

	}


	/* Implementation of Projection Operation */
	@Override
	public Relation visitProjection(ProjectionContext ctx) {

		Attribute [] attributObj = new Attribute[ctx.project().attribut().size()];
		Projection projection =  null;
		Relation relationObj = visit(ctx.project().relation());
		for(int i=0 ;i<ctx.project().attribut().size(); i++) {	
			if(ctx.project().attribut().get(i).getText().contains(".")) {
				attributObj[i] = new Attribute(ctx.project().attribut().get(i).getChild(0).getText().toUpperCase(), ctx.project().attribut().get(i).getChild(2).getText().toUpperCase());
			} else {
				attributObj[i] = new Attribute (ctx.project().attribut(i).getText().toUpperCase());
			}
		}
		projection = new Projection(relationObj,attributObj);
		//writeOutput(projection, "Projection :");
		return projection.getResult();
	}

	
	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("performed operation " + task + "\n");
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}

}