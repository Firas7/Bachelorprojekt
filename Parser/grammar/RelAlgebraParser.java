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
		T__0=1, T__1=2, SELECT=3, PROJECT=4, JOIN=5, CARTESIAN=6, PREDICATE=7, 
		RELATION=8, ATTRIBUT=9, WS=10;
	public static final int
		RULE_expression = 0, RULE_select = 1, RULE_project = 2, RULE_join = 3, 
		RULE_cartesian = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "select", "project", "join", "cartesian"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "SELECT", "PROJECT", "JOIN", "CARTESIAN", "PREDICATE", 
			"RELATION", "ATTRIBUT", "WS"
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

	public static class ExpressionContext extends ParserRuleContext {
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public ProjectContext project() {
			return getRuleContext(ProjectContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RelAlgebraParser.EOF, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelAlgebraListener ) ((RelAlgebraListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			setState(13);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				select();
				}
				break;
			case PROJECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(11);
				project();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 3);
				{
				setState(12);
				match(EOF);
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
		public TerminalNode PREDICATE() { return getToken(RelAlgebraParser.PREDICATE, 0); }
		public TerminalNode RELATION() { return getToken(RelAlgebraParser.RELATION, 0); }
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
		enterRule(_localctx, 2, RULE_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			match(SELECT);
			setState(16);
			match(PREDICATE);
			setState(17);
			match(T__0);
			setState(18);
			match(RELATION);
			setState(19);
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
		public TerminalNode RELATION() { return getToken(RelAlgebraParser.RELATION, 0); }
		public List<TerminalNode> ATTRIBUT() { return getTokens(RelAlgebraParser.ATTRIBUT); }
		public TerminalNode ATTRIBUT(int i) {
			return getToken(RelAlgebraParser.ATTRIBUT, i);
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
		enterRule(_localctx, 4, RULE_project);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(PROJECT);
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				match(ATTRIBUT);
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ATTRIBUT );
			setState(27);
			match(T__0);
			setState(28);
			match(RELATION);
			setState(29);
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

	public static class JoinContext extends ParserRuleContext {
		public TerminalNode JOIN() { return getToken(RelAlgebraParser.JOIN, 0); }
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
		enterRule(_localctx, 6, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(JOIN);
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
		public TerminalNode CARTESIAN() { return getToken(RelAlgebraParser.CARTESIAN, 0); }
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
		enterRule(_localctx, 8, RULE_cartesian);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(CARTESIAN);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f&\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\5\2\20\n\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\6\4\32\n\4\r\4\16\4\33\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\6\2\2\7\2\4\6\b\n\2\2\2#\2\17\3\2\2\2\4\21\3\2\2\2\6\27\3\2\2\2\b!\3"+
		"\2\2\2\n#\3\2\2\2\f\20\5\4\3\2\r\20\5\6\4\2\16\20\7\2\2\3\17\f\3\2\2\2"+
		"\17\r\3\2\2\2\17\16\3\2\2\2\20\3\3\2\2\2\21\22\7\5\2\2\22\23\7\t\2\2\23"+
		"\24\7\3\2\2\24\25\7\n\2\2\25\26\7\4\2\2\26\5\3\2\2\2\27\31\7\6\2\2\30"+
		"\32\7\13\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34"+
		"\35\3\2\2\2\35\36\7\3\2\2\36\37\7\n\2\2\37 \7\4\2\2 \7\3\2\2\2!\"\7\7"+
		"\2\2\"\t\3\2\2\2#$\7\b\2\2$\13\3\2\2\2\4\17\33";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}