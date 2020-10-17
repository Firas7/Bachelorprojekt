// Generated from gram.g4 by ANTLR 4.8


	package antlrTest;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramParser}.
 */
public interface gramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(gramParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(gramParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(gramParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(gramParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#project}.
	 * @param ctx the parse tree
	 */
	void enterProject(gramParser.ProjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#project}.
	 * @param ctx the parse tree
	 */
	void exitProject(gramParser.ProjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(gramParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(gramParser.RelationContext ctx);
}