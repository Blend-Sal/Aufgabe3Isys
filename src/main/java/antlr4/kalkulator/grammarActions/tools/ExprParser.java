// Generated from Expr.g4 by ANTLR 4.13.1

 package antlr4.kalkulator.grammarActions.tools;
 import java.util.*;
 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, CONDITIONAL=3, COLON=4, CLEAR=5, MUL=6, DIV=7, ADD=8, 
		SUB=9, POW=10, EQUAL=11, LESS=12, GREATER=13, ASSIGN=14, IF=15, ELSE=16, 
		INT=17, ID=18, NEWLINE=19, OTHER=20;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_e = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "e"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'?'", "':'", "'clear'", "'*'", "'/'", "'+'", "'-'", 
			"'^'", "'=='", "'<'", "'>'", "'='", "'if'", "'else'", null, null, "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "CONDITIONAL", "COLON", "CLEAR", "MUL", "DIV", "ADD", 
			"SUB", "POW", "EQUAL", "LESS", "GREATER", "ASSIGN", "IF", "ELSE", "INT", 
			"ID", "NEWLINE", "OTHER"
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
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	 /** "memory" for our calculator; variable/value pairs go here */
	 Map<String, Integer> memory = new HashMap<String, Integer>();

	 int eval(int left, int op, int right) {
	 switch (op) {
	     case MUL: return left * right;
	     case DIV: return left / right;
	     case ADD: return left + right;
	     case SUB: return left - right;
	     case POW: return (int) Math.pow(left, right);
	     case EQUAL: return left == right ? 1 : 0;
	     case LESS: return left < right ? 1 : 0;
	     case GREATER: return left > right ? 1 : 0;
	     case CONDITIONAL: return right != 0 ? left : 0;
	     case ASSIGN: return right;
	 }
	 return 0;
	 }
	 
	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public int v;
		public StatContext stat;
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(6);
				((ProgContext)_localctx).stat = stat();
				}
				}
				setState(9); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 950306L) != 0) );
			((ProgContext)_localctx).v = ((ProgContext)_localctx).stat.v;
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
	public static class StatContext extends ParserRuleContext {
		public int v;
		public EContext e;
		public Token ID;
		public StatContext stat1;
		public StatContext stat2;
		public TerminalNode CLEAR() { return getToken(ExprParser.CLEAR, 0); }
		public TerminalNode NEWLINE() { return getToken(ExprParser.NEWLINE, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ExprParser.ASSIGN, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode IF() { return getToken(ExprParser.IF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ExprParser.ELSE, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				match(CLEAR);
				setState(14);
				match(NEWLINE);
				this.memory.clear(); ((StatContext)_localctx).v =  0;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(16);
				((StatContext)_localctx).e = e(0);
				setState(17);
				match(ASSIGN);
				setState(18);
				((StatContext)_localctx).ID = match(ID);
				this.memory.put((((StatContext)_localctx).ID!=null?((StatContext)_localctx).ID.getText():null), ((StatContext)_localctx).e.v);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(21);
				((StatContext)_localctx).e = e(0);
				setState(22);
				match(NEWLINE);
				System.out.println(((StatContext)_localctx).e.v); ((StatContext)_localctx).v =  ((StatContext)_localctx).e.v;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(25);
				match(IF);
				setState(26);
				match(T__0);
				setState(27);
				((StatContext)_localctx).e = e(0);
				setState(28);
				match(T__1);
				setState(29);
				((StatContext)_localctx).stat1 = stat();
				if (((StatContext)_localctx).e.v != 0) ((StatContext)_localctx).v =  ((StatContext)_localctx).stat1.v;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(32);
				match(IF);
				setState(33);
				match(T__0);
				setState(34);
				((StatContext)_localctx).e = e(0);
				setState(35);
				match(T__1);
				setState(36);
				((StatContext)_localctx).stat1 = stat();
				setState(37);
				match(ELSE);
				setState(38);
				((StatContext)_localctx).stat2 = stat();
				if (((StatContext)_localctx).e.v != 0) ((StatContext)_localctx).v =  ((StatContext)_localctx).stat1.v; else ((StatContext)_localctx).v =  ((StatContext)_localctx).stat2.v;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				match(NEWLINE);
				((StatContext)_localctx).v =  0;
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
	public static class EContext extends ParserRuleContext {
		public int v;
		public EContext a;
		public Token ID;
		public Token INT;
		public EContext e;
		public Token op;
		public EContext b;
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public List<EContext> e() {
			return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
			return getRuleContext(EContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ExprParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ExprParser.DIV, 0); }
		public TerminalNode POW() { return getToken(ExprParser.POW, 0); }
		public TerminalNode EQUAL() { return getToken(ExprParser.EQUAL, 0); }
		public TerminalNode LESS() { return getToken(ExprParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(ExprParser.GREATER, 0); }
		public TerminalNode CONDITIONAL() { return getToken(ExprParser.CONDITIONAL, 0); }
		public TerminalNode ASSIGN() { return getToken(ExprParser.ASSIGN, 0); }
		public TerminalNode ADD() { return getToken(ExprParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ExprParser.SUB, 0); }
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
	}

	public final EContext e() throws RecognitionException {
		return e(0);
	}

	private EContext e(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EContext _localctx = new EContext(_ctx, _parentState);
		EContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_e, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(46);
				((EContext)_localctx).ID = match(ID);
				((EContext)_localctx).v =  memory.get((((EContext)_localctx).ID!=null?((EContext)_localctx).ID.getText():null));
				}
				break;
			case INT:
				{
				setState(48);
				((EContext)_localctx).INT = match(INT);
				((EContext)_localctx).v =  Integer.parseInt((((EContext)_localctx).INT!=null?((EContext)_localctx).INT.getText():null));
				}
				break;
			case T__0:
				{
				setState(50);
				match(T__0);
				setState(51);
				((EContext)_localctx).e = e(0);
				setState(52);
				match(T__1);
				((EContext)_localctx).v =  ((EContext)_localctx).e.v;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(67);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(57);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(58);
						((EContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31944L) != 0)) ) {
							((EContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(59);
						((EContext)_localctx).b = ((EContext)_localctx).e = e(6);
						((EContext)_localctx).v =  eval(((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), ((EContext)_localctx).b.v);
						}
						break;
					case 2:
						{
						_localctx = new EContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_e);
						setState(62);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(63);
						((EContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((EContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(64);
						((EContext)_localctx).b = ((EContext)_localctx).e = e(5);
						((EContext)_localctx).v =  eval(((EContext)_localctx).a.v, (((EContext)_localctx).op!=null?((EContext)_localctx).op.getType():0), ((EContext)_localctx).b.v);
						}
						break;
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return e_sempred((EContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean e_sempred(EContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0014I\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0004\u0000\b\b\u0000\u000b\u0000\f\u0000"+
		"\t\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001,\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00028\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002D\b\u0002\n\u0002\f\u0002G\t\u0002"+
		"\u0001\u0002\u0000\u0001\u0004\u0003\u0000\u0002\u0004\u0000\u0002\u0003"+
		"\u0000\u0003\u0003\u0006\u0007\n\u000e\u0001\u0000\b\tO\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u00047\u0001\u0000\u0000"+
		"\u0000\u0006\b\u0003\u0002\u0001\u0000\u0007\u0006\u0001\u0000\u0000\u0000"+
		"\b\t\u0001\u0000\u0000\u0000\t\u0007\u0001\u0000\u0000\u0000\t\n\u0001"+
		"\u0000\u0000\u0000\n\u000b\u0001\u0000\u0000\u0000\u000b\f\u0006\u0000"+
		"\uffff\uffff\u0000\f\u0001\u0001\u0000\u0000\u0000\r\u000e\u0005\u0005"+
		"\u0000\u0000\u000e\u000f\u0005\u0013\u0000\u0000\u000f,\u0006\u0001\uffff"+
		"\uffff\u0000\u0010\u0011\u0003\u0004\u0002\u0000\u0011\u0012\u0005\u000e"+
		"\u0000\u0000\u0012\u0013\u0005\u0012\u0000\u0000\u0013\u0014\u0006\u0001"+
		"\uffff\uffff\u0000\u0014,\u0001\u0000\u0000\u0000\u0015\u0016\u0003\u0004"+
		"\u0002\u0000\u0016\u0017\u0005\u0013\u0000\u0000\u0017\u0018\u0006\u0001"+
		"\uffff\uffff\u0000\u0018,\u0001\u0000\u0000\u0000\u0019\u001a\u0005\u000f"+
		"\u0000\u0000\u001a\u001b\u0005\u0001\u0000\u0000\u001b\u001c\u0003\u0004"+
		"\u0002\u0000\u001c\u001d\u0005\u0002\u0000\u0000\u001d\u001e\u0003\u0002"+
		"\u0001\u0000\u001e\u001f\u0006\u0001\uffff\uffff\u0000\u001f,\u0001\u0000"+
		"\u0000\u0000 !\u0005\u000f\u0000\u0000!\"\u0005\u0001\u0000\u0000\"#\u0003"+
		"\u0004\u0002\u0000#$\u0005\u0002\u0000\u0000$%\u0003\u0002\u0001\u0000"+
		"%&\u0005\u0010\u0000\u0000&\'\u0003\u0002\u0001\u0000\'(\u0006\u0001\uffff"+
		"\uffff\u0000(,\u0001\u0000\u0000\u0000)*\u0005\u0013\u0000\u0000*,\u0006"+
		"\u0001\uffff\uffff\u0000+\r\u0001\u0000\u0000\u0000+\u0010\u0001\u0000"+
		"\u0000\u0000+\u0015\u0001\u0000\u0000\u0000+\u0019\u0001\u0000\u0000\u0000"+
		"+ \u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000,\u0003\u0001\u0000"+
		"\u0000\u0000-.\u0006\u0002\uffff\uffff\u0000./\u0005\u0012\u0000\u0000"+
		"/8\u0006\u0002\uffff\uffff\u000001\u0005\u0011\u0000\u000018\u0006\u0002"+
		"\uffff\uffff\u000023\u0005\u0001\u0000\u000034\u0003\u0004\u0002\u0000"+
		"45\u0005\u0002\u0000\u000056\u0006\u0002\uffff\uffff\u000068\u0001\u0000"+
		"\u0000\u00007-\u0001\u0000\u0000\u000070\u0001\u0000\u0000\u000072\u0001"+
		"\u0000\u0000\u00008E\u0001\u0000\u0000\u00009:\n\u0005\u0000\u0000:;\u0007"+
		"\u0000\u0000\u0000;<\u0003\u0004\u0002\u0006<=\u0006\u0002\uffff\uffff"+
		"\u0000=D\u0001\u0000\u0000\u0000>?\n\u0004\u0000\u0000?@\u0007\u0001\u0000"+
		"\u0000@A\u0003\u0004\u0002\u0005AB\u0006\u0002\uffff\uffff\u0000BD\u0001"+
		"\u0000\u0000\u0000C9\u0001\u0000\u0000\u0000C>\u0001\u0000\u0000\u0000"+
		"DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000"+
		"\u0000F\u0005\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000\u0005"+
		"\t+7CE";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}