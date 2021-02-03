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


public class AntlrToExpression extends RelAlgebraBaseVisitor<Relation>{
	
	VisitorPredicate visitorPredicate = new VisitorPredicate();
	
	public AntlrToExpression() {
		
	}
	
	/* Implementierung der Rename Operation */
	@Override
	public Relation visitRename_(Rename_Context ctx) {
		Relation relation = visit(ctx.rename().relation());
		String newName = ctx.rename().ID().getText();
		Rename rename = new Rename(relation,newName);
		//writeOutput(rename, "Rename: ");
		return rename.getResult();
	}


	/* Implementierung der Differenz Operation */
	@Override
	public Relation visitDifference_(Difference_Context ctx) {
		Relation left =  visit(ctx.difference().relation(0));
		Relation right =  visit(ctx.difference().relation(1));
		SetMinus difference = new SetMinus(left, right, 16);
		//writeOutput(difference, "Difference :");
		return difference.getResult();
	}

	/* Implementierung des kartesischen Produkt */
	@Override
	public Relation visitCarstesian(CarstesianContext ctx) {
		Relation relationLeft = visit(ctx.cartesian().relation(0));
		Relation relationRight = visit(ctx.cartesian().relation(1));
		Carstesian carstesian = new Carstesian(relationLeft,relationRight, 12);
		//writeOutput(carstesian, "Carstesian :");
		return carstesian.getResult();
	}
	
	/* 
	 * Diese Methode wird besucht, wenn die eingegebene Relation eine konkrete Relation aus der DB ist.
	 */
	@Override
	public Relation visitSimple(SimpleContext ctx) {
		String relationName = ctx.getText();
		Relation relation = DBFactory.getRelationByName(relationName.toUpperCase());
		return relation;
	}

	/* 
	 * Diese Methode wird besucht, wenn die Relation eine weitere Operation ist
	 */
	@Override
	public Relation visitNested(NestedContext ctx) {
		return super.visit(ctx.expr());
	}

	/*
	 *  Implementierung der Join Operation
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
	 * Implementierung der Vereinigung
	 */
	@Override
	public Relation visitUnion_(Union_Context ctx) {
		Relation left = visit(ctx.union().relation(0));
		Relation right = visit(ctx.union().relation(1));
		Union union = new Union(left,right);
		//writeOutput(union, "Union :");
		return union.getResult();
	}


	/* Implementierung des Durchschnittes */
	@Override
	public Relation visitIntersection_(Intersection_Context ctx) {
		Relation left = visit(ctx.intersection().relation(0));
		Relation right = visit(ctx.intersection().relation(1));
		Intersection intersection = new Intersection(left,right);
		//writeOutput(intersection, "Intersection :");
		return intersection.getResult();
	}

	/*
	 * Implementierung der Selektion
	 */
	@Override
	public Relation visitSelection(SelectionContext ctx) {
		Relation relation = visit(ctx.select().relation());
		BooleanExpression bol = visitorPredicate.visit(ctx.select().conditions());
		Selection selection = new Selection(relation,bol);
		//writeOutput(selection, "Selection :");
		return selection.getResult();

	}


	/* Implementierung der Projektion */
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

	/*
	 * Diese Methode gibt das Ergebnis jeder ausgeführten Operation aus.
	 */
	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("performed operation " + task + "\n");
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}

}