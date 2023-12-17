// Generated from C:/IntelliJ_Projects/aufgaben-ubs/src/main/java/antlr4/aufgabenSet6/StackInterpreter/Assembler.g4 by ANTLR 4.13.1
package antlr4.aufgabenSet6.StackInterpreter;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AssemblerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, REG=8, ID=9, FUNC=10, 
		INT=11, CHAR=12, STRING=13, FLOAT=14, WS=15, NEWLINE=16;
	public static final int
		RULE_program = 0, RULE_globals = 1, RULE_functionDeclaration = 2, RULE_instr = 3, 
		RULE_operand = 4, RULE_label = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "globals", "functionDeclaration", "instr", "operand", "label"
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

	@Override
	public String getGrammarFileName() { return "Assembler.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    // Define the functionality required by the parser for code generation
	    protected void gen(Token instrToken) {;}
	    protected void gen(Token instrToken, Token operandToken) {;}
	    protected void gen(Token instrToken, Token oToken1, Token oToken2) {;}
	    protected void gen(Token instrToken, Token oToken1, Token oToken2, Token oToken3) {;}
	    protected void checkForUnresolvedReferences() {;}
	    protected void defineFunction(Token idToken, int nargs, int nlocals) {;}
	    protected void defineDataSize(int n) {;}
	    protected void defineLabel(Token idToken) {;}

	public AssemblerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public GlobalsContext globals() {
			return getRuleContext(GlobalsContext.class,0);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public List<InstrContext> instr() {
			return getRuleContexts(InstrContext.class);
		}
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(AssemblerParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AssemblerParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(12);
				globals();
				}
				break;
			}
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(19);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(15);
					functionDeclaration();
					}
					break;
				case 2:
					{
					setState(16);
					instr();
					}
					break;
				case 3:
					{
					setState(17);
					label();
					}
					break;
				case 4:
					{
					setState(18);
					match(NEWLINE);
					}
					break;
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 66052L) != 0) );
			checkForUnresolvedReferences();
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

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalsContext extends ParserRuleContext {
		public Token INT;
		public TerminalNode INT() { return getToken(AssemblerParser.INT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(AssemblerParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AssemblerParser.NEWLINE, i);
		}
		public GlobalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).enterGlobals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).exitGlobals(this);
		}
	}

	public final GlobalsContext globals() throws RecognitionException {
		GlobalsContext _localctx = new GlobalsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(25);
				match(NEWLINE);
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
			match(T__0);
			setState(32);
			((GlobalsContext)_localctx).INT = match(INT);
			setState(33);
			match(NEWLINE);
			defineDataSize((((GlobalsContext)_localctx).INT!=null?Integer.valueOf(((GlobalsContext)_localctx).INT.getText()):0));
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public Token name;
		public Token a;
		public Token lo;
		public TerminalNode NEWLINE() { return getToken(AssemblerParser.NEWLINE, 0); }
		public TerminalNode ID() { return getToken(AssemblerParser.ID, 0); }
		public List<TerminalNode> INT() { return getTokens(AssemblerParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(AssemblerParser.INT, i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__1);
			setState(37);
			((FunctionDeclarationContext)_localctx).name = match(ID);
			setState(38);
			match(T__2);
			setState(39);
			match(T__3);
			setState(40);
			match(T__4);
			setState(41);
			((FunctionDeclarationContext)_localctx).a = match(INT);
			setState(42);
			match(T__5);
			setState(43);
			match(T__6);
			setState(44);
			match(T__4);
			setState(45);
			((FunctionDeclarationContext)_localctx).lo = match(INT);
			setState(46);
			match(NEWLINE);
			defineFunction(((FunctionDeclarationContext)_localctx).name, (((FunctionDeclarationContext)_localctx).a!=null?Integer.valueOf(((FunctionDeclarationContext)_localctx).a.getText()):0), (((FunctionDeclarationContext)_localctx).lo!=null?Integer.valueOf(((FunctionDeclarationContext)_localctx).lo.getText()):0));
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstrContext extends ParserRuleContext {
		public Token ID;
		public OperandContext operand;
		public OperandContext a;
		public OperandContext b;
		public OperandContext c;
		public TerminalNode ID() { return getToken(AssemblerParser.ID, 0); }
		public TerminalNode NEWLINE() { return getToken(AssemblerParser.NEWLINE, 0); }
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public InstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).enterInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).exitInstr(this);
		}
	}

	public final InstrContext instr() throws RecognitionException {
		InstrContext _localctx = new InstrContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instr);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				((InstrContext)_localctx).ID = match(ID);
				setState(50);
				match(NEWLINE);
				gen(((InstrContext)_localctx).ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				((InstrContext)_localctx).ID = match(ID);
				setState(53);
				((InstrContext)_localctx).operand = operand();
				setState(54);
				match(NEWLINE);
				gen(((InstrContext)_localctx).ID,(((InstrContext)_localctx).operand!=null?(((InstrContext)_localctx).operand.start):null));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				((InstrContext)_localctx).ID = match(ID);
				setState(58);
				((InstrContext)_localctx).a = operand();
				setState(59);
				match(T__5);
				setState(60);
				((InstrContext)_localctx).b = operand();
				setState(61);
				match(NEWLINE);
				gen(((InstrContext)_localctx).ID,(((InstrContext)_localctx).a!=null?(((InstrContext)_localctx).a.start):null),(((InstrContext)_localctx).b!=null?(((InstrContext)_localctx).b.start):null));
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				((InstrContext)_localctx).ID = match(ID);
				setState(65);
				((InstrContext)_localctx).a = operand();
				setState(66);
				match(T__5);
				setState(67);
				((InstrContext)_localctx).b = operand();
				setState(68);
				match(T__5);
				setState(69);
				((InstrContext)_localctx).c = operand();
				setState(70);
				match(NEWLINE);
				gen(((InstrContext)_localctx).ID,(((InstrContext)_localctx).a!=null?(((InstrContext)_localctx).a.start):null),(((InstrContext)_localctx).b!=null?(((InstrContext)_localctx).b.start):null),(((InstrContext)_localctx).c!=null?(((InstrContext)_localctx).c.start):null));
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

	@SuppressWarnings("CheckReturnValue")
	public static class OperandContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AssemblerParser.ID, 0); }
		public TerminalNode REG() { return getToken(AssemblerParser.REG, 0); }
		public TerminalNode FUNC() { return getToken(AssemblerParser.FUNC, 0); }
		public TerminalNode INT() { return getToken(AssemblerParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(AssemblerParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(AssemblerParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(AssemblerParser.FLOAT, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32512L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class LabelContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(AssemblerParser.ID, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblerListener ) ((AssemblerListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			((LabelContext)_localctx).ID = match(ID);
			setState(78);
			match(T__2);
			defineLabel(((LabelContext)_localctx).ID);
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
		"\u0004\u0001\u0010R\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0003\u0000\u000e\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u0014\b\u0000\u000b\u0000\f"+
		"\u0000\u0015\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001\u001b\b\u0001"+
		"\n\u0001\f\u0001\u001e\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003J\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0000"+
		"\u0000\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0001\u0001\u0000\b\u000e"+
		"T\u0000\r\u0001\u0000\u0000\u0000\u0002\u001c\u0001\u0000\u0000\u0000"+
		"\u0004$\u0001\u0000\u0000\u0000\u0006I\u0001\u0000\u0000\u0000\bK\u0001"+
		"\u0000\u0000\u0000\nM\u0001\u0000\u0000\u0000\f\u000e\u0003\u0002\u0001"+
		"\u0000\r\f\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e"+
		"\u0013\u0001\u0000\u0000\u0000\u000f\u0014\u0003\u0004\u0002\u0000\u0010"+
		"\u0014\u0003\u0006\u0003\u0000\u0011\u0014\u0003\n\u0005\u0000\u0012\u0014"+
		"\u0005\u0010\u0000\u0000\u0013\u000f\u0001\u0000\u0000\u0000\u0013\u0010"+
		"\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0013\u0012"+
		"\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0013"+
		"\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0017"+
		"\u0001\u0000\u0000\u0000\u0017\u0018\u0006\u0000\uffff\uffff\u0000\u0018"+
		"\u0001\u0001\u0000\u0000\u0000\u0019\u001b\u0005\u0010\u0000\u0000\u001a"+
		"\u0019\u0001\u0000\u0000\u0000\u001b\u001e\u0001\u0000\u0000\u0000\u001c"+
		"\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d"+
		"\u001f\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001f"+
		" \u0005\u0001\u0000\u0000 !\u0005\u000b\u0000\u0000!\"\u0005\u0010\u0000"+
		"\u0000\"#\u0006\u0001\uffff\uffff\u0000#\u0003\u0001\u0000\u0000\u0000"+
		"$%\u0005\u0002\u0000\u0000%&\u0005\t\u0000\u0000&\'\u0005\u0003\u0000"+
		"\u0000\'(\u0005\u0004\u0000\u0000()\u0005\u0005\u0000\u0000)*\u0005\u000b"+
		"\u0000\u0000*+\u0005\u0006\u0000\u0000+,\u0005\u0007\u0000\u0000,-\u0005"+
		"\u0005\u0000\u0000-.\u0005\u000b\u0000\u0000./\u0005\u0010\u0000\u0000"+
		"/0\u0006\u0002\uffff\uffff\u00000\u0005\u0001\u0000\u0000\u000012\u0005"+
		"\t\u0000\u000023\u0005\u0010\u0000\u00003J\u0006\u0003\uffff\uffff\u0000"+
		"45\u0005\t\u0000\u000056\u0003\b\u0004\u000067\u0005\u0010\u0000\u0000"+
		"78\u0006\u0003\uffff\uffff\u00008J\u0001\u0000\u0000\u00009:\u0005\t\u0000"+
		"\u0000:;\u0003\b\u0004\u0000;<\u0005\u0006\u0000\u0000<=\u0003\b\u0004"+
		"\u0000=>\u0005\u0010\u0000\u0000>?\u0006\u0003\uffff\uffff\u0000?J\u0001"+
		"\u0000\u0000\u0000@A\u0005\t\u0000\u0000AB\u0003\b\u0004\u0000BC\u0005"+
		"\u0006\u0000\u0000CD\u0003\b\u0004\u0000DE\u0005\u0006\u0000\u0000EF\u0003"+
		"\b\u0004\u0000FG\u0005\u0010\u0000\u0000GH\u0006\u0003\uffff\uffff\u0000"+
		"HJ\u0001\u0000\u0000\u0000I1\u0001\u0000\u0000\u0000I4\u0001\u0000\u0000"+
		"\u0000I9\u0001\u0000\u0000\u0000I@\u0001\u0000\u0000\u0000J\u0007\u0001"+
		"\u0000\u0000\u0000KL\u0007\u0000\u0000\u0000L\t\u0001\u0000\u0000\u0000"+
		"MN\u0005\t\u0000\u0000NO\u0005\u0003\u0000\u0000OP\u0006\u0005\uffff\uffff"+
		"\u0000P\u000b\u0001\u0000\u0000\u0000\u0005\r\u0013\u0015\u001cI";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}