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
		T__0=1, T__1=2, T__2=3, T__3=4, MUL=5, DIV=6, ADD=7, SUB=8, POW=9, IF=10, 
		ELSE=11, EQUAL=12, LESS=13, GREATER=14, CONDITIONAL=15, COLON=16, ASSIGN=17, 
		ID=18, INT=19, OTHER=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "MUL", "DIV", "ADD", "SUB", "POW", "IF", 
			"ELSE", "EQUAL", "LESS", "GREATER", "CONDITIONAL", "COLON", "ASSIGN", 
			"ID", "INT", "OTHER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\n'", "'clear'", "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'^'", 
			"'if'", "'else'", "'=='", "'<'", "'>'", "'?'", "':'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "MUL", "DIV", "ADD", "SUB", "POW", "IF", 
			"ELSE", "EQUAL", "LESS", "GREATER", "CONDITIONAL", "COLON", "ASSIGN", 
			"ID", "INT", "OTHER"
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
		"\u0004\u0000\u0014b\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0004\u0011V\b\u0011\u000b\u0011\f\u0011W\u0001\u0012\u0004"+
		"\u0012[\b\u0012\u000b\u0012\f\u0012\\\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0000\u0000\u0014\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014\u0001\u0000\u0002\u0002\u0000AZaz\u0001\u000009c\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0001)\u0001\u0000\u0000\u0000\u0003+\u0001"+
		"\u0000\u0000\u0000\u00051\u0001\u0000\u0000\u0000\u00073\u0001\u0000\u0000"+
		"\u0000\t5\u0001\u0000\u0000\u0000\u000b7\u0001\u0000\u0000\u0000\r9\u0001"+
		"\u0000\u0000\u0000\u000f;\u0001\u0000\u0000\u0000\u0011=\u0001\u0000\u0000"+
		"\u0000\u0013?\u0001\u0000\u0000\u0000\u0015B\u0001\u0000\u0000\u0000\u0017"+
		"G\u0001\u0000\u0000\u0000\u0019J\u0001\u0000\u0000\u0000\u001bL\u0001"+
		"\u0000\u0000\u0000\u001dN\u0001\u0000\u0000\u0000\u001fP\u0001\u0000\u0000"+
		"\u0000!R\u0001\u0000\u0000\u0000#U\u0001\u0000\u0000\u0000%Z\u0001\u0000"+
		"\u0000\u0000\'^\u0001\u0000\u0000\u0000)*\u0005\n\u0000\u0000*\u0002\u0001"+
		"\u0000\u0000\u0000+,\u0005c\u0000\u0000,-\u0005l\u0000\u0000-.\u0005e"+
		"\u0000\u0000./\u0005a\u0000\u0000/0\u0005r\u0000\u00000\u0004\u0001\u0000"+
		"\u0000\u000012\u0005(\u0000\u00002\u0006\u0001\u0000\u0000\u000034\u0005"+
		")\u0000\u00004\b\u0001\u0000\u0000\u000056\u0005*\u0000\u00006\n\u0001"+
		"\u0000\u0000\u000078\u0005/\u0000\u00008\f\u0001\u0000\u0000\u00009:\u0005"+
		"+\u0000\u0000:\u000e\u0001\u0000\u0000\u0000;<\u0005-\u0000\u0000<\u0010"+
		"\u0001\u0000\u0000\u0000=>\u0005^\u0000\u0000>\u0012\u0001\u0000\u0000"+
		"\u0000?@\u0005i\u0000\u0000@A\u0005f\u0000\u0000A\u0014\u0001\u0000\u0000"+
		"\u0000BC\u0005e\u0000\u0000CD\u0005l\u0000\u0000DE\u0005s\u0000\u0000"+
		"EF\u0005e\u0000\u0000F\u0016\u0001\u0000\u0000\u0000GH\u0005=\u0000\u0000"+
		"HI\u0005=\u0000\u0000I\u0018\u0001\u0000\u0000\u0000JK\u0005<\u0000\u0000"+
		"K\u001a\u0001\u0000\u0000\u0000LM\u0005>\u0000\u0000M\u001c\u0001\u0000"+
		"\u0000\u0000NO\u0005?\u0000\u0000O\u001e\u0001\u0000\u0000\u0000PQ\u0005"+
		":\u0000\u0000Q \u0001\u0000\u0000\u0000RS\u0005=\u0000\u0000S\"\u0001"+
		"\u0000\u0000\u0000TV\u0007\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000"+
		"VW\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000X$\u0001\u0000\u0000\u0000Y[\u0007\u0001\u0000\u0000ZY\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]"+
		"\u0001\u0000\u0000\u0000]&\u0001\u0000\u0000\u0000^_\t\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`a\u0006\u0013\u0000\u0000a(\u0001\u0000\u0000"+
		"\u0000\u0003\u0000W\\\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}