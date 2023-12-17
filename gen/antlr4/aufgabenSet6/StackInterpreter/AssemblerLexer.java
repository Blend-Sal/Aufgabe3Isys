// Generated from C:/IntelliJ_Projects/aufgaben-ubs/src/main/java/antlr4/aufgabenSet6/StackInterpreter/Assembler.g4 by ANTLR 4.13.1
package antlr4.aufgabenSet6.StackInterpreter;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AssemblerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, REG=8, ID=9, FUNC=10, 
		INT=11, CHAR=12, STRING=13, FLOAT=14, WS=15, NEWLINE=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "REG", "ID", 
			"FUNC", "LETTER", "INT", "CHAR", "STRING", "STR_CHARS", "FLOAT", "WS", 
			"NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.globals'", "'.def'", "':'", "'args'", "'='", "','", "'locals'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "REG", "ID", "FUNC", 
			"INT", "CHAR", "STRING", "FLOAT", "WS", "NEWLINE"
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


	    // Define the functionality required by the parser for code generation
	    protected void gen(Token instrToken) {;}
	    protected void gen(Token instrToken, Token operandToken) {;}
	    protected void gen(Token instrToken, Token oToken1, Token oToken2) {;}
	    protected void gen(Token instrToken, Token oToken1, Token oToken2, Token oToken3) {;}
	    protected void checkForUnresolvedReferences() {;}
	    protected void defineFunction(Token idToken, int nargs, int nlocals) {;}
	    protected void defineDataSize(int n) {;}
	    protected void defineLabel(Token idToken) {;}


	public AssemblerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Assembler.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 9:
			FUNC_action((RuleContext)_localctx, actionIndex);
			break;
		case 13:
			STRING_action((RuleContext)_localctx, actionIndex);
			break;
		case 16:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void FUNC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			String text = getText(); setText(text.substring(0, text.length() - 2));
			break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			String text = getText(); setText(text.substring(1, text.length() - 1));
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u0010\u0094\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0005\bL\b\b\n\b\f\bO\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0003\u000bZ\b\u000b\u0001\u000b"+
		"\u0004\u000b]\b\u000b\u000b\u000b\f\u000b^\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0005\u000ek\b"+
		"\u000e\n\u000e\f\u000en\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000fs\b\u000f\n\u000f\f\u000fv\t\u000f\u0001\u000f\u0001\u000f\u0004"+
		"\u000fz\b\u000f\u000b\u000f\f\u000f{\u0003\u000f~\b\u000f\u0001\u0010"+
		"\u0004\u0010\u0081\b\u0010\u000b\u0010\f\u0010\u0082\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u0089\b\u0011\n\u0011\f\u0011"+
		"\u008c\t\u0011\u0003\u0011\u008e\b\u0011\u0001\u0011\u0003\u0011\u0091"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u008a\u0000\u0012\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u0000\u0017\u000b\u0019\f\u001b\r\u001d\u0000\u001f\u000e"+
		"!\u000f#\u0010\u0001\u0000\u0003\u0002\u0000AZaz\u0001\u0000\"\"\u0002"+
		"\u0000\t\t  \u009d\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0001"+
		"%\u0001\u0000\u0000\u0000\u0003.\u0001\u0000\u0000\u0000\u00053\u0001"+
		"\u0000\u0000\u0000\u00075\u0001\u0000\u0000\u0000\t:\u0001\u0000\u0000"+
		"\u0000\u000b<\u0001\u0000\u0000\u0000\r>\u0001\u0000\u0000\u0000\u000f"+
		"E\u0001\u0000\u0000\u0000\u0011H\u0001\u0000\u0000\u0000\u0013P\u0001"+
		"\u0000\u0000\u0000\u0015V\u0001\u0000\u0000\u0000\u0017Y\u0001\u0000\u0000"+
		"\u0000\u0019`\u0001\u0000\u0000\u0000\u001bd\u0001\u0000\u0000\u0000\u001d"+
		"l\u0001\u0000\u0000\u0000\u001f}\u0001\u0000\u0000\u0000!\u0080\u0001"+
		"\u0000\u0000\u0000#\u008d\u0001\u0000\u0000\u0000%&\u0005.\u0000\u0000"+
		"&\'\u0005g\u0000\u0000\'(\u0005l\u0000\u0000()\u0005o\u0000\u0000)*\u0005"+
		"b\u0000\u0000*+\u0005a\u0000\u0000+,\u0005l\u0000\u0000,-\u0005s\u0000"+
		"\u0000-\u0002\u0001\u0000\u0000\u0000./\u0005.\u0000\u0000/0\u0005d\u0000"+
		"\u000001\u0005e\u0000\u000012\u0005f\u0000\u00002\u0004\u0001\u0000\u0000"+
		"\u000034\u0005:\u0000\u00004\u0006\u0001\u0000\u0000\u000056\u0005a\u0000"+
		"\u000067\u0005r\u0000\u000078\u0005g\u0000\u000089\u0005s\u0000\u0000"+
		"9\b\u0001\u0000\u0000\u0000:;\u0005=\u0000\u0000;\n\u0001\u0000\u0000"+
		"\u0000<=\u0005,\u0000\u0000=\f\u0001\u0000\u0000\u0000>?\u0005l\u0000"+
		"\u0000?@\u0005o\u0000\u0000@A\u0005c\u0000\u0000AB\u0005a\u0000\u0000"+
		"BC\u0005l\u0000\u0000CD\u0005s\u0000\u0000D\u000e\u0001\u0000\u0000\u0000"+
		"EF\u0005r\u0000\u0000FG\u0003\u0017\u000b\u0000G\u0010\u0001\u0000\u0000"+
		"\u0000HM\u0003\u0015\n\u0000IL\u0003\u0015\n\u0000JL\u000209\u0000KI\u0001"+
		"\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000\u0000"+
		"MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u0012\u0001\u0000"+
		"\u0000\u0000OM\u0001\u0000\u0000\u0000PQ\u0003\u0011\b\u0000QR\u0005("+
		"\u0000\u0000RS\u0005)\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0006\t"+
		"\u0000\u0000U\u0014\u0001\u0000\u0000\u0000VW\u0007\u0000\u0000\u0000"+
		"W\u0016\u0001\u0000\u0000\u0000XZ\u0005-\u0000\u0000YX\u0001\u0000\u0000"+
		"\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000[]\u000209"+
		"\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_\u0018\u0001\u0000\u0000\u0000"+
		"`a\u0005\'\u0000\u0000ab\t\u0000\u0000\u0000bc\u0005\'\u0000\u0000c\u001a"+
		"\u0001\u0000\u0000\u0000de\u0005\"\u0000\u0000ef\u0003\u001d\u000e\u0000"+
		"fg\u0005\"\u0000\u0000gh\u0006\r\u0001\u0000h\u001c\u0001\u0000\u0000"+
		"\u0000ik\b\u0001\u0000\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000"+
		"\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\u001e\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0003\u0017\u000b\u0000"+
		"pt\u0005.\u0000\u0000qs\u0003\u0017\u000b\u0000rq\u0001\u0000\u0000\u0000"+
		"sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000u~\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wy\u0005.\u0000"+
		"\u0000xz\u0003\u0017\u000b\u0000yx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0001"+
		"\u0000\u0000\u0000}o\u0001\u0000\u0000\u0000}w\u0001\u0000\u0000\u0000"+
		"~ \u0001\u0000\u0000\u0000\u007f\u0081\u0007\u0002\u0000\u0000\u0080\u007f"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0006\u0010\u0002\u0000\u0085\"\u0001"+
		"\u0000\u0000\u0000\u0086\u008a\u0005;\u0000\u0000\u0087\u0089\t\u0000"+
		"\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000"+
		"\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000"+
		"\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000"+
		"\u0000\u0000\u008d\u0086\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u0091\u0005\r\u0000"+
		"\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0005\n\u0000\u0000"+
		"\u0093$\u0001\u0000\u0000\u0000\r\u0000KMY^lt{}\u0082\u008a\u008d\u0090"+
		"\u0003\u0001\t\u0000\u0001\r\u0001\u0001\u0010\u0002";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}