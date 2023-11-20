// Generated from LabeledExpr.g4 by ANTLR 4.13.1
package antlr4.kalkulator.parseTreeVisitor;
        import java.util.*;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LabeledExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, MUL=4, DIV=5, ADD=6, SUB=7, POW=8, EQUAL=9, LESS=10, 
		GREATER=11, CONDITIONAL=12, COLON=13, ASSIGN=14, ID=15, INT=16, OTHER=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "MUL", "DIV", "ADD", "SUB", "POW", "EQUAL", "LESS", 
			"GREATER", "CONDITIONAL", "COLON", "ASSIGN", "ID", "INT", "OTHER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\n'", "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'^'", "'=='", 
			"'<'", "'>'", "'?'", "':'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "MUL", "DIV", "ADD", "SUB", "POW", "EQUAL", "LESS", 
			"GREATER", "CONDITIONAL", "COLON", "ASSIGN", "ID", "INT", "OTHER"
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


	public LabeledExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LabeledExpr.g4"; }

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
		"\u0004\u0000\u0011N\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0004\u000eB\b\u000e\u000b\u000e\f\u000eC\u0001\u000f\u0004\u000fG\b"+
		"\u000f\u000b\u000f\f\u000fH\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0000\u0000\u0011\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011\u0001\u0000\u0002"+
		"\u0002\u0000AZaz\u0001\u000009O\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000"+
		"\u0000\u0003%\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000"+
		"\u0007)\u0001\u0000\u0000\u0000\t+\u0001\u0000\u0000\u0000\u000b-\u0001"+
		"\u0000\u0000\u0000\r/\u0001\u0000\u0000\u0000\u000f1\u0001\u0000\u0000"+
		"\u0000\u00113\u0001\u0000\u0000\u0000\u00136\u0001\u0000\u0000\u0000\u0015"+
		"8\u0001\u0000\u0000\u0000\u0017:\u0001\u0000\u0000\u0000\u0019<\u0001"+
		"\u0000\u0000\u0000\u001b>\u0001\u0000\u0000\u0000\u001dA\u0001\u0000\u0000"+
		"\u0000\u001fF\u0001\u0000\u0000\u0000!J\u0001\u0000\u0000\u0000#$\u0005"+
		"\n\u0000\u0000$\u0002\u0001\u0000\u0000\u0000%&\u0005(\u0000\u0000&\u0004"+
		"\u0001\u0000\u0000\u0000\'(\u0005)\u0000\u0000(\u0006\u0001\u0000\u0000"+
		"\u0000)*\u0005*\u0000\u0000*\b\u0001\u0000\u0000\u0000+,\u0005/\u0000"+
		"\u0000,\n\u0001\u0000\u0000\u0000-.\u0005+\u0000\u0000.\f\u0001\u0000"+
		"\u0000\u0000/0\u0005-\u0000\u00000\u000e\u0001\u0000\u0000\u000012\u0005"+
		"^\u0000\u00002\u0010\u0001\u0000\u0000\u000034\u0005=\u0000\u000045\u0005"+
		"=\u0000\u00005\u0012\u0001\u0000\u0000\u000067\u0005<\u0000\u00007\u0014"+
		"\u0001\u0000\u0000\u000089\u0005>\u0000\u00009\u0016\u0001\u0000\u0000"+
		"\u0000:;\u0005?\u0000\u0000;\u0018\u0001\u0000\u0000\u0000<=\u0005:\u0000"+
		"\u0000=\u001a\u0001\u0000\u0000\u0000>?\u0005=\u0000\u0000?\u001c\u0001"+
		"\u0000\u0000\u0000@B\u0007\u0000\u0000\u0000A@\u0001\u0000\u0000\u0000"+
		"BC\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000D\u001e\u0001\u0000\u0000\u0000EG\u0007\u0001\u0000\u0000FE\u0001"+
		"\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000"+
		"HI\u0001\u0000\u0000\u0000I \u0001\u0000\u0000\u0000JK\t\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000LM\u0006\u0010\u0000\u0000M\"\u0001\u0000\u0000"+
		"\u0000\u0003\u0000CH\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}