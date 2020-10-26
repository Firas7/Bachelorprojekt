// Generated from RelAlgebra.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RelAlgebraParser}.
 */
public interface RelAlgebraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(RelAlgebraParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(RelAlgebraParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#select}.
	 * @param ctx the parse tree
	 */
	void enterSelect(RelAlgebraParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#select}.
	 * @param ctx the parse tree
	 */
	void exitSelect(RelAlgebraParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#project}.
	 * @param ctx the parse tree
	 */
	void enterProject(RelAlgebraParser.ProjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#project}.
	 * @param ctx the parse tree
	 */
	void exitProject(RelAlgebraParser.ProjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#join}.
	 * @param ctx the parse tree
	 */
	void enterJoin(RelAlgebraParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#join}.
	 * @param ctx the parse tree
	 */
	void exitJoin(RelAlgebraParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#cartesian}.
	 * @param ctx the parse tree
	 */
	void enterCartesian(RelAlgebraParser.CartesianContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#cartesian}.
	 * @param ctx the parse tree
	 */
	void exitCartesian(RelAlgebraParser.CartesianContext ctx);
}