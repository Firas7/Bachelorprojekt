// Generated from RelAlgebra.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RelAlgebraLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, SELECT=15, PROJECT=16, 
		JOIN=17, CARTESIAN=18, RENAME=19, UNION=20, INTERSECTION=21, DIFFERENCE=22, 
		ID=23, VALUE=24, AND=25, OR=26, ISNOT=27, WS=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "SELECT", "PROJECT", "JOIN", 
			"CARTESIAN", "RENAME", "UNION", "INTERSECTION", "DIFFERENCE", "ID", "VALUE", 
			"AND", "OR", "ISNOT", "WS", "A", "B", "C", "D", "E", "F", "G", "H", "I", 
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", 
			"X", "Y", "Z"
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


	public RelAlgebraLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RelAlgebra.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00f5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\30\3\30\7\30\u00a7\n\30\f\30\16\30\u00aa\13\30\3\31\3\31\7\31\u00ae\n"+
		"\31\f\31\16\31\u00b1\13\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\6\35\u00bc\n\35\r\35\16\35\u00bd\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 "+
		"\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64"+
		"\3\64\3\65\3\65\3\66\3\66\3\67\3\67\3\u00af\28\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\2=\2?\2A\2C\2E\2G\2I\2K"+
		"\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2\3\2\37\5\2\62;C"+
		"\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFf"+
		"f\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2"+
		"OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4"+
		"\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u00dd\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3o\3\2\2\2\5q\3\2\2\2\7s\3"+
		"\2\2\2\tu\3\2\2\2\13w\3\2\2\2\ry\3\2\2\2\17{\3\2\2\2\21}\3\2\2\2\23\177"+
		"\3\2\2\2\25\u0081\3\2\2\2\27\u0084\3\2\2\2\31\u0087\3\2\2\2\33\u008a\3"+
		"\2\2\2\35\u008c\3\2\2\2\37\u008e\3\2\2\2!\u0091\3\2\2\2#\u0094\3\2\2\2"+
		"%\u0097\3\2\2\2\'\u0099\3\2\2\2)\u009b\3\2\2\2+\u009e\3\2\2\2-\u00a1\3"+
		"\2\2\2/\u00a4\3\2\2\2\61\u00ab\3\2\2\2\63\u00b4\3\2\2\2\65\u00b6\3\2\2"+
		"\2\67\u00b8\3\2\2\29\u00bb\3\2\2\2;\u00c1\3\2\2\2=\u00c3\3\2\2\2?\u00c5"+
		"\3\2\2\2A\u00c7\3\2\2\2C\u00c9\3\2\2\2E\u00cb\3\2\2\2G\u00cd\3\2\2\2I"+
		"\u00cf\3\2\2\2K\u00d1\3\2\2\2M\u00d3\3\2\2\2O\u00d5\3\2\2\2Q\u00d7\3\2"+
		"\2\2S\u00d9\3\2\2\2U\u00db\3\2\2\2W\u00dd\3\2\2\2Y\u00df\3\2\2\2[\u00e1"+
		"\3\2\2\2]\u00e3\3\2\2\2_\u00e5\3\2\2\2a\u00e7\3\2\2\2c\u00e9\3\2\2\2e"+
		"\u00eb\3\2\2\2g\u00ed\3\2\2\2i\u00ef\3\2\2\2k\u00f1\3\2\2\2m\u00f3\3\2"+
		"\2\2op\7*\2\2p\4\3\2\2\2qr\7+\2\2r\6\3\2\2\2st\7]\2\2t\b\3\2\2\2uv\7_"+
		"\2\2v\n\3\2\2\2wx\7.\2\2x\f\3\2\2\2yz\7\60\2\2z\16\3\2\2\2{|\7?\2\2|\20"+
		"\3\2\2\2}~\7>\2\2~\22\3\2\2\2\177\u0080\7@\2\2\u0080\24\3\2\2\2\u0081"+
		"\u0082\7@\2\2\u0082\u0083\7?\2\2\u0083\26\3\2\2\2\u0084\u0085\7>\2\2\u0085"+
		"\u0086\7?\2\2\u0086\30\3\2\2\2\u0087\u0088\7#\2\2\u0088\u0089\7?\2\2\u0089"+
		"\32\3\2\2\2\u008a\u008b\7N\2\2\u008b\34\3\2\2\2\u008c\u008d\7H\2\2\u008d"+
		"\36\3\2\2\2\u008e\u008f\7U\2\2\u008f\u0090\7N\2\2\u0090 \3\2\2\2\u0091"+
		"\u0092\7R\2\2\u0092\u0093\7T\2\2\u0093\"\3\2\2\2\u0094\u0095\7L\2\2\u0095"+
		"\u0096\7P\2\2\u0096$\3\2\2\2\u0097\u0098\7Z\2\2\u0098&\3\2\2\2\u0099\u009a"+
		"\7T\2\2\u009a(\3\2\2\2\u009b\u009c\7W\2\2\u009c\u009d\7P\2\2\u009d*\3"+
		"\2\2\2\u009e\u009f\7K\2\2\u009f\u00a0\7P\2\2\u00a0,\3\2\2\2\u00a1\u00a2"+
		"\7F\2\2\u00a2\u00a3\7K\2\2\u00a3.\3\2\2\2\u00a4\u00a8\t\2\2\2\u00a5\u00a7"+
		"\t\3\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\60\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00af\7$\2\2"+
		"\u00ac\u00ae\13\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2"+
		"\u00b3\7$\2\2\u00b3\62\3\2\2\2\u00b4\u00b5\7(\2\2\u00b5\64\3\2\2\2\u00b6"+
		"\u00b7\7~\2\2\u00b7\66\3\2\2\2\u00b8\u00b9\7#\2\2\u00b98\3\2\2\2\u00ba"+
		"\u00bc\t\4\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\b\35\2\2\u00c0"+
		":\3\2\2\2\u00c1\u00c2\t\5\2\2\u00c2<\3\2\2\2\u00c3\u00c4\t\6\2\2\u00c4"+
		">\3\2\2\2\u00c5\u00c6\t\7\2\2\u00c6@\3\2\2\2\u00c7\u00c8\t\b\2\2\u00c8"+
		"B\3\2\2\2\u00c9\u00ca\t\t\2\2\u00caD\3\2\2\2\u00cb\u00cc\t\n\2\2\u00cc"+
		"F\3\2\2\2\u00cd\u00ce\t\13\2\2\u00ceH\3\2\2\2\u00cf\u00d0\t\f\2\2\u00d0"+
		"J\3\2\2\2\u00d1\u00d2\t\r\2\2\u00d2L\3\2\2\2\u00d3\u00d4\t\16\2\2\u00d4"+
		"N\3\2\2\2\u00d5\u00d6\t\17\2\2\u00d6P\3\2\2\2\u00d7\u00d8\t\20\2\2\u00d8"+
		"R\3\2\2\2\u00d9\u00da\t\21\2\2\u00daT\3\2\2\2\u00db\u00dc\t\22\2\2\u00dc"+
		"V\3\2\2\2\u00dd\u00de\t\23\2\2\u00deX\3\2\2\2\u00df\u00e0\t\24\2\2\u00e0"+
		"Z\3\2\2\2\u00e1\u00e2\t\25\2\2\u00e2\\\3\2\2\2\u00e3\u00e4\t\26\2\2\u00e4"+
		"^\3\2\2\2\u00e5\u00e6\t\27\2\2\u00e6`\3\2\2\2\u00e7\u00e8\t\30\2\2\u00e8"+
		"b\3\2\2\2\u00e9\u00ea\t\31\2\2\u00ead\3\2\2\2\u00eb\u00ec\t\32\2\2\u00ec"+
		"f\3\2\2\2\u00ed\u00ee\t\33\2\2\u00eeh\3\2\2\2\u00ef\u00f0\t\34\2\2\u00f0"+
		"j\3\2\2\2\u00f1\u00f2\t\35\2\2\u00f2l\3\2\2\2\u00f3\u00f4\t\36\2\2\u00f4"+
		"n\3\2\2\2\6\2\u00a8\u00af\u00bd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}