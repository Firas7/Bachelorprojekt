package de.hsh.genrelalg.antlr.expression;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.parse.ANTLRParser.parserRule_return;
import org.antlr.v4.runtime.ParserRuleContext;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.database.DBFactory;
import de.hsh.genrelalg.expr.BooleanExpression;
import de.hsh.genrelalg.expr.ExprGreater;
import de.hsh.genrelalg.expr.ExprGreaterEquals;
import de.hsh.genrelalg.expr.ExprAttribute;
import de.hsh.genrelalg.expr.ExprConstant;
import de.hsh.genrelalg.expr.ExprEquals;
import de.hsh.genrelalg.expr.ExprLess;
import de.hsh.genrelalg.expr.ExprLessEquals;
import de.hsh.genrelalg.parser.RelAlgebraBaseVisitor;
import de.hsh.genrelalg.parser.RelAlgebraParser.AttributContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.CarstesianContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Difference_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.EOFContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Intersection_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.Join_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.NestedContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Predicate_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.ProjectionContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.RelationContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Rename_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.SelectContext;
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
	
	
	/* Implementation of Rename Operation */
	@Override
	public Relation visitRename_(Rename_Context ctx) {
		String relationName = ctx.rename().relation().getText();
		Relation relation = visit(ctx.rename().relation());
		String newName = ctx.rename().ID().getText();
		Rename rename = new Rename(relation,newName);
		System.err.println(rename.getResult().toText("", true));
		writeOutput(rename, "Test Rename: ");
		return rename.getResult();
	}


	/* Implementation of Difference Operation */
	@Override
	public Relation visitDifference_(Difference_Context ctx) {
		Relation left =  visit(ctx.difference().relation(0));
		Relation right =  visit(ctx.difference().relation(1));
		SetMinus difference = new SetMinus(left, right, 16);
		writeOutput(difference, "Test Difference ");
		return difference.getResult();
	}


	public AntlrToExpression() {
	
	}


	@Override
	public Relation visitEOF(EOFContext ctx) {
		return super.visitEOF(ctx);
	}

	

	/* Implementation of Carstesian Operation */
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

