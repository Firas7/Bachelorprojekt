package de.hsh.genrelalg.data;

import de.hsh.genrelalg.expr.BooleanExpression;
import de.hsh.genrelalg.expr.ExprAttribute;
import de.hsh.genrelalg.expr.ExprConstant;
import de.hsh.genrelalg.expr.ExprEquals;
import de.hsh.genrelalg.expr.ExprGreater;
import de.hsh.genrelalg.expr.ExprGreaterEquals;
import de.hsh.genrelalg.expr.ExprLess;
import de.hsh.genrelalg.expr.ExprLessEquals;

public class Predicate {
	String right, left, expr;
	BooleanExpression booleanexpression;
	
	//  the left is an Attribute, the right one could be an attribute or a value (ExprConstant)
	public Predicate() {
		this.left = "";
		this.right = "";
		this.expr = "";
	}
	
	public String getRight() {
		return right;
	}

	public String getLeft() {
		return left;
	}

	public String getExpr() {
		return expr;
	}

	public Predicate(String left, String expr,String right) {
		this.left = left;
		this.expr = expr;
		this.right = right;
	}
	
	public void setBooleanexprisson(BooleanExpression expr) {
		this.booleanexpression = expr;
	}
	public BooleanExpression getExpression() {
		BooleanExpression expr = null;
		
		if(this.right.contains(".") && this.left.contains(".")) {
			String attributName1 = this.left.substring(this.left.indexOf(".")+1, this.left.length());
			String relationName1 =this.left.substring(0,this.left.indexOf("."));
			String attributName2 = this.right.substring(this.right.indexOf(".")+1, this.right.length());
			String relationName2 = this.right.substring(0,this.right.indexOf("."));
			
			if(this.expr.equals(">")) {
				expr = new ExprGreater(new ExprAttribute(relationName1,attributName1.toUpperCase()),new ExprAttribute(relationName2,attributName2.toUpperCase()));
			}else if(this.expr.equals("<")) {
				expr = new ExprLess(new ExprAttribute(relationName1,attributName1.toUpperCase()), new ExprAttribute(relationName2,attributName2.toUpperCase()));
			}else if(this.expr.equals("=")) {
				expr = new ExprEquals(new ExprAttribute(relationName1,attributName1.toUpperCase()),  new ExprAttribute(relationName2,attributName2.toUpperCase()));
			}else if(this.expr.equals(">=")) {
				expr = new ExprGreaterEquals (new ExprAttribute(relationName1,attributName1.toUpperCase()),  new ExprAttribute(relationName2,attributName2.toUpperCase()));
			}else if(this.expr.equals("<=")) {
				expr = new ExprLessEquals(new ExprAttribute(relationName1,relationName1.toUpperCase()), new ExprAttribute(relationName2,attributName2.toUpperCase()));
			}
		}else if(this.left.contains(".")) {

			String attributName = this.left.substring(this.left.indexOf(".")+1, this.left.length());
			String relationName = this.left.substring(0,this.left.indexOf("."));
				if(this.expr.equals(">")) {
					expr = new ExprGreater(new ExprAttribute(relationName,attributName.toUpperCase()), new ExprConstant(this.right));
				}else if(this.expr.equals("<")) {
					expr = new ExprLess(new ExprAttribute(relationName,attributName.toUpperCase()), new ExprConstant(this.right));
				}else if(this.expr.equals("=")) {
					expr = new ExprEquals(new ExprAttribute(relationName,attributName.toUpperCase()), new ExprConstant(this.right));
				}else if(this.expr.equals(">=")) {
					expr = new ExprGreaterEquals (new ExprAttribute(relationName,attributName.toUpperCase()), new ExprConstant(this.right));
				}else if(this.expr.equals("<=")) {
					expr = new ExprLessEquals(new ExprAttribute(relationName,attributName.toUpperCase()), new ExprConstant(this.right));
				}
		}else {
			if(this.expr.equals(">")) {
				expr = new ExprGreater(new ExprAttribute(this.left.toUpperCase()), new ExprConstant(this.right));
			}else if(this.expr.equals("<")) {
				expr = new ExprLess(new ExprAttribute(this.left.toUpperCase()), new ExprConstant(this.right));
			}else if(this.expr.equals("=")) {
				expr = new ExprEquals(new ExprAttribute(this.left.toUpperCase()), new ExprConstant(this.right));
			}else if(this.expr.equals(">=")) {
				expr = new ExprGreaterEquals (new ExprAttribute(this.left.toUpperCase()), new ExprConstant(this.right));
			}else if(this.expr.equals("<=")) {
				expr = new ExprLessEquals(new ExprAttribute(this.left.toUpperCase()), new ExprConstant(this.right));
			}
		}
		
		return expr;
	}
	
	public String toText() {
		return this.left + this.expr + this.right;
	}

	public Predicate getLeftPredicate() {
		return this.getLeftPredicate();
	}
	public Predicate getRightPredicate() {
		return this.getRightPredicate();
	}
	
}
