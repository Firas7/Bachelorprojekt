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
		ID=23, VALUE=24, COMPERATOR=25, WS=26;
	public static final int
		RULE_prog = 0, RULE_expr = 1, RULE_difference = 2, RULE_intersection = 3, 
		RULE_union = 4, RULE_rename = 5, RULE_predicate = 6, RULE_relation = 7, 
		RULE_select = 8, RULE_project = 9, RULE_cartesian = 10, RULE_join = 11, 
		RULE_attribut = 12, RULE_comparator = 13, RULE_operator = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "expr", "difference", "intersection", "union", "rename", "predicate", 
			"relation", "select", "project", "cartesian", "join", "attribut", "comparator", 
			"operator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "','", "'.'", "'='", "'<'", "'>'", 
			"'>='", "'<='", "'&'", "'|'", "'~'", "'SL'", "'PR'", "'JN'", "'X'", "'P'", 
			"'UN'", "'IN'", "'DI'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "SELECT", "PROJECT", "JOIN", "CARTESIAN", "RENAME", 
			"UNION", "INTERSECTION", "DIFFERENCE", "ID", "VALUE", "COMPERATOR", "WS"
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
			setState(30);
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
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new SelectionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				select();
				}
				break;
			case 2:
				_localctx = new ProjectionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				project();
				}
				break;
			case 3:
				_localctx = new CarstesianContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				cartesian();
				}
				break;
			case 4:
				_localctx = new Join_Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				join();
				}
				break;
			case 5:
				_localctx = new Rename_Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				rename();
				}
				break;
			case 6:
				_localctx = new Union_Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(37);
				union();
				}
				break;
			case 7:
				_localctx = new Intersection_Context(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(38);
				intersection();
				}
				break;
			case 8:
				_localctx = new Difference_Context(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(39);
				difference();
				}
				break;
			case 9:
				_localctx = new EOFContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(40);
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
			setState(43);
			match(T__0);
			setState(44);
			relation();
			setState(45);
			match(T__1);
			setState(46);
			match(DIFFERENCE);
			setState(47);
			match(T__0);
			setState(48);
			relation();
			setState(49);
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
			setState(51);
			match(T__0);
			setState(52);
			relation();
			setState(53);
			match(T__1);
			setState(54);
			match(INTERSECTION);
			setState(55);
			match(T__0);
			setState(56);
			relation();
			setState(57);
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
			setState(59);
			match(T__0);
			setState(60);
			relation();
			setState(61);
			match(T__1);
			setState(62);
			match(UNION);
			setState(63);
			match(T__0);
			setState(64);
			relation();
			setState(65);
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
			setState(67);
			match(RENAME);
			setState(68);
			match(T__2);
			setState(69);
			match(ID);
			setState(70);
			match(T__3);
			setState(71);
			match(T__0);
			setState(72);
			relation();
			setState(73);
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
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	 
		public PredicateContext() { }
		public void copyFrom(PredicateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Predicate_Context extends PredicateContext {
		public List<AttributContext> attribut() {
			return getRuleContexts(AttributContext.class);
		}
		public AttributContext attribut(int i) {
			return getRuleContext(AttributContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public Predicate_Context(PredicateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterPredicate_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitPredicate_(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_predicate);
		try {
			_localctx = new Predicate_Context(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			attribut();
			setState(76);
			comparator();
			setState(77);
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
		enterRule(_localctx, 14, RULE_relation);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new SimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
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
				setState(80);
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
		public List<PredicateContext> predicate() {
			return getRuleContexts(PredicateContext.class);
		}
		public PredicateContext predicate(int i) {
			return getRuleContext(PredicateContext.class,i);
		}
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
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
		enterRule(_localctx, 16, RULE_select);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(SELECT);
			setState(84);
			match(T__2);
			setState(85);
			predicate();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
				{
				{
				setState(86);
				operator();
				setState(87);
				predicate();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__3);
			setState(95);
			match(T__0);
			setState(96);
			relation();
			setState(97);
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
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public List<AttributContext> attribut() {
			return getRuleContexts(AttributContext.class);
		}
		public AttributContext attribut(int i) {
			return getRuleContext(AttributContext.class,i);
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
		enterRule(_localctx, 18, RULE_project);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(PROJECT);
			setState(100);
			match(T__2);
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(101);
					attribut();
					setState(102);
					match(T__4);
					}
					break;
				case 2:
					{
					setState(104);
					attribut();
					}
					break;
				}
				}
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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
		enterRule(_localctx, 20, RULE_cartesian);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__0);
			setState(115);
			relation();
			setState(116);
			match(T__1);
			setState(122); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(117);
				match(CARTESIAN);
				setState(118);
				match(T__0);
				setState(119);
				relation();
				setState(120);
				match(T__1);
				}
				}
				setState(124); 
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
		public TerminalNode JOIN() { return getToken(RelAlgebraParser.JOIN, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
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
		enterRule(_localctx, 22, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__0);
			setState(127);
			relation();
			setState(128);
			match(T__1);
			setState(129);
			match(JOIN);
			setState(130);
			match(T__2);
			setState(131);
			predicate();
			setState(132);
			match(T__3);
			setState(133);
			match(T__0);
			setState(134);
			relation();
			setState(135);
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
		enterRule(_localctx, 24, RULE_attribut);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(137);
				match(ID);
				setState(138);
				match(T__5);
				}
				break;
			}
			setState(141);
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
		enterRule(_localctx, 26, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
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

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u0096\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\5\tT\n\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\7\n\\\n\n\f\n\16\n_\13\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\6\13l\n\13\r\13\16\13m\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f}\n\f\r\f\16\f~\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\5\16\u008e\n\16\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\4\3\2\t"+
		"\r\3\2\16\20\2\u0094\2 \3\2\2\2\4+\3\2\2\2\6-\3\2\2\2\b\65\3\2\2\2\n="+
		"\3\2\2\2\fE\3\2\2\2\16M\3\2\2\2\20S\3\2\2\2\22U\3\2\2\2\24e\3\2\2\2\26"+
		"t\3\2\2\2\30\u0080\3\2\2\2\32\u008d\3\2\2\2\34\u0091\3\2\2\2\36\u0093"+
		"\3\2\2\2 !\5\4\3\2!\3\3\2\2\2\",\5\22\n\2#,\5\24\13\2$,\5\26\f\2%,\5\30"+
		"\r\2&,\5\f\7\2\',\5\n\6\2(,\5\b\5\2),\5\6\4\2*,\7\2\2\3+\"\3\2\2\2+#\3"+
		"\2\2\2+$\3\2\2\2+%\3\2\2\2+&\3\2\2\2+\'\3\2\2\2+(\3\2\2\2+)\3\2\2\2+*"+
		"\3\2\2\2,\5\3\2\2\2-.\7\3\2\2./\5\20\t\2/\60\7\4\2\2\60\61\7\30\2\2\61"+
		"\62\7\3\2\2\62\63\5\20\t\2\63\64\7\4\2\2\64\7\3\2\2\2\65\66\7\3\2\2\66"+
		"\67\5\20\t\2\678\7\4\2\289\7\27\2\29:\7\3\2\2:;\5\20\t\2;<\7\4\2\2<\t"+
		"\3\2\2\2=>\7\3\2\2>?\5\20\t\2?@\7\4\2\2@A\7\26\2\2AB\7\3\2\2BC\5\20\t"+
		"\2CD\7\4\2\2D\13\3\2\2\2EF\7\25\2\2FG\7\5\2\2GH\7\31\2\2HI\7\6\2\2IJ\7"+
		"\3\2\2JK\5\20\t\2KL\7\4\2\2L\r\3\2\2\2MN\5\32\16\2NO\5\34\17\2OP\5\32"+
		"\16\2P\17\3\2\2\2QT\7\31\2\2RT\5\4\3\2SQ\3\2\2\2SR\3\2\2\2T\21\3\2\2\2"+
		"UV\7\21\2\2VW\7\5\2\2W]\5\16\b\2XY\5\36\20\2YZ\5\16\b\2Z\\\3\2\2\2[X\3"+
		"\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\6\2\2ab"+
		"\7\3\2\2bc\5\20\t\2cd\7\4\2\2d\23\3\2\2\2ef\7\22\2\2fk\7\5\2\2gh\5\32"+
		"\16\2hi\7\7\2\2il\3\2\2\2jl\5\32\16\2kg\3\2\2\2kj\3\2\2\2lm\3\2\2\2mk"+
		"\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\6\2\2pq\7\3\2\2qr\5\20\t\2rs\7\4\2\2"+
		"s\25\3\2\2\2tu\7\3\2\2uv\5\20\t\2v|\7\4\2\2wx\7\24\2\2xy\7\3\2\2yz\5\20"+
		"\t\2z{\7\4\2\2{}\3\2\2\2|w\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177"+
		"\27\3\2\2\2\u0080\u0081\7\3\2\2\u0081\u0082\5\20\t\2\u0082\u0083\7\4\2"+
		"\2\u0083\u0084\7\23\2\2\u0084\u0085\7\5\2\2\u0085\u0086\5\16\b\2\u0086"+
		"\u0087\7\6\2\2\u0087\u0088\7\3\2\2\u0088\u0089\5\20\t\2\u0089\u008a\7"+
		"\4\2\2\u008a\31\3\2\2\2\u008b\u008c\7\31\2\2\u008c\u008e\7\b\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7\31"+
		"\2\2\u0090\33\3\2\2\2\u0091\u0092\t\2\2\2\u0092\35\3\2\2\2\u0093\u0094"+
		"\t\3\2\2\u0094\37\3\2\2\2\t+S]km~\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}