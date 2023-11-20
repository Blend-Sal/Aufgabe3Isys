// Generated from pTListener.g4 by ANTLR 4.13.1
package antlr4.kalkulator.parseTreeListener;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class pTListenerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, INT=3, CLEAR=4, ID=5, QSTMARK=6, COLON=7, POT=8, MUL=9, 
		DIV=10, ADD=11, SUB=12, EQUALS=13, GREATERTHAN=14, LESSTHAN=15, ASSIGN=16, 
		NEWLINE=17, OTHER=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "INT", "CLEAR", "ID", "QSTMARK", "COLON", "POT", "MUL", 
			"DIV", "ADD", "SUB", "EQUALS", "GREATERTHAN", "LESSTHAN", "ASSIGN", "NEWLINE", 
			"OTHER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", null, "'clear'", null, "'?'", "':'", "'^'", "'*'", 
			"'/'", "'+'", "'-'", "'=='", "'<'", "'>'", "'='", "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "INT", "CLEAR", "ID", "QSTMARK", "COLON", "POT", "MUL", 
			"DIV", "ADD", "SUB", "EQUALS", "GREATERTHAN", "LESSTHAN", "ASSIGN", "NEWLINE", 
			"OTHER"
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


	public pTListenerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "pTListener.g4"; }

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
		"\u0004\u0000\u0012V\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002+\b"+
		"\u0002\u000b\u0002\f\u0002,\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u00046\b\u0004\u000b"+
		"\u0004\f\u00047\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012\u0001\u0000\u0002\u0001\u000009\u0002\u0000AZazW\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0001%\u0001\u0000\u0000"+
		"\u0000\u0003\'\u0001\u0000\u0000\u0000\u0005*\u0001\u0000\u0000\u0000"+
		"\u0007.\u0001\u0000\u0000\u0000\t5\u0001\u0000\u0000\u0000\u000b9\u0001"+
		"\u0000\u0000\u0000\r;\u0001\u0000\u0000\u0000\u000f=\u0001\u0000\u0000"+
		"\u0000\u0011?\u0001\u0000\u0000\u0000\u0013A\u0001\u0000\u0000\u0000\u0015"+
		"C\u0001\u0000\u0000\u0000\u0017E\u0001\u0000\u0000\u0000\u0019G\u0001"+
		"\u0000\u0000\u0000\u001bJ\u0001\u0000\u0000\u0000\u001dL\u0001\u0000\u0000"+
		"\u0000\u001fN\u0001\u0000\u0000\u0000!P\u0001\u0000\u0000\u0000#R\u0001"+
		"\u0000\u0000\u0000%&\u0005(\u0000\u0000&\u0002\u0001\u0000\u0000\u0000"+
		"\'(\u0005)\u0000\u0000(\u0004\u0001\u0000\u0000\u0000)+\u0007\u0000\u0000"+
		"\u0000*)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,*\u0001\u0000"+
		"\u0000\u0000,-\u0001\u0000\u0000\u0000-\u0006\u0001\u0000\u0000\u0000"+
		"./\u0005c\u0000\u0000/0\u0005l\u0000\u000001\u0005e\u0000\u000012\u0005"+
		"a\u0000\u000023\u0005r\u0000\u00003\b\u0001\u0000\u0000\u000046\u0007"+
		"\u0001\u0000\u000054\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"75\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008\n\u0001\u0000\u0000"+
		"\u00009:\u0005?\u0000\u0000:\f\u0001\u0000\u0000\u0000;<\u0005:\u0000"+
		"\u0000<\u000e\u0001\u0000\u0000\u0000=>\u0005^\u0000\u0000>\u0010\u0001"+
		"\u0000\u0000\u0000?@\u0005*\u0000\u0000@\u0012\u0001\u0000\u0000\u0000"+
		"AB\u0005/\u0000\u0000B\u0014\u0001\u0000\u0000\u0000CD\u0005+\u0000\u0000"+
		"D\u0016\u0001\u0000\u0000\u0000EF\u0005-\u0000\u0000F\u0018\u0001\u0000"+
		"\u0000\u0000GH\u0005=\u0000\u0000HI\u0005=\u0000\u0000I\u001a\u0001\u0000"+
		"\u0000\u0000JK\u0005<\u0000\u0000K\u001c\u0001\u0000\u0000\u0000LM\u0005"+
		">\u0000\u0000M\u001e\u0001\u0000\u0000\u0000NO\u0005=\u0000\u0000O \u0001"+
		"\u0000\u0000\u0000PQ\u0005\n\u0000\u0000Q\"\u0001\u0000\u0000\u0000RS"+
		"\t\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0006\u0011\u0000\u0000"+
		"U$\u0001\u0000\u0000\u0000\u0003\u0000,7\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}