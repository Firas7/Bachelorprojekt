// Generated from RelLex.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RelLex extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SL=1;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'"
	};
	public static final String[] ruleNames = {
		"SL", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
		"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};


	public RelLex(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RelLex.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\3t\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\2\2\35\3\3\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2"+
		"\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\2"+
		"\3\2\34\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJ"+
		"jj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2"+
		"SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4"+
		"\2\\\\||Y\2\3\3\2\2\2\39\3\2\2\2\5@\3\2\2\2\7B\3\2\2\2\tD\3\2\2\2\13F"+
		"\3\2\2\2\rH\3\2\2\2\17J\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25P\3\2\2\2\27"+
		"R\3\2\2\2\31T\3\2\2\2\33V\3\2\2\2\35X\3\2\2\2\37Z\3\2\2\2!\\\3\2\2\2#"+
		"^\3\2\2\2%`\3\2\2\2\'b\3\2\2\2)d\3\2\2\2+f\3\2\2\2-h\3\2\2\2/j\3\2\2\2"+
		"\61l\3\2\2\2\63n\3\2\2\2\65p\3\2\2\2\67r\3\2\2\29:\5)\25\2:;\5\r\7\2;"+
		"<\5\33\16\2<=\5\r\7\2=>\5\t\5\2>?\5+\26\2?\4\3\2\2\2@A\t\2\2\2A\6\3\2"+
		"\2\2BC\t\3\2\2C\b\3\2\2\2DE\t\4\2\2E\n\3\2\2\2FG\t\5\2\2G\f\3\2\2\2HI"+
		"\t\6\2\2I\16\3\2\2\2JK\t\7\2\2K\20\3\2\2\2LM\t\b\2\2M\22\3\2\2\2NO\t\t"+
		"\2\2O\24\3\2\2\2PQ\t\n\2\2Q\26\3\2\2\2RS\t\13\2\2S\30\3\2\2\2TU\t\f\2"+
		"\2U\32\3\2\2\2VW\t\r\2\2W\34\3\2\2\2XY\t\16\2\2Y\36\3\2\2\2Z[\t\17\2\2"+
		"[ \3\2\2\2\\]\t\20\2\2]\"\3\2\2\2^_\t\21\2\2_$\3\2\2\2`a\t\22\2\2a&\3"+
		"\2\2\2bc\t\23\2\2c(\3\2\2\2de\t\24\2\2e*\3\2\2\2fg\t\25\2\2g,\3\2\2\2"+
		"hi\t\26\2\2i.\3\2\2\2jk\t\27\2\2k\60\3\2\2\2lm\t\30\2\2m\62\3\2\2\2no"+
		"\t\31\2\2o\64\3\2\2\2pq\t\32\2\2q\66\3\2\2\2rs\t\33\2\2s8\3\2\2\2\3\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}