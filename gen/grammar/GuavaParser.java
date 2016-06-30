// Generated from C:/Users/Dion/Documents/TI/Module 8/Guava/src/main/java/grammar\Guava.g4 by ANTLR 4.5.3
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GuavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, COMMA=2, SEMI=3, SQUOTE=4, DQUOTE=5, DIV=6, MULT=7, PLUS=8, MINUS=9, 
		POWER=10, MOD=11, ASSIGN=12, NOT=13, OR=14, AND=15, EQ=16, LT=17, LE=18, 
		GT=19, GE=20, NE=21, LBRACK=22, RBRACK=23, LPAR=24, RPAR=25, LSQBR=26, 
		RSQBR=27, INT=28, CHARACTER=29, BOOLEAN=30, STRING=31, NUM=32, BOOL=33, 
		CHAR=34, STR=35, TRUE=36, FALSE=37, EPIC=38, IF=39, ELSE=40, FOR=41, WHILE=42, 
		FORK=43, OUT=44, GLOBAL=45, LOCK=46, UNLOCK=47, ID=48, COMMENTBLOCK=49, 
		COMMENTLINE=50, WS=51;
	public static final int
		RULE_program = 0, RULE_body = 1, RULE_global = 2, RULE_stat = 3, RULE_expr = 4, 
		RULE_forAss = 5, RULE_prfOp = 6, RULE_multOp = 7, RULE_plusOp = 8, RULE_boolOp = 9, 
		RULE_compOp = 10, RULE_type = 11;
	public static final String[] ruleNames = {
		"program", "body", "global", "stat", "expr", "forAss", "prfOp", "multOp", 
		"plusOp", "boolOp", "compOp", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "','", "';'", "'''", "'\"'", "'/'", "'*'", "'+'", "'-'", 
		"'^'", "'mod'", "'='", "'~'", "'|'", "'&'", "'=='", "'<'", "'<='", "'>'", 
		"'>='", "'~='", "'{'", "'}'", "'('", "')'", "'['", "']'", "'int'", "'char'", 
		"'pulp'", "'string'", null, null, null, null, "'sweet'", "'sour'", "'epicarp'", 
		"'if'", "'else'", "'for'", "'while'", "'branch'", "'drop'", "'universal'", 
		"'lock'", "'unlock'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOT", "COMMA", "SEMI", "SQUOTE", "DQUOTE", "DIV", "MULT", "PLUS", 
		"MINUS", "POWER", "MOD", "ASSIGN", "NOT", "OR", "AND", "EQ", "LT", "LE", 
		"GT", "GE", "NE", "LBRACK", "RBRACK", "LPAR", "RPAR", "LSQBR", "RSQBR", 
		"INT", "CHARACTER", "BOOLEAN", "STRING", "NUM", "BOOL", "CHAR", "STR", 
		"TRUE", "FALSE", "EPIC", "IF", "ELSE", "FOR", "WHILE", "FORK", "OUT", 
		"GLOBAL", "LOCK", "UNLOCK", "ID", "COMMENTBLOCK", "COMMENTLINE", "WS"
	};
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
	public String getGrammarFileName() { return "Guava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GuavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EPIC() { return getToken(GuavaParser.EPIC, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(EPIC);
			setState(25);
			body();
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

	public static class BodyContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(GuavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(GuavaParser.RBRACK, 0); }
		public TerminalNode FORK() { return getToken(GuavaParser.FORK, 0); }
		public TerminalNode SEMI() { return getToken(GuavaParser.SEMI, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<GlobalContext> global() {
			return getRuleContexts(GlobalContext.class);
		}
		public GlobalContext global(int i) {
			return getRuleContext(GlobalContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(LBRACK);
			setState(36);
			_la = _input.LA(1);
			if (_la==FORK) {
				{
				setState(28);
				match(FORK);
				setState(29);
				match(SEMI);
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==GLOBAL) {
					{
					{
					setState(30);
					global();
					}
					}
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACK) | (1L << INT) | (1L << CHARACTER) | (1L << BOOLEAN) | (1L << STRING) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << OUT) | (1L << LOCK) | (1L << UNLOCK) | (1L << ID))) != 0)) {
				{
				{
				setState(38);
				stat();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(RBRACK);
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

	public static class GlobalContext extends ParserRuleContext {
		public GlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global; }
	 
		public GlobalContext() { }
		public void copyFrom(GlobalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GlobalDeclContext extends GlobalContext {
		public TerminalNode GLOBAL() { return getToken(GuavaParser.GLOBAL, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(GuavaParser.SEMI, 0); }
		public TerminalNode ASSIGN() { return getToken(GuavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public GlobalDeclContext(GlobalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterGlobalDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitGlobalDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitGlobalDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalContext global() throws RecognitionException {
		GlobalContext _localctx = new GlobalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_global);
		int _la;
		try {
			_localctx = new GlobalDeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(GLOBAL);
			setState(47);
			type();
			setState(48);
			match(ID);
			setState(51);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(49);
				match(ASSIGN);
				setState(50);
				expr(0);
				}
			}

			setState(53);
			match(SEMI);
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatContext {
		public TerminalNode IF() { return getToken(GuavaParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(GuavaParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GuavaParser.RPAR, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(GuavaParser.ELSE, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatContext extends StatContext {
		public TerminalNode LBRACK() { return getToken(GuavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(GuavaParser.RBRACK, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitBlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LockStatContext extends StatContext {
		public TerminalNode LOCK() { return getToken(GuavaParser.LOCK, 0); }
		public TerminalNode LPAR() { return getToken(GuavaParser.LPAR, 0); }
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public TerminalNode RPAR() { return getToken(GuavaParser.RPAR, 0); }
		public TerminalNode SEMI() { return getToken(GuavaParser.SEMI, 0); }
		public LockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterLockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitLockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitLockStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclStatContext extends StatContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(GuavaParser.SEMI, 0); }
		public TerminalNode ASSIGN() { return getToken(GuavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterVarDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitVarDeclStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitVarDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayDeclStatContext extends StatContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LSQBR() { return getToken(GuavaParser.LSQBR, 0); }
		public TerminalNode NUM() { return getToken(GuavaParser.NUM, 0); }
		public TerminalNode RSQBR() { return getToken(GuavaParser.RSQBR, 0); }
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(GuavaParser.SEMI, 0); }
		public TerminalNode ASSIGN() { return getToken(GuavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayDeclStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterArrayDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitArrayDeclStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitArrayDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintStatContext extends StatContext {
		public TerminalNode OUT() { return getToken(GuavaParser.OUT, 0); }
		public TerminalNode LPAR() { return getToken(GuavaParser.LPAR, 0); }
		public TerminalNode STR() { return getToken(GuavaParser.STR, 0); }
		public TerminalNode RPAR() { return getToken(GuavaParser.RPAR, 0); }
		public TerminalNode SEMI() { return getToken(GuavaParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GuavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GuavaParser.COMMA, i);
		}
		public List<TerminalNode> ID() { return getTokens(GuavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GuavaParser.ID, i);
		}
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitPrintStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitPrintStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignStatContext extends StatContext {
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(GuavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(GuavaParser.SEMI, 0); }
		public AssignStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitAssignStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitAssignStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignArrayStatContext extends StatContext {
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public TerminalNode LSQBR() { return getToken(GuavaParser.LSQBR, 0); }
		public TerminalNode NUM() { return getToken(GuavaParser.NUM, 0); }
		public TerminalNode RSQBR() { return getToken(GuavaParser.RSQBR, 0); }
		public TerminalNode ASSIGN() { return getToken(GuavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(GuavaParser.SEMI, 0); }
		public AssignArrayStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterAssignArrayStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitAssignArrayStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitAssignArrayStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStatContext extends StatContext {
		public TerminalNode FOR() { return getToken(GuavaParser.FOR, 0); }
		public TerminalNode LPAR() { return getToken(GuavaParser.LPAR, 0); }
		public ForAssContext forAss() {
			return getRuleContext(ForAssContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(GuavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(GuavaParser.SEMI, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(GuavaParser.RPAR, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(GuavaParser.ASSIGN, 0); }
		public List<TerminalNode> PLUS() { return getTokens(GuavaParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(GuavaParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(GuavaParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(GuavaParser.MINUS, i);
		}
		public ForStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitForStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnlockStatContext extends StatContext {
		public TerminalNode UNLOCK() { return getToken(GuavaParser.UNLOCK, 0); }
		public TerminalNode LPAR() { return getToken(GuavaParser.LPAR, 0); }
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public TerminalNode RPAR() { return getToken(GuavaParser.RPAR, 0); }
		public TerminalNode SEMI() { return getToken(GuavaParser.SEMI, 0); }
		public UnlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterUnlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitUnlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitUnlockStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatContext {
		public TerminalNode WHILE() { return getToken(GuavaParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(GuavaParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GuavaParser.RPAR, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stat);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new VarDeclStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				type();
				setState(56);
				match(ID);
				setState(59);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(57);
					match(ASSIGN);
					setState(58);
					expr(0);
					}
				}

				setState(61);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new ArrayDeclStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				type();
				setState(64);
				match(LSQBR);
				setState(65);
				match(NUM);
				setState(66);
				match(RSQBR);
				setState(67);
				match(ID);
				setState(70);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(68);
					match(ASSIGN);
					setState(69);
					expr(0);
					}
				}

				setState(72);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(ID);
				setState(75);
				match(ASSIGN);
				setState(76);
				expr(0);
				setState(77);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new AssignArrayStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(ID);
				setState(80);
				match(LSQBR);
				setState(81);
				match(NUM);
				setState(82);
				match(RSQBR);
				setState(83);
				match(ASSIGN);
				setState(84);
				expr(0);
				setState(85);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				match(IF);
				setState(88);
				match(LPAR);
				setState(89);
				expr(0);
				setState(90);
				match(RPAR);
				setState(91);
				stat();
				setState(94);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(92);
					match(ELSE);
					setState(93);
					stat();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(96);
				match(LBRACK);
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACK) | (1L << INT) | (1L << CHARACTER) | (1L << BOOLEAN) | (1L << STRING) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << OUT) | (1L << LOCK) | (1L << UNLOCK) | (1L << ID))) != 0)) {
					{
					{
					setState(97);
					stat();
					}
					}
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(103);
				match(RBRACK);
				}
				break;
			case 7:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(104);
				match(WHILE);
				setState(105);
				match(LPAR);
				setState(106);
				expr(0);
				setState(107);
				match(RPAR);
				setState(108);
				stat();
				}
				break;
			case 8:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(110);
				match(FOR);
				setState(111);
				match(LPAR);
				setState(112);
				forAss();
				setState(113);
				match(SEMI);
				setState(114);
				expr(0);
				setState(115);
				match(SEMI);
				setState(125);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(116);
					match(ID);
					setState(117);
					match(ASSIGN);
					setState(118);
					expr(0);
					}
					break;
				case 2:
					{
					setState(119);
					match(ID);
					setState(120);
					match(PLUS);
					setState(121);
					match(PLUS);
					}
					break;
				case 3:
					{
					setState(122);
					match(ID);
					setState(123);
					match(MINUS);
					setState(124);
					match(MINUS);
					}
					break;
				}
				setState(127);
				match(RPAR);
				setState(128);
				stat();
				}
				break;
			case 9:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(130);
				match(OUT);
				setState(131);
				match(LPAR);
				setState(132);
				match(STR);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(133);
					match(COMMA);
					setState(134);
					match(ID);
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(140);
				match(RPAR);
				setState(141);
				match(SEMI);
				}
				break;
			case 10:
				_localctx = new LockStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(142);
				match(LOCK);
				setState(143);
				match(LPAR);
				setState(144);
				match(ID);
				setState(145);
				match(RPAR);
				setState(146);
				match(SEMI);
				}
				break;
			case 11:
				_localctx = new UnlockStatContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(147);
				match(UNLOCK);
				setState(148);
				match(LPAR);
				setState(149);
				match(ID);
				setState(150);
				match(RPAR);
				setState(151);
				match(SEMI);
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
	public static class GetArrayExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public TerminalNode LSQBR() { return getToken(GuavaParser.LSQBR, 0); }
		public TerminalNode NUM() { return getToken(GuavaParser.NUM, 0); }
		public TerminalNode RSQBR() { return getToken(GuavaParser.RSQBR, 0); }
		public GetArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterGetArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitGetArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitGetArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParExprContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(GuavaParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(GuavaParser.RPAR, 0); }
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitParExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public TerminalNode LSQBR() { return getToken(GuavaParser.LSQBR, 0); }
		public TerminalNode RSQBR() { return getToken(GuavaParser.RSQBR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GuavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GuavaParser.COMMA, i);
		}
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MOD() { return getToken(GuavaParser.MOD, 0); }
		public ModExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterModExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitModExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitModExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrfExprContext extends ExprContext {
		public PrfOpContext prfOp() {
			return getRuleContext(PrfOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrfExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterPrfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitPrfExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitPrfExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultOpContext multOp() {
			return getRuleContext(MultOpContext.class,0);
		}
		public MultExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PlusOpContext plusOp() {
			return getRuleContext(PlusOpContext.class,0);
		}
		public PlusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterPlusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitPlusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitPlusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstExprContext extends ExprContext {
		public TerminalNode NUM() { return getToken(GuavaParser.NUM, 0); }
		public TerminalNode BOOL() { return getToken(GuavaParser.BOOL, 0); }
		public TerminalNode CHAR() { return getToken(GuavaParser.CHAR, 0); }
		public TerminalNode STR() { return getToken(GuavaParser.STR, 0); }
		public ConstExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterConstExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitConstExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitConstExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new PrfExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(155);
				prfOp();
				setState(156);
				expr(11);
				}
				break;
			case 2:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158);
				match(LPAR);
				setState(159);
				expr(0);
				setState(160);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(LSQBR);
				setState(171);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LPAR) | (1L << LSQBR) | (1L << NUM) | (1L << BOOL) | (1L << CHAR) | (1L << STR) | (1L << ID))) != 0)) {
					{
					setState(163);
					expr(0);
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(164);
						match(COMMA);
						setState(165);
						expr(0);
						}
						}
						setState(170);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(173);
				match(RSQBR);
				}
				break;
			case 4:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM) | (1L << BOOL) | (1L << CHAR) | (1L << STR))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 5:
				{
				_localctx = new GetArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				match(ID);
				setState(176);
				match(LSQBR);
				setState(177);
				match(NUM);
				setState(178);
				match(RSQBR);
				}
				break;
			case 6:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(201);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ModExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(183);
						match(MOD);
						setState(184);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(186);
						multOp();
						setState(187);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new PlusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(189);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(190);
						plusOp();
						setState(191);
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(194);
						boolOp();
						setState(195);
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(197);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(198);
						compOp();
						setState(199);
						expr(7);
						}
						break;
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class ForAssContext extends ParserRuleContext {
		public ForAssContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forAss; }
	 
		public ForAssContext() { }
		public void copyFrom(ForAssContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForExistingContext extends ForAssContext {
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public ForExistingContext(ForAssContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterForExisting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitForExisting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitForExisting(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForDeclContext extends ForAssContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(GuavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForDeclContext(ForAssContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterForDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitForDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitForDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForAssContext forAss() throws RecognitionException {
		ForAssContext _localctx = new ForAssContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_forAss);
		try {
			setState(212);
			switch (_input.LA(1)) {
			case INT:
			case CHARACTER:
			case BOOLEAN:
			case STRING:
				_localctx = new ForDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				type();
				setState(207);
				match(ID);
				setState(208);
				match(ASSIGN);
				setState(209);
				expr(0);
				}
				break;
			case ID:
				_localctx = new ForExistingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(ID);
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

	public static class PrfOpContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(GuavaParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(GuavaParser.NOT, 0); }
		public PrfOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prfOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterPrfOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitPrfOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitPrfOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrfOpContext prfOp() throws RecognitionException {
		PrfOpContext _localctx = new PrfOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_prfOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_la = _input.LA(1);
			if ( !(_la==MINUS || _la==NOT) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class MultOpContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(GuavaParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(GuavaParser.DIV, 0); }
		public TerminalNode POWER() { return getToken(GuavaParser.POWER, 0); }
		public MultOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterMultOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitMultOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitMultOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultOpContext multOp() throws RecognitionException {
		MultOpContext _localctx = new MultOpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIV) | (1L << MULT) | (1L << POWER))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class PlusOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(GuavaParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(GuavaParser.MINUS, 0); }
		public PlusOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterPlusOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitPlusOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitPlusOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusOpContext plusOp() throws RecognitionException {
		PlusOpContext _localctx = new PlusOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_plusOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class BoolOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(GuavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(GuavaParser.OR, 0); }
		public BoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterBoolOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitBoolOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitBoolOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOpContext boolOp() throws RecognitionException {
		BoolOpContext _localctx = new BoolOpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_la = _input.LA(1);
			if ( !(_la==OR || _la==AND) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode LE() { return getToken(GuavaParser.LE, 0); }
		public TerminalNode LT() { return getToken(GuavaParser.LT, 0); }
		public TerminalNode GE() { return getToken(GuavaParser.GE, 0); }
		public TerminalNode GT() { return getToken(GuavaParser.GT, 0); }
		public TerminalNode EQ() { return getToken(GuavaParser.EQ, 0); }
		public TerminalNode NE() { return getToken(GuavaParser.NE, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitCompOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << LT) | (1L << LE) | (1L << GT) | (1L << GE) | (1L << NE))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CharTypeContext extends TypeContext {
		public TerminalNode CHARACTER() { return getToken(GuavaParser.CHARACTER, 0); }
		public CharTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterCharType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitCharType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitCharType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public TerminalNode INT() { return getToken(GuavaParser.INT, 0); }
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringTypeContext extends TypeContext {
		public TerminalNode STRING() { return getToken(GuavaParser.STRING, 0); }
		public StringTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterStringType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitStringType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitStringType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public TerminalNode BOOLEAN() { return getToken(GuavaParser.BOOLEAN, 0); }
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		try {
			setState(228);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				match(INT);
				}
				break;
			case BOOLEAN:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				match(BOOLEAN);
				}
				break;
			case CHARACTER:
				_localctx = new CharTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				match(CHARACTER);
				}
				break;
			case STRING:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(227);
				match(STRING);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\65\u00e9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%"+
		"\13\3\5\3\'\n\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\5\4\66\n\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5>\n\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5I\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5a\n\5\3\5\3\5\7\5e\n\5\f\5"+
		"\16\5h\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0080\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\5\u008a\n\5\f\5\16\5\u008d\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5\u009b\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6\u00a9\n\6\f\6\16\6\u00ac\13\6\5\6\u00ae\n\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u00b7\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00cc\n\6\f\6\16\6\u00cf\13\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00d7\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u00e7\n\r\3\r\2\3\n\16\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\2\b\3\2\"%\4\2\13\13\17\17\4\2\b\t\f\f\3\2\n\13\3\2\20"+
		"\21\3\2\22\27\u0101\2\32\3\2\2\2\4\35\3\2\2\2\6\60\3\2\2\2\b\u009a\3\2"+
		"\2\2\n\u00b6\3\2\2\2\f\u00d6\3\2\2\2\16\u00d8\3\2\2\2\20\u00da\3\2\2\2"+
		"\22\u00dc\3\2\2\2\24\u00de\3\2\2\2\26\u00e0\3\2\2\2\30\u00e6\3\2\2\2\32"+
		"\33\7(\2\2\33\34\5\4\3\2\34\3\3\2\2\2\35&\7\30\2\2\36\37\7-\2\2\37#\7"+
		"\5\2\2 \"\5\6\4\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\'\3\2\2\2"+
		"%#\3\2\2\2&\36\3\2\2\2&\'\3\2\2\2\'+\3\2\2\2(*\5\b\5\2)(\3\2\2\2*-\3\2"+
		"\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\31\2\2/\5\3\2\2\2\60"+
		"\61\7/\2\2\61\62\5\30\r\2\62\65\7\62\2\2\63\64\7\16\2\2\64\66\5\n\6\2"+
		"\65\63\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\7\5\2\28\7\3\2\2\29:\5"+
		"\30\r\2:=\7\62\2\2;<\7\16\2\2<>\5\n\6\2=;\3\2\2\2=>\3\2\2\2>?\3\2\2\2"+
		"?@\7\5\2\2@\u009b\3\2\2\2AB\5\30\r\2BC\7\34\2\2CD\7\"\2\2DE\7\35\2\2E"+
		"H\7\62\2\2FG\7\16\2\2GI\5\n\6\2HF\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7\5\2"+
		"\2K\u009b\3\2\2\2LM\7\62\2\2MN\7\16\2\2NO\5\n\6\2OP\7\5\2\2P\u009b\3\2"+
		"\2\2QR\7\62\2\2RS\7\34\2\2ST\7\"\2\2TU\7\35\2\2UV\7\16\2\2VW\5\n\6\2W"+
		"X\7\5\2\2X\u009b\3\2\2\2YZ\7)\2\2Z[\7\32\2\2[\\\5\n\6\2\\]\7\33\2\2]`"+
		"\5\b\5\2^_\7*\2\2_a\5\b\5\2`^\3\2\2\2`a\3\2\2\2a\u009b\3\2\2\2bf\7\30"+
		"\2\2ce\5\b\5\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2"+
		"\2\2i\u009b\7\31\2\2jk\7,\2\2kl\7\32\2\2lm\5\n\6\2mn\7\33\2\2no\5\b\5"+
		"\2o\u009b\3\2\2\2pq\7+\2\2qr\7\32\2\2rs\5\f\7\2st\7\5\2\2tu\5\n\6\2u\177"+
		"\7\5\2\2vw\7\62\2\2wx\7\16\2\2x\u0080\5\n\6\2yz\7\62\2\2z{\7\n\2\2{\u0080"+
		"\7\n\2\2|}\7\62\2\2}~\7\13\2\2~\u0080\7\13\2\2\177v\3\2\2\2\177y\3\2\2"+
		"\2\177|\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7\33\2\2\u0082\u0083\5"+
		"\b\5\2\u0083\u009b\3\2\2\2\u0084\u0085\7.\2\2\u0085\u0086\7\32\2\2\u0086"+
		"\u008b\7%\2\2\u0087\u0088\7\4\2\2\u0088\u008a\7\62\2\2\u0089\u0087\3\2"+
		"\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\7\33\2\2\u008f\u009b\7"+
		"\5\2\2\u0090\u0091\7\60\2\2\u0091\u0092\7\32\2\2\u0092\u0093\7\62\2\2"+
		"\u0093\u0094\7\33\2\2\u0094\u009b\7\5\2\2\u0095\u0096\7\61\2\2\u0096\u0097"+
		"\7\32\2\2\u0097\u0098\7\62\2\2\u0098\u0099\7\33\2\2\u0099\u009b\7\5\2"+
		"\2\u009a9\3\2\2\2\u009aA\3\2\2\2\u009aL\3\2\2\2\u009aQ\3\2\2\2\u009aY"+
		"\3\2\2\2\u009ab\3\2\2\2\u009aj\3\2\2\2\u009ap\3\2\2\2\u009a\u0084\3\2"+
		"\2\2\u009a\u0090\3\2\2\2\u009a\u0095\3\2\2\2\u009b\t\3\2\2\2\u009c\u009d"+
		"\b\6\1\2\u009d\u009e\5\16\b\2\u009e\u009f\5\n\6\r\u009f\u00b7\3\2\2\2"+
		"\u00a0\u00a1\7\32\2\2\u00a1\u00a2\5\n\6\2\u00a2\u00a3\7\33\2\2\u00a3\u00b7"+
		"\3\2\2\2\u00a4\u00ad\7\34\2\2\u00a5\u00aa\5\n\6\2\u00a6\u00a7\7\4\2\2"+
		"\u00a7\u00a9\5\n\6\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\u00a5\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b7\7\35"+
		"\2\2\u00b0\u00b7\t\2\2\2\u00b1\u00b2\7\62\2\2\u00b2\u00b3\7\34\2\2\u00b3"+
		"\u00b4\7\"\2\2\u00b4\u00b7\7\35\2\2\u00b5\u00b7\7\62\2\2\u00b6\u009c\3"+
		"\2\2\2\u00b6\u00a0\3\2\2\2\u00b6\u00a4\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6"+
		"\u00b1\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00cd\3\2\2\2\u00b8\u00b9\f\f"+
		"\2\2\u00b9\u00ba\7\r\2\2\u00ba\u00cc\5\n\6\r\u00bb\u00bc\f\13\2\2\u00bc"+
		"\u00bd\5\20\t\2\u00bd\u00be\5\n\6\f\u00be\u00cc\3\2\2\2\u00bf\u00c0\f"+
		"\n\2\2\u00c0\u00c1\5\22\n\2\u00c1\u00c2\5\n\6\13\u00c2\u00cc\3\2\2\2\u00c3"+
		"\u00c4\f\t\2\2\u00c4\u00c5\5\24\13\2\u00c5\u00c6\5\n\6\n\u00c6\u00cc\3"+
		"\2\2\2\u00c7\u00c8\f\b\2\2\u00c8\u00c9\5\26\f\2\u00c9\u00ca\5\n\6\t\u00ca"+
		"\u00cc\3\2\2\2\u00cb\u00b8\3\2\2\2\u00cb\u00bb\3\2\2\2\u00cb\u00bf\3\2"+
		"\2\2\u00cb\u00c3\3\2\2\2\u00cb\u00c7\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\13\3\2\2\2\u00cf\u00cd\3\2\2"+
		"\2\u00d0\u00d1\5\30\r\2\u00d1\u00d2\7\62\2\2\u00d2\u00d3\7\16\2\2\u00d3"+
		"\u00d4\5\n\6\2\u00d4\u00d7\3\2\2\2\u00d5\u00d7\7\62\2\2\u00d6\u00d0\3"+
		"\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\r\3\2\2\2\u00d8\u00d9\t\3\2\2\u00d9\17"+
		"\3\2\2\2\u00da\u00db\t\4\2\2\u00db\21\3\2\2\2\u00dc\u00dd\t\5\2\2\u00dd"+
		"\23\3\2\2\2\u00de\u00df\t\6\2\2\u00df\25\3\2\2\2\u00e0\u00e1\t\7\2\2\u00e1"+
		"\27\3\2\2\2\u00e2\u00e7\7\36\2\2\u00e3\u00e7\7 \2\2\u00e4\u00e7\7\37\2"+
		"\2\u00e5\u00e7\7!\2\2\u00e6\u00e2\3\2\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e4"+
		"\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\31\3\2\2\2\24#&+\65=H`f\177\u008b\u009a"+
		"\u00aa\u00ad\u00b6\u00cb\u00cd\u00d6\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}