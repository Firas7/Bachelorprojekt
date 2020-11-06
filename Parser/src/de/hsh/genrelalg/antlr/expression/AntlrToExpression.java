package de.hsh.genrelalg.antlr.expression;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.hsh.genrelalg.Entities.ProjectionEntity;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.parser.RelAlgebraBaseVisitor;
import de.hsh.genrelalg.parser.RelAlgebraParser.CarstesianContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.CartesianContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.EOFContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.JoinContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Join_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.NestedContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Predicate_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.ProjectContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.ProjectionContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.SelectContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.SelectionContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.SimpleContext;
import de.hsh.genrelalg.relalg.Projection;

/* visitor class of the expression rule
 * here we will instantiate this to an expression <Expr>
 */
public class AntlrToExpression extends RelAlgebraBaseVisitor<Expr>{
	
	public AntlrToExpression() {
	}

	@Override
	public Expr visitCarstesian(CarstesianContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCarstesian(ctx);
	}

	@Override
	public Expr visitEOF(EOFContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEOF(ctx);
	}

	@Override
	public Expr visitPredicate_(Predicate_Context ctx) {
		// TODO Auto-generated method stub
		return super.visitPredicate_(ctx);
	}

	@Override
	public Expr visitSimple(SimpleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSimple(ctx);
	}

	@Override
	public Expr visitNested(NestedContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNested(ctx);
	}

	@Override
	public Expr visitSelect(SelectContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSelect(ctx);
	}

	@Override
	public Expr visitProject(ProjectContext ctx) {
		String project = ctx.PROJECT().getText();
		System.out.println("Operation_: " + project);
		
		return super.visitProject(ctx);
	}

	@Override
	public Expr visitCartesian(CartesianContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCartesian(ctx);
	}

	@Override
	public Expr visitJoin(JoinContext ctx) {
		// TODO Auto-generated method stub
		return super.visitJoin(ctx);
	}

	@Override
	public Expr visitJoin_(Join_Context ctx) {
		// TODO Auto-generated method stub
		return super.visitJoin_(ctx);
	}

	@Override
	public Expr visitSelection(SelectionContext ctx) {
		String select = ctx.select().getText();
		String predicate = ctx.select().predicate().getText();
		String relation = ctx.select().relation().getText();
		System.out.println("Operation: " +select);
		System.out.println("Predicate: :" + predicate);
		System.out.println("Relation in Select: " +relation);
		return super.visitSelection(ctx);
	}

	@SuppressWarnings("null")
	@Override
	public Expr visitProjection(ProjectionContext ctx) {
		String project = ctx.project().getText();
		System.out.println("Operation: " + project);
		
		String relationName = ctx.project().relation().getText();
		System.out.println("Relation: " + ctx.project().relation().getText() );
		int countOfAttributes = ctx.project().ATTRIBUT().size();
		/* create a relation as relationName */
		Relation relation_ = new Relation(relationName);
		
		Attribute[] attributesOfRelation = new Attribute [countOfAttributes] ;
		Attribute att;
		String attribute;
		for(int i = 0 ; i < ctx.project().ATTRIBUT().size(); i++) {
			attribute = ctx.project().ATTRIBUT().get(i).getText();
			attribute = convertAttributWithout_(attribute);
			att = new Attribute(relationName,attribute);
			attributesOfRelation[i] = att;
			System.out.println("Attribut "+ attribute + " will be added to list" );
		}
		
		// now we should create a projection object that get a relation_ and a list of attributes as parameters 
		Projection projection = new Projection(relation_,attributesOfRelation);
		System.out.println(projection.getResult().toText("", true));
		return projection;
	}

/*	@Override
	public Expr visitCartesian_(Cartesian_Context ctx) {
		// TODO Auto-generated method stub
		return super.visitCartesian_(ctx);
	}*/
	
	
	
	/*
	 * The following method converts the attributes of the projection to attributes without _ 
	 * at the beginning of the entered attributes
	 * */
	
	public String convertAttributWithout_ (String att){
		String s = att;
		System.out.println("Attribut befor convertion: " + s);
		s = att.substring(1,att.length());
		System.out.println("Attribut after convertion: " + s);
		
		return s;
	}
	
	/*
	 * a method to check if relation is an Expression or a Relation?
	 * 
	 * */
	
	
}
