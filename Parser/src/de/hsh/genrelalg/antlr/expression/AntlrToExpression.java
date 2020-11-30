package de.hsh.genrelalg.antlr.expression;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.RuleContext;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Predicate;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.database.DBFactory;
import de.hsh.genrelalg.expr.BooleanExpression;
import de.hsh.genrelalg.expr.ExprAttribute;
import de.hsh.genrelalg.expr.ExprEquals;
import de.hsh.genrelalg.expr.ExprPredicate;
import de.hsh.genrelalg.parser.RelAlgebraBaseVisitor;
import de.hsh.genrelalg.parser.RelAlgebraParser.AndExprContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.AttributContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.CarstesianContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Difference_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.EOFContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Intersection_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.Join_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.NestedContext;
import de.hsh.genrelalg.parser.RelAlgebraParser.Predicate_Context;
import de.hsh.genrelalg.parser.RelAlgebraParser.ProjectionContext;
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
	
	VisitorPredicate visitorPredicate = new VisitorPredicate();
	public AntlrToExpression() {
		
	}
	
	/* Implementation of Rename Operation */
	@Override
	public Relation visitRename_(Rename_Context ctx) {
		Relation relation = visit(ctx.rename().relation());
		String newName = ctx.rename().ID().getText();
		Rename rename = new Rename(relation,newName);
		System.err.println(rename.getResult().toText("", true));
		writeOutput(rename, "Test Rename: ");
		return rename.getResult();
	}


	@Override
	public Relation visitAndExpr(AndExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAndExpr(ctx);
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
		RuleContext x = ctx.parent;
		System.out.println("RuleContext: " + x.getText());
		return super.visitPredicate_(ctx);
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
			return new Relation();
		}
		String relationLeftName = leftExpr.substring(0, leftExpr.indexOf("."));
		String relationRightName = rightExpr.substring(0, rightExpr.indexOf("."));	
		Relation relationLeft = visit(ctx.join().relation().get(0));
		Relation relationRight = visit(ctx.join().relation().get(1));
		
		// initial a join Operation  
		Join join = null;
		if(ctx.join().var().getText().toUpperCase().equals("I")){
			join = new Join(relationLeft, relationRight,
					new ExprEquals(new ExprAttribute(relationLeftName, attributes.get(0).toUpperCase()),  new ExprAttribute(relationRightName, attributes.get(1).toUpperCase())), 12,false,false); 
		}
		else if(ctx.join().var().getText().toUpperCase().equals("F")) {
			join = new Join(relationLeft, relationRight,
					new ExprEquals(new ExprAttribute(relationLeftName, attributes.get(0).toUpperCase()),  new ExprAttribute(relationRightName, attributes.get(1).toUpperCase())), 12,true,true);
		}else if(ctx.join().var().getText().toUpperCase().equals("R")) {
			join = new Join(relationLeft, relationRight,
					new ExprEquals(new ExprAttribute(relationLeftName, attributes.get(0).toUpperCase()),  new ExprAttribute(relationRightName, attributes.get(1).toUpperCase())), 12,false,true);
		}else if(ctx.join().var().getText().toUpperCase().equals("L")) {
			join = new Join(relationLeft, relationRight,
					new ExprEquals(new ExprAttribute(relationLeftName, attributes.get(0).toUpperCase()),  new ExprAttribute(relationRightName, attributes.get(1).toUpperCase())), 12,true,false);
		}
		writeOutput(join, "");
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
		@SuppressWarnings("unused")
		BooleanExpression expr = null;
		List<Predicate> predicate = new ArrayList<>();
		Selection selection = null;
		List<ExprPredicate> expressionsPredicates = new ArrayList<>();
		
		 for(int i = 0; i < ctx.select().exprPredicate().size(); i++) {
			 predicate.add( visitorPredicate.visit(ctx.select().exprPredicate(i).predicate()));
			 System.out.println(predicate.get(i).getExpression().toText());
		 }
			/*predicates.add( new Predicate(ctx.select().predicate(i).getChild(0).getText(), ctx.select().predicate(i).getChild(1).getText(),
							ctx.select().predicate(i).getChild(2).getText()));
			System.out.println("Predicate: " + predicates.get(i).getLeft()+", " + predicates.get(i).getExpr()+ ", " + predicates.get(i).getRight());
			selections.add( new Selection(relation, predicates.get(i).getExpression())); 
			writeOutput(selections.get(i), "Test Selection " + i);
		}
		 Selection selection = null;
		 for(int i = 0; i<ctx.select().operator().size(); i++) {
			 if(ctx.select().operator(i).getText().equals("&")) {
				 selection = new Selection(selections.get(i).getResult(),predicates.get(i+1).getExpression());
				 writeOutput(selection, "Test AND: ");
			 }else if(ctx.select().operator(i).getText().equals("|")) {
				 selection = new Selection(relation, predicates.get(i+1).getExpression());
				 Union union = new Union(selections.get(i).getResult(),selection.getResult());
				 writeOutput(union, "Test OR: ");
			 }*/
		 
			/*	if(ctx.select().predicate(i).getChild(2).getText().contains(".")){
					String exp1 = ctx.select().predicate(0).getChild(0).getText();
					String attributName1 = ctx.select().predicate(0).getChild(0).getText().substring(exp1.indexOf(".")+1, exp1.length());
					String relationName1 = ctx.select().predicate(0).getChild(0).getText().substring(0,exp1.indexOf("."));
					String exp2 = ctx.select().predicate(0).getChild(2).getText();
					String attributName2 = ctx.select().predicate(0).getChild(2).getText().substring(exp2.indexOf(".")+1, exp2.length());
					String relationName2 = ctx.select().predicate(0).getChild(2).getText().substring(0,exp2.indexOf("."));
					expr = new ExprEquals(new ExprAttribute(relationName1,attributName1.toUpperCase()), new ExprAttribute(relationName2,attributName2.toUpperCase()));
					
					if(ctx.select().predicate(i).getChild(1).getText().equals(">")) {
						expr = new ExprGreater(new ExprAttribute(relationName1,attributName1.toUpperCase()),new ExprAttribute(relationName2,attributName2.toUpperCase()));
						selection = new Selection(relation,expr);
					}else if(ctx.select().predicate(i).getChild(1).getText().equals("<")) {
						expr = new ExprLess(new ExprAttribute(relationName1,attributName1.toUpperCase()), new ExprAttribute(relationName2,attributName2.toUpperCase()));
						selection = new Selection(relation,expr);
					}else if(ctx.select().predicate(i).getChild(1).getText().equals("=")) {
						expr = new ExprEquals(new ExprAttribute(relationName1,attributName1.toUpperCase()),  new ExprAttribute(relationName2,attributName2.toUpperCase()));
						selection = new Selection(relation,expr);
					}else if(ctx.select().predicate(i).getChild(1).getText().equals(">=")) {
						expr = new ExprGreaterEquals (new ExprAttribute(relationName1,attributName1.toUpperCase()),  new ExprAttribute(relationName2,attributName2.toUpperCase()));
						selection = new Selection(relation,expr);
					}else if(ctx.select().predicate(i).getChild(1).getText().equals("<=")) {
						expr = new ExprLessEquals(new ExprAttribute(relationName1,relationName1.toUpperCase()), new ExprAttribute(relationName2,attributName2.toUpperCase()));
						selection = new Selection(relation,expr);
					}
					writeOutput(selection, "Test Selection: ");
				}

				else if(ctx.select().predicate(i).getChild(0).getText().contains(".")) {
				String exp = ctx.select().predicate(i).getChild(0).getText();
				String attributName = ctx.select().predicate(i).getChild(0).getText().substring(exp.indexOf(".")+1, exp.length());
				String relationName = ctx.select().predicate(i).getChild(0).getText().substring(0,exp.indexOf("."));
					if(ctx.select().predicate(i).getChild(1).getText().equals(">")) {
						expr = new ExprGreater(new ExprAttribute(relationName,attributName.toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
						selection = new Selection(relation,expr);
					}else if(ctx.select().predicate(i).getChild(1).getText().equals("<")) {
						expr = new ExprLess(new ExprAttribute(relationName,attributName.toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
						selection = new Selection(relation,expr);
					}else if(ctx.select().predicate(i).getChild(1).getText().equals("=")) {
						expr = new ExprEquals(new ExprAttribute(relationName,attributName.toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
						selection = new Selection(relation,expr);
					}else if(ctx.select().predicate(i).getChild(1).getText().equals(">=")) {
						expr = new ExprGreaterEquals (new ExprAttribute(relationName,attributName.toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
						selection = new Selection(relation,expr);
					}else if(ctx.select().predicate(i).getChild(1).getText().equals("<=")) {
						expr = new ExprLessEquals(new ExprAttribute(relationName,attributName.toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
						selection = new Selection(relation,expr);
					}
					writeOutput(selection, "Test Selection: ");
			} else {
						if(ctx.select().predicate(i).getChild(1).getText().equals(">")) {
							expr = new ExprGreater(new ExprAttribute(ctx.select().predicate(i).getChild(0).getText().toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
							selection = new Selection(relation,expr);
						}else if(ctx.select().predicate(i).getChild(1).getText().equals("<")) {
							expr = new ExprLess(new ExprAttribute(ctx.select().predicate(i).getChild(0).getText().toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
							selection = new Selection(relation,expr);
						}else if(ctx.select().predicate(i).getChild(1).getText().equals("=")) {
							expr = new ExprEquals(new ExprAttribute(ctx.select().predicate(i).getChild(0).getText().toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
							selection = new Selection(relation,expr);
						}else if(ctx.select().predicate(i).getChild(1).getText().equals(">=")) {
							expr = new ExprGreaterEquals (new ExprAttribute(ctx.select().predicate(i).getChild(0).getText().toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
							selection = new Selection(relation,expr);
						}else if(ctx.select().predicate(i).getChild(1).getText().equals("<=")) {
							expr = new ExprLessEquals(new ExprAttribute(ctx.select().predicate(i).getChild(0).getText().toUpperCase()), new ExprConstant(ctx.select().predicate(i).getChild(2).getText()));
							selection = new Selection(relation,expr);
						}
						else {
							System.out.println("This Comperator " + ctx.select().predicate(i).getChild(1).getText() +" is not correct");
						}
						writeOutput(selection, "Test Selection: ");
			}
	}
		
		return selection.getResult();*/
			return null;
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
			}else {
				attributObj[i] = new Attribute (ctx.project().attribut(i).getText().toUpperCase());
			}
		}
		projection = new Projection(relationObj,attributObj);
		writeOutput(projection, "Test Projektion");
		return projection.getResult();
	}

	@Override
	protected Relation aggregateResult(Relation aggregate, Relation nextResult) {
		// TODO Auto-generated method stub
		return super.aggregateResult(aggregate, nextResult);
	}

	@Override
	protected Relation defaultResult() {
		// TODO Auto-generated method stub
		return super.defaultResult();
	}
	
	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("Aufgabe: " + task + "\n");		
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}

}