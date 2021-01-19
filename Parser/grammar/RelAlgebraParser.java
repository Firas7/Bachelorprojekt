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
		ID=23, VALUE=24, AND=25, OR=26, ISNOT=27, WS=28;
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
			"'R'", "'UN'", "'IN'", "'DI'", null, null, "'&'", "'|'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "SELECT", "PROJECT", "JOIN", "CARTESIAN", "RENAME", 
			"UNION", "INTERSECTION", "DIFFERENCE", "ID", "VALUE", "AND", "OR", "ISNOT", 
			"WS"
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
	public static class EOFContext extends ExprContext {
		public TerminalNode EOF() { return getToken(RelAlgebraParser.EOF, 0); }
		public EOFContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitEOF(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(45);
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
			case 9:
				_localctx = new EOFContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(44);
				match(EOF);
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
			setState(47);
			match(T__0);
			setState(48);
			relation();
			setState(49);
			match(T__1);
			setState(50);
			match(DIFFERENCE);
			setState(51);
			match(T__0);
			setState(52);
			relation();
			setState(53);
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
			setState(55);
			match(T__0);
			setState(56);
			relation();
			setState(57);
			match(T__1);
			setState(58);
			match(INTERSECTION);
			setState(59);
			match(T__0);
			setState(60);
			relation();
			setState(61);
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
			setState(63);
			match(T__0);
			setState(64);
			relation();
			setState(65);
			match(T__1);
			setState(66);
			match(UNION);
			setState(67);
			match(T__0);
			setState(68);
			relation();
			setState(69);
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
			setState(71);
			match(RENAME);
			setState(72);
			match(T__2);
			setState(73);
			match(ID);
			setState(74);
			match(T__3);
			setState(75);
			match(T__0);
			setState(76);
			relation();
			setState(77);
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
			setState(79);
			attribut();
			setState(80);
			comparator();
			setState(81);
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
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				subPredicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				subPredicate();
				setState(85);
				match(OR);
				setState(86);
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
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				predicate();
				setState(92);
				match(AND);
				setState(93);
				subPredicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				match(T__0);
				setState(96);
				conditions();
				setState(97);
				match(T__1);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				match(ISNOT);
				setState(100);
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
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new SimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(ID);
				}
				break;
			case EOF:
			case T__0:
			case SELECT:
			case PROJECT:
			case RENAME:
				_localctx = new NestedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
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
			setState(107);
			match(SELECT);
			setState(108);
			match(T__2);
			setState(109);
			conditions();
			setState(110);
			match(T__3);
			setState(111);
			match(T__0);
			setState(112);
			relation();
			setState(113);
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
			setState(115);
			match(PROJECT);
			setState(116);
			match(T__2);
			setState(117);
			attribut();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(118);
				match(T__4);
				setState(119);
				attribut();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			match(T__3);
			setState(126);
			match(T__0);
			setState(127);
			relation();
			setState(128);
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
			setState(130);
			match(T__0);
			setState(131);
			relation();
			setState(132);
			match(T__1);
			setState(138); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				match(CARTESIAN);
				setState(134);
				match(T__0);
				setState(135);
				relation();
				setState(136);
				match(T__1);
				}
				}
				setState(140); 
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
			setState(142);
			match(T__0);
			setState(143);
			relation();
			setState(144);
			match(T__1);
			setState(145);
			var();
			setState(146);
			match(JOIN);
			setState(147);
			match(T__2);
			setState(148);
			conditions();
			setState(149);
			match(T__3);
			setState(150);
			match(T__0);
			setState(151);
			relation();
			setState(152);
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
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(154);
				match(ID);
				setState(155);
				match(T__5);
				}
				break;
			}
			setState(158);
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
			setState(160);
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
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << RENAME))) != 0)) {
				{
				setState(162);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00a8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\60\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\5\t[\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nh\n"+
		"\n\3\13\3\13\5\13l\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\7\r{\n\r\f\r\16\r~\13\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\6\16\u008d\n\16\r\16\16\16\u008e\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\5\20\u009f\n\20"+
		"\3\20\3\20\3\21\3\21\3\22\5\22\u00a6\n\22\3\22\2\2\23\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"\2\4\3\2\t\16\4\2\17\20\25\25\2\u00a7\2$\3\2\2"+
		"\2\4/\3\2\2\2\6\61\3\2\2\2\b9\3\2\2\2\nA\3\2\2\2\fI\3\2\2\2\16Q\3\2\2"+
		"\2\20Z\3\2\2\2\22g\3\2\2\2\24k\3\2\2\2\26m\3\2\2\2\30u\3\2\2\2\32\u0084"+
		"\3\2\2\2\34\u0090\3\2\2\2\36\u009e\3\2\2\2 \u00a2\3\2\2\2\"\u00a5\3\2"+
		"\2\2$%\5\4\3\2%\3\3\2\2\2&\60\5\26\f\2\'\60\5\30\r\2(\60\5\32\16\2)\60"+
		"\5\34\17\2*\60\5\f\7\2+\60\5\n\6\2,\60\5\b\5\2-\60\5\6\4\2.\60\7\2\2\3"+
		"/&\3\2\2\2/\'\3\2\2\2/(\3\2\2\2/)\3\2\2\2/*\3\2\2\2/+\3\2\2\2/,\3\2\2"+
		"\2/-\3\2\2\2/.\3\2\2\2\60\5\3\2\2\2\61\62\7\3\2\2\62\63\5\24\13\2\63\64"+
		"\7\4\2\2\64\65\7\30\2\2\65\66\7\3\2\2\66\67\5\24\13\2\678\7\4\2\28\7\3"+
		"\2\2\29:\7\3\2\2:;\5\24\13\2;<\7\4\2\2<=\7\27\2\2=>\7\3\2\2>?\5\24\13"+
		"\2?@\7\4\2\2@\t\3\2\2\2AB\7\3\2\2BC\5\24\13\2CD\7\4\2\2DE\7\26\2\2EF\7"+
		"\3\2\2FG\5\24\13\2GH\7\4\2\2H\13\3\2\2\2IJ\7\25\2\2JK\7\5\2\2KL\7\31\2"+
		"\2LM\7\6\2\2MN\7\3\2\2NO\5\24\13\2OP\7\4\2\2P\r\3\2\2\2QR\5\36\20\2RS"+
		"\5 \21\2ST\5\36\20\2T\17\3\2\2\2U[\5\22\n\2VW\5\22\n\2WX\7\34\2\2XY\5"+
		"\20\t\2Y[\3\2\2\2ZU\3\2\2\2ZV\3\2\2\2[\21\3\2\2\2\\h\5\16\b\2]^\5\16\b"+
		"\2^_\7\33\2\2_`\5\22\n\2`h\3\2\2\2ab\7\3\2\2bc\5\20\t\2cd\7\4\2\2dh\3"+
		"\2\2\2ef\7\35\2\2fh\5\20\t\2g\\\3\2\2\2g]\3\2\2\2ga\3\2\2\2ge\3\2\2\2"+
		"h\23\3\2\2\2il\7\31\2\2jl\5\4\3\2ki\3\2\2\2kj\3\2\2\2l\25\3\2\2\2mn\7"+
		"\21\2\2no\7\5\2\2op\5\20\t\2pq\7\6\2\2qr\7\3\2\2rs\5\24\13\2st\7\4\2\2"+
		"t\27\3\2\2\2uv\7\22\2\2vw\7\5\2\2w|\5\36\20\2xy\7\7\2\2y{\5\36\20\2zx"+
		"\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080"+
		"\7\6\2\2\u0080\u0081\7\3\2\2\u0081\u0082\5\24\13\2\u0082\u0083\7\4\2\2"+
		"\u0083\31\3\2\2\2\u0084\u0085\7\3\2\2\u0085\u0086\5\24\13\2\u0086\u008c"+
		"\7\4\2\2\u0087\u0088\7\24\2\2\u0088\u0089\7\3\2\2\u0089\u008a\5\24\13"+
		"\2\u008a\u008b\7\4\2\2\u008b\u008d\3\2\2\2\u008c\u0087\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\33\3\2\2\2\u0090"+
		"\u0091\7\3\2\2\u0091\u0092\5\24\13\2\u0092\u0093\7\4\2\2\u0093\u0094\5"+
		"\"\22\2\u0094\u0095\7\23\2\2\u0095\u0096\7\5\2\2\u0096\u0097\5\20\t\2"+
		"\u0097\u0098\7\6\2\2\u0098\u0099\7\3\2\2\u0099\u009a\5\24\13\2\u009a\u009b"+
		"\7\4\2\2\u009b\35\3\2\2\2\u009c\u009d\7\31\2\2\u009d\u009f\7\b\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\31"+
		"\2\2\u00a1\37\3\2\2\2\u00a2\u00a3\t\2\2\2\u00a3!\3\2\2\2\u00a4\u00a6\t"+
		"\3\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6#\3\2\2\2\n/Zgk|\u008e"+
		"\u009e\u00a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}