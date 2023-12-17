package antlr4.aufgabenSet6;
// Generated from Cymbol.g4 by ANTLR 4.13.1


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CymbolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, K_INT=31, 
		K_FLOAT=32, K_VOID=33, ID=34, INT=35, WS=36, SL_COMMENT=37;
	public static final int
		RULE_file = 0, RULE_include = 1, RULE_functionDecl = 2, RULE_formalParameters = 3, 
		RULE_formalParameter = 4, RULE_stat = 5, RULE_block = 6, RULE_assignStat = 7, 
		RULE_ifStat = 8, RULE_ifSingle = 9, RULE_ifElse = 10, RULE_forStat = 11, 
		RULE_whileStat = 12, RULE_returnStat = 13, RULE_args = 14, RULE_argsNone = 15, 
		RULE_argsSingle = 16, RULE_argsMul = 17, RULE_printStat = 18, RULE_varDecl = 19, 
		RULE_type = 20, RULE_expr = 21, RULE_bexpr = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "include", "functionDecl", "formalParameters", "formalParameter", 
			"stat", "block", "assignStat", "ifStat", "ifSingle", "ifElse", "forStat", 
			"whileStat", "returnStat", "args", "argsNone", "argsSingle", "argsMul", 
			"printStat", "varDecl", "type", "expr", "bexpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'#include'", "'<stdio.h>'", "'<stdbool.h>'", "'('", "')'", "','", 
			"';'", "'{'", "'}'", "'='", "'if'", "'else'", "'for'", "'while'", "'return'", 
			"'printf'", "'\"'", "'%d'", "'\\n'", "'-'", "'*'", "'/'", "'+'", "'!'", 
			"'=='", "'!='", "'<'", "'>'", "'true'", "'false'", "'int'", "'float'", 
			"'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "K_INT", "K_FLOAT", "K_VOID", 
			"ID", "INT", "WS", "SL_COMMENT"
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
	public String getGrammarFileName() { return "Cymbol.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CymbolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public List<IncludeContext> include() {
			return getRuleContexts(IncludeContext.class);
		}
		public IncludeContext include(int i) {
			return getRuleContext(IncludeContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(46);
				include();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(54);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(52);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(53);
					varDecl();
					}
					break;
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==K_INT || _la==K_FLOAT );
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
	public static class IncludeContext extends ParserRuleContext {
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitInclude(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_include);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__0);
			setState(59);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
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
	public static class FunctionDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CymbolParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			type();
			setState(62);
			match(ID);
			setState(63);
			match(T__3);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_INT || _la==K_FLOAT) {
				{
				setState(64);
				formalParameters();
				}
			}

			setState(67);
			match(T__4);
			setState(68);
			block();
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
	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitFormalParameters(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			formalParameter();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(71);
				match(T__5);
				setState(72);
				formalParameter();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class FormalParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CymbolParser.ID, 0); }
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitFormalParameter(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			type();
			setState(79);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public ForStatContext forStat() {
			return getRuleContext(ForStatContext.class,0);
		}
		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class,0);
		}
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public AssignStatContext assignStat() {
			return getRuleContext(AssignStatContext.class,0);
		}
		public PrintStatContext printStat() {
			return getRuleContext(PrintStatContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stat);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				varDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				ifStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				forStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				whileStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(86);
				returnStat();
				setState(87);
				match(T__6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(89);
				assignStat();
				setState(90);
				match(T__6);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(92);
				printStat();
				setState(93);
				match(T__6);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(95);
				expr(0);
				setState(96);
				match(T__6);
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
	public static class BlockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__7);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 57983232272L) != 0)) {
				{
				{
				setState(101);
				stat();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(T__8);
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
	public static class AssignStatContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CymbolParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitAssignStat(this);
		}
	}

	public final AssignStatContext assignStat() throws RecognitionException {
		AssignStatContext _localctx = new AssignStatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(ID);
			setState(110);
			match(T__9);
			setState(111);
			expr(0);
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
	public static class IfStatContext extends ParserRuleContext {
		public IfSingleContext ifSingle() {
			return getRuleContext(IfSingleContext.class,0);
		}
		public IfElseContext ifElse() {
			return getRuleContext(IfElseContext.class,0);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitIfStat(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStat);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				ifSingle();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				ifElse();
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
	public static class IfSingleContext extends ParserRuleContext {
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public IfSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifSingle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterIfSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitIfSingle(this);
		}
	}

	public final IfSingleContext ifSingle() throws RecognitionException {
		IfSingleContext _localctx = new IfSingleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifSingle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__10);
			setState(118);
			match(T__3);
			setState(119);
			bexpr();
			setState(120);
			match(T__4);
			setState(121);
			stat();
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
	public static class IfElseContext extends ParserRuleContext {
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public IfElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitIfElse(this);
		}
	}

	public final IfElseContext ifElse() throws RecognitionException {
		IfElseContext _localctx = new IfElseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifElse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__10);
			setState(124);
			match(T__3);
			setState(125);
			bexpr();
			setState(126);
			match(T__4);
			setState(127);
			stat();
			setState(128);
			match(T__11);
			setState(129);
			stat();
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
	public static class ForStatContext extends ParserRuleContext {
		public List<AssignStatContext> assignStat() {
			return getRuleContexts(AssignStatContext.class);
		}
		public AssignStatContext assignStat(int i) {
			return getRuleContext(AssignStatContext.class,i);
		}
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ForStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitForStat(this);
		}
	}

	public final ForStatContext forStat() throws RecognitionException {
		ForStatContext _localctx = new ForStatContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__12);
			setState(132);
			match(T__3);
			setState(133);
			assignStat();
			setState(134);
			match(T__6);
			setState(135);
			bexpr();
			setState(136);
			match(T__6);
			setState(137);
			assignStat();
			setState(138);
			match(T__4);
			setState(139);
			stat();
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
	public static class WhileStatContext extends ParserRuleContext {
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitWhileStat(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__13);
			setState(142);
			match(T__3);
			setState(143);
			bexpr();
			setState(144);
			match(T__4);
			setState(145);
			stat();
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
	public static class ReturnStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitReturnStat(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_returnStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__14);
			setState(148);
			expr(0);
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
	public static class ArgsContext extends ParserRuleContext {
		public ArgsNoneContext argsNone() {
			return getRuleContext(ArgsNoneContext.class,0);
		}
		public ArgsSingleContext argsSingle() {
			return getRuleContext(ArgsSingleContext.class,0);
		}
		public ArgsMulContext argsMul() {
			return getRuleContext(ArgsMulContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_args);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				argsNone();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				argsSingle();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				argsMul();
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
	public static class ArgsNoneContext extends ParserRuleContext {
		public ArgsNoneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsNone; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterArgsNone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitArgsNone(this);
		}
	}

	public final ArgsNoneContext argsNone() throws RecognitionException {
		ArgsNoneContext _localctx = new ArgsNoneContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_argsNone);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
	public static class ArgsSingleContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgsSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsSingle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterArgsSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitArgsSingle(this);
		}
	}

	public final ArgsSingleContext argsSingle() throws RecognitionException {
		ArgsSingleContext _localctx = new ArgsSingleContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_argsSingle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			expr(0);
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
	public static class ArgsMulContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsMulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsMul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterArgsMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitArgsMul(this);
		}
	}

	public final ArgsMulContext argsMul() throws RecognitionException {
		ArgsMulContext _localctx = new ArgsMulContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_argsMul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			expr(0);
			setState(162); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				match(T__5);
				setState(161);
				expr(0);
				}
				}
				setState(164); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 );
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
	public static class PrintStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitPrintStat(this);
		}
	}

	public final PrintStatContext printStat() throws RecognitionException {
		PrintStatContext _localctx = new PrintStatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_printStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__15);
			setState(167);
			match(T__3);
			setState(168);
			match(T__16);
			setState(169);
			match(T__17);
			setState(170);
			match(T__18);
			setState(171);
			match(T__16);
			setState(172);
			match(T__5);
			setState(173);
			expr(0);
			setState(174);
			match(T__4);
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
	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CymbolParser.ID, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitVarDecl(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			type();
			setState(177);
			match(ID);
			setState(178);
			match(T__6);
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode K_FLOAT() { return getToken(CymbolParser.K_FLOAT, 0); }
		public TerminalNode K_INT() { return getToken(CymbolParser.K_INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !(_la==K_INT || _la==K_FLOAT) ) {
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
	@SuppressWarnings("CheckReturnValue")
	public static class VarRefContext extends ExprContext {
		public TerminalNode ID() { return getToken(CymbolParser.ID, 0); }
		public VarRefContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitVarRef(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitMulDiv(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitAddSub(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ExprContext {
		public TerminalNode ID() { return getToken(CymbolParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FunctionCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitFunctionCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitMinus(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(CymbolParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitInt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesesContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitParentheses(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new MinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(183);
				((MinusContext)_localctx).op = match(T__19);
				setState(184);
				expr(7);
				}
				break;
			case 2:
				{
				_localctx = new VarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(186);
				match(INT);
				}
				break;
			case 4:
				{
				_localctx = new ParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(T__3);
				setState(188);
				expr(0);
				setState(189);
				match(T__4);
				}
				break;
			case 5:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(ID);
				setState(192);
				match(T__3);
				setState(193);
				args();
				setState(194);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(204);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(199);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(200);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(202);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__22) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(203);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BexprContext extends ParserRuleContext {
		public BexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr; }
	 
		public BexprContext() { }
		public void copyFrom(BexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Parentheses_BoolContext extends BexprContext {
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public Parentheses_BoolContext(BexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterParentheses_Bool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitParentheses_Bool(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends BexprContext {
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public NotContext(BexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitNot(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelOpContext extends BexprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelOpContext(BexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterRelOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitRelOp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueContext extends BexprContext {
		public TrueContext(BexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitTrue(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseContext extends BexprContext {
		public FalseContext(BexprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).enterFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CymbolListener ) ((CymbolListener)listener).exitFalse(this);
		}
	}

	public final BexprContext bexpr() throws RecognitionException {
		BexprContext _localctx = new BexprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_bexpr);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new NotContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(T__23);
				setState(210);
				bexpr();
				}
				break;
			case 2:
				_localctx = new RelOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				expr(0);
				setState(212);
				((RelOpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 503316480L) != 0)) ) {
					((RelOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(213);
				expr(0);
				}
				break;
			case 3:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				match(T__28);
				}
				break;
			case 4:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				match(T__29);
				}
				break;
			case 5:
				_localctx = new Parentheses_BoolContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(217);
				match(T__3);
				setState(218);
				bexpr();
				setState(219);
				match(T__4);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u00e0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u0000"+
		"3\t\u0000\u0001\u0000\u0001\u0000\u0004\u00007\b\u0000\u000b\u0000\f\u0000"+
		"8\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002B\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003J\b\u0003\n\u0003\f\u0003"+
		"M\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005c\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0005\u0006g\b\u0006\n\u0006\f\u0006j\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0003\bt\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u009a\b\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011\u00a3\b\u0011\u000b\u0011"+
		"\f\u0011\u00a4\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u00c5\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00cd\b\u0015\n\u0015"+
		"\f\u0015\u00d0\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u00de\b\u0016\u0001\u0016\u0000\u0001"+
		"*\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,\u0000\u0005\u0001\u0000\u0002\u0003\u0001\u0000"+
		"\u001f \u0001\u0000\u0015\u0016\u0002\u0000\u0014\u0014\u0017\u0017\u0001"+
		"\u0000\u0019\u001c\u00e4\u00001\u0001\u0000\u0000\u0000\u0002:\u0001\u0000"+
		"\u0000\u0000\u0004=\u0001\u0000\u0000\u0000\u0006F\u0001\u0000\u0000\u0000"+
		"\bN\u0001\u0000\u0000\u0000\nb\u0001\u0000\u0000\u0000\fd\u0001\u0000"+
		"\u0000\u0000\u000em\u0001\u0000\u0000\u0000\u0010s\u0001\u0000\u0000\u0000"+
		"\u0012u\u0001\u0000\u0000\u0000\u0014{\u0001\u0000\u0000\u0000\u0016\u0083"+
		"\u0001\u0000\u0000\u0000\u0018\u008d\u0001\u0000\u0000\u0000\u001a\u0093"+
		"\u0001\u0000\u0000\u0000\u001c\u0099\u0001\u0000\u0000\u0000\u001e\u009b"+
		"\u0001\u0000\u0000\u0000 \u009d\u0001\u0000\u0000\u0000\"\u009f\u0001"+
		"\u0000\u0000\u0000$\u00a6\u0001\u0000\u0000\u0000&\u00b0\u0001\u0000\u0000"+
		"\u0000(\u00b4\u0001\u0000\u0000\u0000*\u00c4\u0001\u0000\u0000\u0000,"+
		"\u00dd\u0001\u0000\u0000\u0000.0\u0003\u0002\u0001\u0000/.\u0001\u0000"+
		"\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001"+
		"\u0000\u0000\u000026\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"47\u0003\u0004\u0002\u000057\u0003&\u0013\u000064\u0001\u0000\u0000\u0000"+
		"65\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u000086\u0001\u0000\u0000"+
		"\u000089\u0001\u0000\u0000\u00009\u0001\u0001\u0000\u0000\u0000:;\u0005"+
		"\u0001\u0000\u0000;<\u0007\u0000\u0000\u0000<\u0003\u0001\u0000\u0000"+
		"\u0000=>\u0003(\u0014\u0000>?\u0005\"\u0000\u0000?A\u0005\u0004\u0000"+
		"\u0000@B\u0003\u0006\u0003\u0000A@\u0001\u0000\u0000\u0000AB\u0001\u0000"+
		"\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0005\u0005\u0000\u0000DE\u0003"+
		"\f\u0006\u0000E\u0005\u0001\u0000\u0000\u0000FK\u0003\b\u0004\u0000GH"+
		"\u0005\u0006\u0000\u0000HJ\u0003\b\u0004\u0000IG\u0001\u0000\u0000\u0000"+
		"JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000"+
		"\u0000L\u0007\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NO\u0003"+
		"(\u0014\u0000OP\u0005\"\u0000\u0000P\t\u0001\u0000\u0000\u0000Qc\u0003"+
		"\f\u0006\u0000Rc\u0003&\u0013\u0000Sc\u0003\u0010\b\u0000Tc\u0003\u0016"+
		"\u000b\u0000Uc\u0003\u0018\f\u0000VW\u0003\u001a\r\u0000WX\u0005\u0007"+
		"\u0000\u0000Xc\u0001\u0000\u0000\u0000YZ\u0003\u000e\u0007\u0000Z[\u0005"+
		"\u0007\u0000\u0000[c\u0001\u0000\u0000\u0000\\]\u0003$\u0012\u0000]^\u0005"+
		"\u0007\u0000\u0000^c\u0001\u0000\u0000\u0000_`\u0003*\u0015\u0000`a\u0005"+
		"\u0007\u0000\u0000ac\u0001\u0000\u0000\u0000bQ\u0001\u0000\u0000\u0000"+
		"bR\u0001\u0000\u0000\u0000bS\u0001\u0000\u0000\u0000bT\u0001\u0000\u0000"+
		"\u0000bU\u0001\u0000\u0000\u0000bV\u0001\u0000\u0000\u0000bY\u0001\u0000"+
		"\u0000\u0000b\\\u0001\u0000\u0000\u0000b_\u0001\u0000\u0000\u0000c\u000b"+
		"\u0001\u0000\u0000\u0000dh\u0005\b\u0000\u0000eg\u0003\n\u0005\u0000f"+
		"e\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000"+
		"\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000jh\u0001\u0000"+
		"\u0000\u0000kl\u0005\t\u0000\u0000l\r\u0001\u0000\u0000\u0000mn\u0005"+
		"\"\u0000\u0000no\u0005\n\u0000\u0000op\u0003*\u0015\u0000p\u000f\u0001"+
		"\u0000\u0000\u0000qt\u0003\u0012\t\u0000rt\u0003\u0014\n\u0000sq\u0001"+
		"\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000t\u0011\u0001\u0000\u0000"+
		"\u0000uv\u0005\u000b\u0000\u0000vw\u0005\u0004\u0000\u0000wx\u0003,\u0016"+
		"\u0000xy\u0005\u0005\u0000\u0000yz\u0003\n\u0005\u0000z\u0013\u0001\u0000"+
		"\u0000\u0000{|\u0005\u000b\u0000\u0000|}\u0005\u0004\u0000\u0000}~\u0003"+
		",\u0016\u0000~\u007f\u0005\u0005\u0000\u0000\u007f\u0080\u0003\n\u0005"+
		"\u0000\u0080\u0081\u0005\f\u0000\u0000\u0081\u0082\u0003\n\u0005\u0000"+
		"\u0082\u0015\u0001\u0000\u0000\u0000\u0083\u0084\u0005\r\u0000\u0000\u0084"+
		"\u0085\u0005\u0004\u0000\u0000\u0085\u0086\u0003\u000e\u0007\u0000\u0086"+
		"\u0087\u0005\u0007\u0000\u0000\u0087\u0088\u0003,\u0016\u0000\u0088\u0089"+
		"\u0005\u0007\u0000\u0000\u0089\u008a\u0003\u000e\u0007\u0000\u008a\u008b"+
		"\u0005\u0005\u0000\u0000\u008b\u008c\u0003\n\u0005\u0000\u008c\u0017\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005\u000e\u0000\u0000\u008e\u008f\u0005"+
		"\u0004\u0000\u0000\u008f\u0090\u0003,\u0016\u0000\u0090\u0091\u0005\u0005"+
		"\u0000\u0000\u0091\u0092\u0003\n\u0005\u0000\u0092\u0019\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0005\u000f\u0000\u0000\u0094\u0095\u0003*\u0015\u0000"+
		"\u0095\u001b\u0001\u0000\u0000\u0000\u0096\u009a\u0003\u001e\u000f\u0000"+
		"\u0097\u009a\u0003 \u0010\u0000\u0098\u009a\u0003\"\u0011\u0000\u0099"+
		"\u0096\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u0098\u0001\u0000\u0000\u0000\u009a\u001d\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0001\u0000\u0000\u0000\u009c\u001f\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0003*\u0015\u0000\u009e!\u0001\u0000\u0000\u0000\u009f\u00a2\u0003"+
		"*\u0015\u0000\u00a0\u00a1\u0005\u0006\u0000\u0000\u00a1\u00a3\u0003*\u0015"+
		"\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a5#\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0010\u0000\u0000"+
		"\u00a7\u00a8\u0005\u0004\u0000\u0000\u00a8\u00a9\u0005\u0011\u0000\u0000"+
		"\u00a9\u00aa\u0005\u0012\u0000\u0000\u00aa\u00ab\u0005\u0013\u0000\u0000"+
		"\u00ab\u00ac\u0005\u0011\u0000\u0000\u00ac\u00ad\u0005\u0006\u0000\u0000"+
		"\u00ad\u00ae\u0003*\u0015\u0000\u00ae\u00af\u0005\u0005\u0000\u0000\u00af"+
		"%\u0001\u0000\u0000\u0000\u00b0\u00b1\u0003(\u0014\u0000\u00b1\u00b2\u0005"+
		"\"\u0000\u0000\u00b2\u00b3\u0005\u0007\u0000\u0000\u00b3\'\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0007\u0001\u0000\u0000\u00b5)\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0006\u0015\uffff\uffff\u0000\u00b7\u00b8\u0005\u0014"+
		"\u0000\u0000\u00b8\u00c5\u0003*\u0015\u0007\u00b9\u00c5\u0005\"\u0000"+
		"\u0000\u00ba\u00c5\u0005#\u0000\u0000\u00bb\u00bc\u0005\u0004\u0000\u0000"+
		"\u00bc\u00bd\u0003*\u0015\u0000\u00bd\u00be\u0005\u0005\u0000\u0000\u00be"+
		"\u00c5\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\"\u0000\u0000\u00c0\u00c1"+
		"\u0005\u0004\u0000\u0000\u00c1\u00c2\u0003\u001c\u000e\u0000\u00c2\u00c3"+
		"\u0005\u0005\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00b6"+
		"\u0001\u0000\u0000\u0000\u00c4\u00b9\u0001\u0000\u0000\u0000\u00c4\u00ba"+
		"\u0001\u0000\u0000\u0000\u00c4\u00bb\u0001\u0000\u0000\u0000\u00c4\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c5\u00ce\u0001\u0000\u0000\u0000\u00c6\u00c7"+
		"\n\u0006\u0000\u0000\u00c7\u00c8\u0007\u0002\u0000\u0000\u00c8\u00cd\u0003"+
		"*\u0015\u0007\u00c9\u00ca\n\u0005\u0000\u0000\u00ca\u00cb\u0007\u0003"+
		"\u0000\u0000\u00cb\u00cd\u0003*\u0015\u0006\u00cc\u00c6\u0001\u0000\u0000"+
		"\u0000\u00cc\u00c9\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cf+\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0005\u0018\u0000\u0000\u00d2\u00de\u0003,\u0016\u0000\u00d3"+
		"\u00d4\u0003*\u0015\u0000\u00d4\u00d5\u0007\u0004\u0000\u0000\u00d5\u00d6"+
		"\u0003*\u0015\u0000\u00d6\u00de\u0001\u0000\u0000\u0000\u00d7\u00de\u0005"+
		"\u001d\u0000\u0000\u00d8\u00de\u0005\u001e\u0000\u0000\u00d9\u00da\u0005"+
		"\u0004\u0000\u0000\u00da\u00db\u0003,\u0016\u0000\u00db\u00dc\u0005\u0005"+
		"\u0000\u0000\u00dc\u00de\u0001\u0000\u0000\u0000\u00dd\u00d1\u0001\u0000"+
		"\u0000\u0000\u00dd\u00d3\u0001\u0000\u0000\u0000\u00dd\u00d7\u0001\u0000"+
		"\u0000\u0000\u00dd\u00d8\u0001\u0000\u0000\u0000\u00dd\u00d9\u0001\u0000"+
		"\u0000\u0000\u00de-\u0001\u0000\u0000\u0000\u000e168AKbhs\u0099\u00a4"+
		"\u00c4\u00cc\u00ce\u00dd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}