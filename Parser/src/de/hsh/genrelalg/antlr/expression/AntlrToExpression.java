package de.hsh.genrelalg.antlr.expression;

import java.util.ArrayList;
import java.util.List;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.database.DBFactory;
import de.hsh.genrelalg.expr.ExpGreater;
import de.hsh.genrelalg.expr.ExprAttribute;
import de.hsh.genrelalg.expr.ExprConstant;
import de.hsh.genrelalg.expr.ExprEquals;
import de.hsh.genrelalg.parser.RelAlgebraBaseVisitor;
import de.hsh.genrelalg.parser.RelAlgebraParser.AttributContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.CarstesianContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.EOFContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Join_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.NestedContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Predicate_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.ProjectionContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.SelectContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.SelectionContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.SimpleContext;
import de.hsh.genrelalg.relalg.Projection;
import de.hsh.genrelalg.relalg.RelationalAlgebra;
import de.hsh.genrelalg.relalg.Selection;
import de.hsh.genrelalg.relalg.Carstesian;
import de.hsh.genrelalg.relalg.Join;

/* visitor class of the expression rule
 * here we will instantiate this to an expression <Expr>
 */
public class AntlrToExpression extends RelAlgebraBaseVisitor<Relation>{
	
	
	public AntlrToExpression() {
	
	}


	@Override
	public Relation visitEOF(EOFContext ctx) {
		return super.visitEOF(ctx);
	}

	

	@Override
	public Relation visitCarstesian(CarstesianContext ctx) {
		Relation relationLeft = visit(ctx.cartesian().relation(0));
		Relation relationRight = visit(ctx.cartesian().relation(1));
		Carstesian carstesian = new Carstesian(relationLeft,relationRight, 12);
		writeOutput(carstesian, "Test Carstesian: ");
		return carstesian.getResult();
	}

	@Override
	public Relation visitPredicate_(Predicate_Context ctx) {
		return super.visitPredicate_(ctx);
	}

	@Override
	public Relation visitSelect(SelectContext ctx) {
		return super.visitSelect(ctx);
	}

	@Override
	public Relation visitAttribut(AttributContext ctx) {
		System.out.println("Jooo visit Attribut is here");
		String attributeName = ctx.getText();
		System.out.println("Name of Attribut in visitAttribut is: " +attributeName);
		System.out.println(ctx.getParent().getText());
		//Attribut attribut = DBFactory.getAttributesByName(visit(ctx.par), expression);
		return super.visitAttribut(ctx);
	}

	
	/* this method is visited, if the relation is a simple relation name */
	@Override
	public Relation visitSimple(SimpleContext ctx) {
		String relationName = ctx.getText();
		Relation relation = DBFactory.getRelationByName(relationName);
		return relation;
	}

	/* this method is visited, if the relation is an Expression  
	 * Here visit.expr is called to visit the expression in the relation
	 * 
	 */
	@Override
	public Relation visitNested(NestedContext ctx) {
		Relation relation = super.visit(ctx.expr());
		return relation;
	}

	/*
	 *  Implementation of join operation
	 */
	@Override
	public Relation visitJoin_(Join_Context ctx) {
	
		
		List<String> attributes = new ArrayList<>();
		
		// variables to save the input
		String leftExpr = ctx.join().predicate().getChild(1).getText();
		String rightExpr = ctx.join().predicate().getChild(3).getText();
		attributes.add(leftExpr.substring(leftExpr.indexOf(".")+1, leftExpr.length()));
		attributes.add(rightExpr.substring(rightExpr.indexOf(".")+1, rightExpr.length()));
		String relationLeftName = leftExpr.substring(0, leftExpr.indexOf("."));
		String relationRightName = rightExpr.substring(0, rightExpr.indexOf("."));	
		Relation relationLeft = visit(ctx.join().relation().get(0));
		Relation relationRight = visit(ctx.join().relation().get(1));
		
		// initial a join Operation  
		Join join = new Join(relationLeft, relationRight,
				new ExprEquals(new ExprAttribute(relationLeftName, attributes.get(0)),  new ExprAttribute(relationRightName, attributes.get(1))), 16
				,false,false);
		writeOutput(join, "Test Join: ");
		return join.getResult();
	}

	/*
	 * Implementation of selection operation
	 */
	@Override
	public Relation visitSelection(SelectionContext ctx) {
		String attributeName = ctx.select().predicate().getChild(1).getText();
		String value = ctx.select().predicate().getChild(3).getText();
		String comperator = ctx.select().predicate().getChild(2).getText();
		System.out.println("Comperator: " + comperator);
		/*
		 * if(comperator.equals("<")) --> ExprLess
		 * if else(comperator.equlas(">")) --> ExprGreater
		 * else --> ExprEquals
		 * */
		Relation relation = visit(ctx.select().relation());
		Selection selection = new Selection(relation, new ExprEquals(new ExprAttribute(attributeName.toUpperCase()), new ExprConstant(value)));
		writeOutput(selection, "Test Selection");
		return selection.getResult();
	}

	/* visit projection method */
	@Override
	public Relation visitProjection(ProjectionContext ctx) {
		// name of operation
		String name = ctx.project().PROJECT().getText();
		// list of all attributes
		List<String> atts = new ArrayList<>();
		for(int i = 0 ; i < ctx.project().attribut().size(); i++) {
			String a = ctx.project().attribut(i).getText();
			atts.add(a.substring(a.indexOf(".")+1, a.length()));
		}
		String relation = ctx.project().relation().getText();
		Project project = new Project(name, relation, atts);
		Relation relationObj = visit(ctx.project().relation());
		Attribute [] attributObj = new Attribute[project.getAttributes().size()];
		attributObj = DBFactory.getAttributesByName(relationObj, project);
		Projection projection = new Projection(relationObj,attributObj);
		writeOutput(projection, "Test Projektion");
		return projection.getResult();
	}


	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("Aufgabe: " + task + "\n");		
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}

}