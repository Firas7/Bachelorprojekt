// Generated from RelAlgebra.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RelAlgebraParser}.
 */
public interface RelAlgebraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link RelAlgebraParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(RelAlgebraParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link RelAlgebraParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(RelAlgebraParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Selection}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSelection(RelAlgebraParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Selection}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSelection(RelAlgebraParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Projection}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterProjection(RelAlgebraParser.ProjectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Projection}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitProjection(RelAlgebraParser.ProjectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Carstesian}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCarstesian(RelAlgebraParser.CarstesianContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Carstesian}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCarstesian(RelAlgebraParser.CarstesianContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Join_}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterJoin_(RelAlgebraParser.Join_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Join_}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitJoin_(RelAlgebraParser.Join_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code Rename_}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRename_(RelAlgebraParser.Rename_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Rename_}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRename_(RelAlgebraParser.Rename_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code Union_}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnion_(RelAlgebraParser.Union_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Union_}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnion_(RelAlgebraParser.Union_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code Intersection_}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntersection_(RelAlgebraParser.Intersection_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Intersection_}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntersection_(RelAlgebraParser.Intersection_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code Difference_}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDifference_(RelAlgebraParser.Difference_Context ctx);
	/**
	 * Exit a parse tree produced by the {@code Difference_}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDifference_(RelAlgebraParser.Difference_Context ctx);
	/**
	 * Enter a parse tree produced by the {@code EOF}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEOF(RelAlgebraParser.EOFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EOF}
	 * labeled alternative in {@link RelAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEOF(RelAlgebraParser.EOFContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#difference}.
	 * @param ctx the parse tree
	 */
	void enterDifference(RelAlgebraParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#difference}.
	 * @param ctx the parse tree
	 */
	void exitDifference(RelAlgebraParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#intersection}.
	 * @param ctx the parse tree
	 */
	void enterIntersection(RelAlgebraParser.IntersectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#intersection}.
	 * @param ctx the parse tree
	 */
	void exitIntersection(RelAlgebraParser.IntersectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnion(RelAlgebraParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnion(RelAlgebraParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#rename}.
	 * @param ctx the parse tree
	 */
	void enterRename(RelAlgebraParser.RenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#rename}.
	 * @param ctx the parse tree
	 */
	void exitRename(RelAlgebraParser.RenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(RelAlgebraParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(RelAlgebraParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#conditions}.
	 * @param ctx the parse tree
	 */
	void enterConditions(RelAlgebraParser.ConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#conditions}.
	 * @param ctx the parse tree
	 */
	void exitConditions(RelAlgebraParser.ConditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#subPredicate}.
	 * @param ctx the parse tree
	 */
	void enterSubPredicate(RelAlgebraParser.SubPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#subPredicate}.
	 * @param ctx the parse tree
	 */
	void exitSubPredicate(RelAlgebraParser.SubPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simple}
	 * labeled alternative in {@link RelAlgebraParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterSimple(RelAlgebraParser.SimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simple}
	 * labeled alternative in {@link RelAlgebraParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitSimple(RelAlgebraParser.SimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nested}
	 * labeled alternative in {@link RelAlgebraParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterNested(RelAlgebraParser.NestedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nested}
	 * labeled alternative in {@link RelAlgebraParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitNested(RelAlgebraParser.NestedContext ctx);
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
	 * Enter a parse tree produced by {@link RelAlgebraParser#cartesian}.
	 * @param ctx the parse tree
	 */
	void enterCartesian(RelAlgebraParser.CartesianContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#cartesian}.
	 * @param ctx the parse tree
	 */
	void exitCartesian(RelAlgebraParser.CartesianContext ctx);
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
	 * Enter a parse tree produced by {@link RelAlgebraParser#attribut}.
	 * @param ctx the parse tree
	 */
	void enterAttribut(RelAlgebraParser.AttributContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#attribut}.
	 * @param ctx the parse tree
	 */
	void exitAttribut(RelAlgebraParser.AttributContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(RelAlgebraParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(RelAlgebraParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(RelAlgebraParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(RelAlgebraParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelAlgebraParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(RelAlgebraParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelAlgebraParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(RelAlgebraParser.VarContext ctx);
}