/*	@Override
	public Relation visitAttribut(AttributContext ctx) {
		System.out.println("Jooo visit Attribut is here");
		String attributeName = ctx.getText();
		System.out.println("Name of Attribut in visitAttribut is: " +attributeName);
		System.out.println(ctx.getParent().getText());
		//Attribut attribut = DBFactory.getAttributesByName(visit(ctx.par), expression);
		return super.visitAttribut(ctx);
	}x

	
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
		String leftExpr = ctx.join().predicate().getChild(0).getText();
		String rightExpr = ctx.join().predicate().getChild(2).getText();
		attributes.add(leftExpr.substring(leftExpr.indexOf(".")+1, leftExpr.length()));
		attributes.add(rightExpr.substring(rightExpr.indexOf(".")+1, rightExpr.length()));
		String comperator = ctx.join().predicate().getChild(1).getText();
		if(!comperator.equals("=")) {
			System.out.println("the comperator in Join between to Relations must be '=' ");
			System.exit(-1);
		}
		String relationLeftName = leftExpr.substring(0, leftExpr.indexOf("."));
		String relationRightName = rightExpr.substring(0, rightExpr.indexOf("."));	
		Relation relationLeft = visit(ctx.join().relation().get(0));
		Relation relationRight = visit(ctx.join().relation().get(1));
		
		// initial a join Operation  
		Join join = new Join(relationLeft, relationRight,
				new ExprEquals(new ExprAttribute(relationLeftName, attributes.get(0).toUpperCase()),  new ExprAttribute(relationRightName, attributes.get(1).toUpperCase())), 16
				,false,false);
		writeOutput(join, "Test Join: ");
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
		writeOutput(union, "Test Union");
		return union.getResult();
	}


	/* Implementation of Intersection Operation */
	@Override
	public Relation visitIntersection_(Intersection_Context ctx) {
		Relation left = visit(ctx.intersection().relation(0));
		Relation right = visit(ctx.intersection().relation(1));
		Intersection intersection = new Intersection(left,right);
		writeOutput(intersection, "Test Intersection ");
		return intersection.getResult();
	}


	/*
	 * Implementation of selection operation
	 */
	@Override
	public Relation visitSelection(SelectionContext ctx) {
		
		Relation relation = visit(ctx.select().relation());
		Selection selection = null;

		@SuppressWarnings("unused")
		BooleanExpression expr = null;
		for(int i = 0; i < ctx.select().predicate().size(); i++) {
			if(ctx.select().predicate(i).getChild(1).getText().equals(">")) {
				expr = new ExprGreater(new ExprAttribute(ctx.select().predicate(i).getChild(0).getText().toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
				selection = new Selection(relation,expr);
				writeOutput(selection, "Test Selection: ");
			}else if(ctx.select().predicate(i).getChild(1).getText().equals("<")) {
				expr = new ExprLess(new ExprAttribute(ctx.select().predicate(i).getChild(0).getText().toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
				selection = new Selection(relation,expr);
				writeOutput(selection, "Test Selection: ");
			}else if(ctx.select().predicate(i).getChild(1).getText().equals("=")) {
				System.out.println("Attribute: "+ ctx.select().predicate(i).getChild(0).getText());
				System.out.println("Value: " + ctx.select().predicate(i).getChild(2).getText());
				expr = new ExprEquals(new ExprAttribute(ctx.select().predicate(i).getChild(0).getText().toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
				selection = new Selection(relation,expr);
				writeOutput(selection, "Test predicate =");
			}else if(ctx.select().predicate(i).getChild(1).getText().equals(">=")) {
				expr = new ExprGreaterEquals (new ExprAttribute(ctx.select().predicate(i).getChild(0).getText().toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
				selection = new Selection(relation,expr);
				writeOutput(selection, "Test Selection: ");
			}else if(ctx.select().predicate(i).getChild(1).getText().equals("<=")) {
				expr = new ExprLessEquals(new ExprAttribute(ctx.select().predicate(i).getChild(0).getText().toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
				selection = new Selection(relation,expr);
			}
			else {
				System.out.println("This Comperator " + ctx.select().predicate(i).getChild(1).getText() +" is not correct");
			}
			
		}
	
		
		/*System.out.println("Predicate: " + ctx.select().predicate().getText());
		String relationName = ctx.select().predicate().getChild(1).getChild(0).getText();
		System.out.println("Relaion name in Selection_: "  + relationName);

		String attributName = ctx.select().predicate().getChild(1).getChild(2).getText();
		System.out.println("Attribute name in selection: " + attributName);
		String value = ctx.select().predicate().getChild(3).getText();
		String comperator = ctx.select().predicate().getChild(2).getText();
		
		BooleanExpression expr = null;
		if(comperator.equals(">")) {
			expr = new ExprGreater(new ExprAttribute(attributName.toUpperCase()), new ExprConstant(value));
		}else if(comperator.equals("<")) {
			expr = new ExprLess(new ExprAttribute(attributName.toUpperCase()), new ExprConstant(value));
		}else if(comperator.equals("=")) {
			expr = new ExprEquals(new ExprAttribute(attributName.toUpperCase()), new ExprConstant(value));
		} else if(comperator.equals(">=")) {
			expr = new ExprGreaterEquals(new ExprAttribute(attributName.toUpperCase()), new ExprConstant(value));
		}else if(comperator.equals("<=")) {
			expr = new ExprLessEquals(new ExprAttribute(attributName.toUpperCase()), new ExprConstant(value));
		}
		else {
			System.out.println("This Comperator " + comperator +" is not correct");
		}
		
		Relation relation = visit(ctx.select().relation());
		System.out.println("Relation in selection:" +relation.getName());
		Selection selection = null;
		if(!relationName.toUpperCase().equals(relation.getName().toUpperCase())) {
			System.out.println("Relationsname stimmt nicht überein. Der richtige Name wäre: " + relation.getName() + " statt: " + relationName);
		}else {
			selection = new Selection(relation, expr);
			writeOutput(selection, "Test Selection");
		}
		
		return selection.getResult();*/
		return null;
	}

	/* Implementation of Projection Operation */
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