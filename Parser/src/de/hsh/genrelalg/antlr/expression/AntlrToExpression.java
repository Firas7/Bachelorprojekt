package de.hsh.genrelalg.antlr.expression;

import java.util.ArrayList;
import java.util.List;

import de.compiler.parser.RelAlgebraBaseVisitor;
import de.compiler.parser.RelAlgebraParser.Join_Context;
import de.compiler.parser.RelAlgebraParser.ProjectionContext;
import de.compiler.parser.RelAlgebraParser.SelectionContext;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.data.Tuple;
import de.hsh.genrelalg.relalg.Projection;
import de.hsh.genrelalg.relalg.RelationalAlgebra;

public class AntlrToExpression extends RelAlgebraBaseVisitor<Expr>{
	
	public AntlrToExpression() {
	}

	@Override
	public Expr visitJoin_(Join_Context ctx) {
		// TODO Auto-generated method stub
		return super.visitJoin_(ctx);
	}

	@Override
	public Expr visitSelection(SelectionContext ctx) {
		
		return super.visitSelection(ctx);
	}

	@SuppressWarnings("null")
	@Override
	public Expr visitProjection(ProjectionContext ctx) {
		String project = ctx.PROJECT().getText();
		System.out.println("Operation: " + project);
		Relation relation = new Relation(ctx.RELATION().getText());
		System.out.println("Relation: " + ctx.RELATION().getText() );
		Attribute [] attributes = new Attribute [ctx.ATTRIBUT().size()];
		String s;
		/*
		 * Die folgende for-Schleife konvertiert die Attribute der Projektion zu Attribute ohne _ 
		 * 
		 * */
		for (int i = 0; i < ctx.ATTRIBUT().size(); i++) {
			s = ctx.ATTRIBUT().get(i).toString().substring(1, ctx.ATTRIBUT().get(i).toString().length());
			attributes[i]  = new Attribute (ctx.RELATION().getText().toString(),s);
		}
		
		Projection projection = new Projection(relation,attributes);
		return projection;
	}

/*	@Override
	public Expr visitCartesian_(Cartesian_Context ctx) {
		// TODO Auto-generated method stub
		return super.visitCartesian_(ctx);
	}*/
	
	public Relation getResult(Projection pro) {
		return pro.getResult();
		
	}
}
