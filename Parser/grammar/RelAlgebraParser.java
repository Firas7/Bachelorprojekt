// Generated from RelAlgebra.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RelAlgebraParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, SELECT=15, PROJECT=16, 
		JOIN=17, CARTESIAN=18, RENAME=19, UNION=20, INTERSECTION=21, DIFFERENCE=22, 
		ID=23, AND=24, OR=25, ISNOT=26, WS=27;
	public static final int
		RULE_prog = 0, RULE_expr = 1, RULE_difference = 2, RULE_intersection = 3, 
		RULE_union = 4, RULE_rename = 5, RULE_predicate = 6, RULE_conditions = 7, 
		RULE_subPredicate = 8, RULE_relation = 9, RULE_select = 10, RULE_project = 11, 
		RULE_cartesian = 12, RULE_join = 13, RULE_attribut = 14, RULE_comparator = 15, 
		RULE_var = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "expr", "difference", "intersection", "union", "rename", "predicate", 
			"conditions", "subPredicate", "relation", "select", "project", "cartesian", 
			"join", "attribut", "comparator", "var"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "','", "'.'", "'='", "'<'", "'>'", 
			"'>='", "'<='", "'!='", "'L'", "'F'", "'SL'", "'PR'", "'JN'", "'X'", 
			"'R'", "'UN'", "'IN'", "'DI'", null, "'&'", "'|'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "SELECT", "PROJECT", "JOIN", "CARTESIAN", "RENAME", 
			"UNION", "INTERSECTION", "DIFFERENCE", "ID", "AND", "OR", "ISNOT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "RelAlgebra.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RelAlgebraParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgramContext extends ProgContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ProgramContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitProgram(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			_localctx = new ProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Intersection_Context extends ExprContext {
		public IntersectionContext intersection() {
			return getRuleContext(IntersectionContext.class,0);
		}
		public Intersection_Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterIntersection_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitIntersection_(this);
		}
	}
	public static class CarstesianContext extends ExprContext {
		public CartesianContext cartesian() {
			return getRuleContext(CartesianContext.class,0);
		}
		public CarstesianContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterCarstesian(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitCarstesian(this);
		}
	}
	public static class Join_Context extends ExprContext {
		public JoinContext join() {
			return getRuleContext(JoinContext.class,0);
		}
		public Join_Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterJoin_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitJoin_(this);
		}
	}
	public static class Rename_Context extends ExprContext {
		public RenameContext rename() {
			return getRuleContext(RenameContext.class,0);
		}
		public Rename_Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterRename_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitRename_(this);
		}
	}
	public static class SelectionContext extends ExprContext {
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public SelectionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitSelection(this);
		}
	}
	public static class ProjectionContext extends ExprContext {
		public ProjectContext project() {
			return getRuleContext(ProjectContext.class,0);
		}
		public ProjectionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterProjection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitProjection(this);
		}
	}
	public static class Difference_Context extends ExprContext {
		public DifferenceContext difference() {
			return getRuleContext(DifferenceContext.class,0);
		}
		public Difference_Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterDifference_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitDifference_(this);
		}
	}
	public static class Union_Context extends ExprContext {
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public Union_Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterUnion_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitUnion_(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new SelectionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				select();
				}
				break;
			case 2:
				_localctx = new ProjectionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				project();
				}
				break;
			case 3:
				_localctx = new CarstesianContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				cartesian();
				}
				break;
			case 4:
				_localctx = new Join_Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				join();
				}
				break;
			case 5:
				_localctx = new Rename_Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				rename();
				}
				break;
			case 6:
				_localctx = new Union_Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				union();
				}
				break;
			case 7:
				_localctx = new Intersection_Context(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
				intersection();
				}
				break;
			case 8:
				_localctx = new Difference_Context(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(43);
				difference();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DifferenceContext extends ParserRuleContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode DIFFERENCE() { return getToken(RelAlgebraParser.DIFFERENCE, 0); }
		public DifferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterDifference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitDifference(this);
		}
	}

	public final DifferenceContext difference() throws RecognitionException {
		DifferenceContext _localctx = new DifferenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_difference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__0);
			setState(47);
			relation();
			setState(48);
			match(T__1);
			setState(49);
			match(DIFFERENCE);
			setState(50);
			match(T__0);
			setState(51);
			relation();
			setState(52);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntersectionContext extends ParserRuleContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode INTERSECTION() { return getToken(RelAlgebraParser.INTERSECTION, 0); }
		public IntersectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intersection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterIntersection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitIntersection(this);
		}
	}

	public final IntersectionContext intersection() throws RecognitionException {
		IntersectionContext _localctx = new IntersectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_intersection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__0);
			setState(55);
			relation();
			setState(56);
			match(T__1);
			setState(57);
			match(INTERSECTION);
			setState(58);
			match(T__0);
			setState(59);
			relation();
			setState(60);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionContext extends ParserRuleContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public TerminalNode UNION() { return getToken(RelAlgebraParser.UNION, 0); }
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitUnion(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__0);
			setState(63);
			relation();
			setState(64);
			match(T__1);
			setState(65);
			match(UNION);
			setState(66);
			match(T__0);
			setState(67);
			relation();
			setState(68);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RenameContext extends ParserRuleContext {
		public TerminalNode RENAME() { return getToken(RelAlgebraParser.RENAME, 0); }
		public TerminalNode ID() { return getToken(RelAlgebraParser.ID, 0); }
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public RenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterRename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitRename(this);
		}
	}

	public final RenameContext rename() throws RecognitionException {
		RenameContext _localctx = new RenameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(RENAME);
			setState(71);
			match(T__2);
			setState(72);
			match(ID);
			setState(73);
			match(T__3);
			setState(74);
			match(T__0);
			setState(75);
			relation();
			setState(76);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public List<AttributContext> attribut() {
			return getRuleContexts(AttributContext.class);
		}
		public AttributContext attribut(int i) {
			return getRuleContext(AttributContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitPredicate(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			attribut();
			setState(79);
			comparator();
			setState(80);
			attribut();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionsContext extends ParserRuleContext {
		public SubPredicateContext subPredicate() {
			return getRuleContext(SubPredicateContext.class,0);
		}
		public TerminalNode OR() { return getToken(RelAlgebraParser.OR, 0); }
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public ConditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterConditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitConditions(this);
		}
	}

	public final ConditionsContext conditions() throws RecognitionException {
		ConditionsContext _localctx = new ConditionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conditions);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				subPredicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				subPredicate();
				setState(84);
				match(OR);
				setState(85);
				conditions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubPredicateContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode AND() { return getToken(RelAlgebraParser.AND, 0); }
		public SubPredicateContext subPredicate() {
			return getRuleContext(SubPredicateContext.class,0);
		}
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public TerminalNode ISNOT() { return getToken(RelAlgebraParser.ISNOT, 0); }
		public SubPredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subPredicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterSubPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitSubPredicate(this);
		}
	}

	public final SubPredicateContext subPredicate() throws RecognitionException {
		SubPredicateContext _localctx = new SubPredicateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_subPredicate);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				predicate();
				setState(91);
				match(AND);
				setState(92);
				subPredicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(T__0);
				setState(95);
				conditions();
				setState(96);
				match(T__1);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(98);
				match(ISNOT);
				setState(99);
				conditions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	 
		public RelationContext() { }
		public void copyFrom(RelationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleContext extends RelationContext {
		public TerminalNode ID() { return getToken(RelAlgebraParser.ID, 0); }
		public SimpleContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitSimple(this);
		}
	}
	public static class NestedContext extends RelationContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NestedContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterNested(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitNested(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_relation);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new SimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(ID);
				}
				break;
			case T__0:
			case SELECT:
			case PROJECT:
			case RENAME:
				_localctx = new NestedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(RelAlgebraParser.SELECT, 0); }
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitSelect(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(SELECT);
			setState(107);
			match(T__2);
			setState(108);
			conditions();
			setState(109);
			match(T__3);
			setState(110);
			match(T__0);
			setState(111);
			relation();
			setState(112);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProjectContext extends ParserRuleContext {
		public TerminalNode PROJECT() { return getToken(RelAlgebraParser.PROJECT, 0); }
		public List<AttributContext> attribut() {
			return getRuleContexts(AttributContext.class);
		}
		public AttributContext attribut(int i) {
			return getRuleContext(AttributContext.class,i);
		}
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public ProjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_project; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterProject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitProject(this);
		}
	}

	public final ProjectContext project() throws RecognitionException {
		ProjectContext _localctx = new ProjectContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_project);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(PROJECT);
			setState(115);
			match(T__2);
			setState(116);
			attribut();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(117);
				match(T__4);
				setState(118);
				attribut();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			match(T__3);
			setState(125);
			match(T__0);
			setState(126);
			relation();
			setState(127);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CartesianContext extends ParserRuleContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public List<TerminalNode> CARTESIAN() { return getTokens(RelAlgebraParser.CARTESIAN); }
		public TerminalNode CARTESIAN(int i) {
			return getToken(RelAlgebraParser.CARTESIAN, i);
		}
		public CartesianContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cartesian; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterCartesian(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitCartesian(this);
		}
	}

	public final CartesianContext cartesian() throws RecognitionException {
		CartesianContext _localctx = new CartesianContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cartesian);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__0);
			setState(130);
			relation();
			setState(131);
			match(T__1);
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				match(CARTESIAN);
				setState(133);
				match(T__0);
				setState(134);
				relation();
				setState(135);
				match(T__1);
				}
				}
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CARTESIAN );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinContext extends ParserRuleContext {
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode JOIN() { return getToken(RelAlgebraParser.JOIN, 0); }
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public JoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitJoin(this);
		}
	}

	public final JoinContext join() throws RecognitionException {
		JoinContext _localctx = new JoinContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__0);
			setState(142);
			relation();
			setState(143);
			match(T__1);
			setState(144);
			var();
			setState(145);
			match(JOIN);
			setState(146);
			match(T__2);
			setState(147);
			conditions();
			setState(148);
			match(T__3);
			setState(149);
			match(T__0);
			setState(150);
			relation();
			setState(151);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RelAlgebraParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RelAlgebraParser.ID, i);
		}
		public AttributContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribut; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterAttribut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitAttribut(this);
		}
	}

	public final AttributContext attribut() throws RecognitionException {
		AttributContext _localctx = new AttributContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_attribut);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(153);
				match(ID);
				setState(154);
				match(T__5);
				}
				break;
			}
			setState(157);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparatorContext extends ParserRuleContext {
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitComparator(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode RENAME() { return getToken(RelAlgebraParser.RENAME, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << RENAME))) != 0)) {
				{
				setState(161);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << RENAME))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00a7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\5\tZ\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\ng\n\n\3\13"+
		"\3\13\5\13k\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7"+
		"\rz\n\r\f\r\16\r}\13\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\6\16\u008c\n\16\r\16\16\16\u008d\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\5\20\u009e\n\20\3\20\3\20"+
		"\3\21\3\21\3\22\5\22\u00a5\n\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"\2\4\3\2\t\16\4\2\17\20\25\25\2\u00a5\2$\3\2\2\2\4.\3\2"+
		"\2\2\6\60\3\2\2\2\b8\3\2\2\2\n@\3\2\2\2\fH\3\2\2\2\16P\3\2\2\2\20Y\3\2"+
		"\2\2\22f\3\2\2\2\24j\3\2\2\2\26l\3\2\2\2\30t\3\2\2\2\32\u0083\3\2\2\2"+
		"\34\u008f\3\2\2\2\36\u009d\3\2\2\2 \u00a1\3\2\2\2\"\u00a4\3\2\2\2$%\5"+
		"\4\3\2%\3\3\2\2\2&/\5\26\f\2\'/\5\30\r\2(/\5\32\16\2)/\5\34\17\2*/\5\f"+
		"\7\2+/\5\n\6\2,/\5\b\5\2-/\5\6\4\2.&\3\2\2\2.\'\3\2\2\2.(\3\2\2\2.)\3"+
		"\2\2\2.*\3\2\2\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2\2/\5\3\2\2\2\60\61\7\3\2"+
		"\2\61\62\5\24\13\2\62\63\7\4\2\2\63\64\7\30\2\2\64\65\7\3\2\2\65\66\5"+
		"\24\13\2\66\67\7\4\2\2\67\7\3\2\2\289\7\3\2\29:\5\24\13\2:;\7\4\2\2;<"+
		"\7\27\2\2<=\7\3\2\2=>\5\24\13\2>?\7\4\2\2?\t\3\2\2\2@A\7\3\2\2AB\5\24"+
		"\13\2BC\7\4\2\2CD\7\26\2\2DE\7\3\2\2EF\5\24\13\2FG\7\4\2\2G\13\3\2\2\2"+
		"HI\7\25\2\2IJ\7\5\2\2JK\7\31\2\2KL\7\6\2\2LM\7\3\2\2MN\5\24\13\2NO\7\4"+
		"\2\2O\r\3\2\2\2PQ\5\36\20\2QR\5 \21\2RS\5\36\20\2S\17\3\2\2\2TZ\5\22\n"+
		"\2UV\5\22\n\2VW\7\33\2\2WX\5\20\t\2XZ\3\2\2\2YT\3\2\2\2YU\3\2\2\2Z\21"+
		"\3\2\2\2[g\5\16\b\2\\]\5\16\b\2]^\7\32\2\2^_\5\22\n\2_g\3\2\2\2`a\7\3"+
		"\2\2ab\5\20\t\2bc\7\4\2\2cg\3\2\2\2de\7\34\2\2eg\5\20\t\2f[\3\2\2\2f\\"+
		"\3\2\2\2f`\3\2\2\2fd\3\2\2\2g\23\3\2\2\2hk\7\31\2\2ik\5\4\3\2jh\3\2\2"+
		"\2ji\3\2\2\2k\25\3\2\2\2lm\7\21\2\2mn\7\5\2\2no\5\20\t\2op\7\6\2\2pq\7"+
		"\3\2\2qr\5\24\13\2rs\7\4\2\2s\27\3\2\2\2tu\7\22\2\2uv\7\5\2\2v{\5\36\20"+
		"\2wx\7\7\2\2xz\5\36\20\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2"+
		"\2\2}{\3\2\2\2~\177\7\6\2\2\177\u0080\7\3\2\2\u0080\u0081\5\24\13\2\u0081"+
		"\u0082\7\4\2\2\u0082\31\3\2\2\2\u0083\u0084\7\3\2\2\u0084\u0085\5\24\13"+
		"\2\u0085\u008b\7\4\2\2\u0086\u0087\7\24\2\2\u0087\u0088\7\3\2\2\u0088"+
		"\u0089\5\24\13\2\u0089\u008a\7\4\2\2\u008a\u008c\3\2\2\2\u008b\u0086\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\33\3\2\2\2\u008f\u0090\7\3\2\2\u0090\u0091\5\24\13\2\u0091\u0092\7\4"+
		"\2\2\u0092\u0093\5\"\22\2\u0093\u0094\7\23\2\2\u0094\u0095\7\5\2\2\u0095"+
		"\u0096\5\20\t\2\u0096\u0097\7\6\2\2\u0097\u0098\7\3\2\2\u0098\u0099\5"+
		"\24\13\2\u0099\u009a\7\4\2\2\u009a\35\3\2\2\2\u009b\u009c\7\31\2\2\u009c"+
		"\u009e\7\b\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\u00a0\7\31\2\2\u00a0\37\3\2\2\2\u00a1\u00a2\t\2\2\2\u00a2!"+
		"\3\2\2\2\u00a3\u00a5\t\3\2\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"#\3\2\2\2\n.Yfj{\u008d\u009d\u00a4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}