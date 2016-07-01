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
		RSQBR=27, INT=28, CHARACTER=29, BOOLEAN=30, NUM=31, BOOL=32, CHAR=33, 
		TRUE=34, FALSE=35, EPIC=36, IF=37, ELSE=38, FOR=39, WHILE=40, BRANCH=41, 
		OUT=42, GLOBAL=43, LOCK=44, UNLOCK=45, ID=46, COMMENTBLOCK=47, COMMENTLINE=48, 
		WS=49;
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
		"'pulp'", null, null, null, "'sweet'", "'sour'", "'epicarp'", "'if'", 
		"'else'", "'for'", "'while'", "'branch'", "'drop'", "'universal'", "'lock'", 
		"'unlock'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOT", "COMMA", "SEMI", "SQUOTE", "DQUOTE", "DIV", "MULT", "PLUS", 
		"MINUS", "POWER", "MOD", "ASSIGN", "NOT", "OR", "AND", "EQ", "LT", "LE", 
		"GT", "GE", "NE", "LBRACK", "RBRACK", "LPAR", "RPAR", "LSQBR", "RSQBR", 
		"INT", "CHARACTER", "BOOLEAN", "NUM", "BOOL", "CHAR", "TRUE", "FALSE", 
		"EPIC", "IF", "ELSE", "FOR", "WHILE", "BRANCH", "OUT", "GLOBAL", "LOCK", 
		"UNLOCK", "ID", "COMMENTBLOCK", "COMMENTLINE", "WS"
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
		public List<GlobalContext> global() {
			return getRuleContexts(GlobalContext.class);
		}
		public GlobalContext global(int i) {
			return getRuleContext(GlobalContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
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
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GLOBAL) {
				{
				{
				setState(28);
				global();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACK) | (1L << INT) | (1L << CHARACTER) | (1L << BOOLEAN) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BRANCH) | (1L << LOCK) | (1L << ID))) != 0)) {
				{
				{
				setState(34);
				stat();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
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
		public TerminalNode SEMI() { return getToken(GuavaParser.SEMI, 0); }
		public TerminalNode ID() { return getToken(GuavaParser.ID, 0); }
		public TerminalNode LSQBR() { return getToken(GuavaParser.LSQBR, 0); }
		public TerminalNode NUM() { return getToken(GuavaParser.NUM, 0); }
		public TerminalNode RSQBR() { return getToken(GuavaParser.RSQBR, 0); }
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
			setState(42);
			match(GLOBAL);
			setState(43);
			type();
			setState(49);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(44);
				match(ID);
				}
				break;
			case LSQBR:
				{
				setState(45);
				match(LSQBR);
				setState(46);
				match(NUM);
				setState(47);
				match(RSQBR);
				setState(48);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(53);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(51);
				match(ASSIGN);
				setState(52);
				expr(0);
				}
			}

			setState(55);
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
	public static class BranchStatContext extends StatContext {
		public TerminalNode BRANCH() { return getToken(GuavaParser.BRANCH, 0); }
		public TerminalNode LBRACK() { return getToken(GuavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(GuavaParser.RBRACK, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BranchStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).enterBranchStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GuavaListener ) ((GuavaListener)listener).exitBranchStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GuavaVisitor ) return ((GuavaVisitor<? extends T>)visitor).visitBranchStat(this);
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
		public TerminalNode LBRACK() { return getToken(GuavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(GuavaParser.RBRACK, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
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
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new VarDeclStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				type();
				setState(58);
				match(ID);
				setState(61);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(59);
					match(ASSIGN);
					setState(60);
					expr(0);
					}
				}

				setState(63);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new ArrayDeclStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				type();
				setState(66);
				match(LSQBR);
				setState(67);
				match(NUM);
				setState(68);
				match(RSQBR);
				setState(69);
				match(ID);
				setState(72);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(70);
					match(ASSIGN);
					setState(71);
					expr(0);
					}
				}

				setState(74);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(ID);
				setState(77);
				match(ASSIGN);
				setState(78);
				expr(0);
				setState(79);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new AssignArrayStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				match(ID);
				setState(82);
				match(LSQBR);
				setState(83);
				match(NUM);
				setState(84);
				match(RSQBR);
				setState(85);
				match(ASSIGN);
				setState(86);
				expr(0);
				setState(87);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(89);
				match(IF);
				setState(90);
				match(LPAR);
				setState(91);
				expr(0);
				setState(92);
				match(RPAR);
				setState(93);
				stat();
				setState(96);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(94);
					match(ELSE);
					setState(95);
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
				setState(98);
				match(LBRACK);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACK) | (1L << INT) | (1L << CHARACTER) | (1L << BOOLEAN) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BRANCH) | (1L << LOCK) | (1L << ID))) != 0)) {
					{
					{
					setState(99);
					stat();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				match(RBRACK);
				}
				break;
			case 7:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(106);
				match(WHILE);
				setState(107);
				match(LPAR);
				setState(108);
				expr(0);
				setState(109);
				match(RPAR);
				setState(110);
				stat();
				}
				break;
			case 8:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(112);
				match(FOR);
				setState(113);
				match(LPAR);
				setState(114);
				forAss();
				setState(115);
				match(SEMI);
				setState(116);
				expr(0);
				setState(117);
				match(SEMI);
				setState(127);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(118);
					match(ID);
					setState(119);
					match(ASSIGN);
					setState(120);
					expr(0);
					}
					break;
				case 2:
					{
					setState(121);
					match(ID);
					setState(122);
					match(PLUS);
					setState(123);
					match(PLUS);
					}
					break;
				case 3:
					{
					setState(124);
					match(ID);
					setState(125);
					match(MINUS);
					setState(126);
					match(MINUS);
					}
					break;
				}
				setState(129);
				match(RPAR);
				setState(130);
				stat();
				}
				break;
			case 9:
				_localctx = new BranchStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(132);
				match(BRANCH);
				setState(133);
				match(LBRACK);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACK) | (1L << INT) | (1L << CHARACTER) | (1L << BOOLEAN) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BRANCH) | (1L << LOCK) | (1L << ID))) != 0)) {
					{
					{
					setState(134);
					stat();
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(140);
				match(RBRACK);
				}
				break;
			case 10:
				_localctx = new LockStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(141);
				match(LOCK);
				setState(142);
				match(LPAR);
				setState(143);
				match(ID);
				setState(144);
				match(RPAR);
				setState(145);
				match(LBRACK);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACK) | (1L << INT) | (1L << CHARACTER) | (1L << BOOLEAN) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BRANCH) | (1L << LOCK) | (1L << ID))) != 0)) {
					{
					{
					setState(146);
					stat();
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(152);
				match(RBRACK);
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
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new PrfExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(156);
				prfOp();
				setState(157);
				expr(11);
				}
				break;
			case 2:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(LPAR);
				setState(160);
				expr(0);
				setState(161);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(LSQBR);
				setState(172);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LPAR) | (1L << LSQBR) | (1L << NUM) | (1L << BOOL) | (1L << CHAR) | (1L << ID))) != 0)) {
					{
					setState(164);
					expr(0);
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(165);
						match(COMMA);
						setState(166);
						expr(0);
						}
						}
						setState(171);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(174);
				match(RSQBR);
				}
				break;
			case 4:
				{
				_localctx = new ConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM) | (1L << BOOL) | (1L << CHAR))) != 0)) ) {
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
				setState(176);
				match(ID);
				setState(177);
				match(LSQBR);
				setState(178);
				match(NUM);
				setState(179);
				match(RSQBR);
				}
				break;
			case 6:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(202);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ModExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(183);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(184);
						match(MOD);
						setState(185);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(186);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(187);
						multOp();
						setState(188);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new PlusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(190);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(191);
						plusOp();
						setState(192);
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(194);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(195);
						boolOp();
						setState(196);
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(199);
						compOp();
						setState(200);
						expr(7);
						}
						break;
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
			setState(213);
			switch (_input.LA(1)) {
			case INT:
			case CHARACTER:
			case BOOLEAN:
				_localctx = new ForDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				type();
				setState(208);
				match(ID);
				setState(209);
				match(ASSIGN);
				setState(210);
				expr(0);
				}
				break;
			case ID:
				_localctx = new ForExistingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
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
			setState(215);
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
			setState(217);
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
			setState(219);
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
			setState(221);
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
			setState(223);
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
				setState(225);
				match(INT);
				}
				break;
			case BOOLEAN:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(BOOLEAN);
				}
				break;
			case CHARACTER:
				_localctx = new CharTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				match(CHARACTER);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u00e9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3\3"+
		"\7\3&\n\3\f\3\16\3)\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\64\n"+
		"\4\3\4\3\4\5\48\n\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5@\n\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5c\n\5\3\5\3\5\7\5g\n"+
		"\5\f\5\16\5j\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0082\n\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\7\5\u008a\n\5\f\5\16\5\u008d\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5"+
		"\u0096\n\5\f\5\16\5\u0099\13\5\3\5\5\5\u009c\n\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00aa\n\6\f\6\16\6\u00ad\13\6\5\6\u00af"+
		"\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00b8\n\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00cd\n\6\f\6"+
		"\16\6\u00d0\13\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00d8\n\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\5\r\u00e7\n\r\3\r\2\3\n\16\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\2\b\3\2!#\4\2\13\13\17\17\4\2\b\t\f\f\3\2\n"+
		"\13\3\2\20\21\3\2\22\27\u0100\2\32\3\2\2\2\4\35\3\2\2\2\6,\3\2\2\2\b\u009b"+
		"\3\2\2\2\n\u00b7\3\2\2\2\f\u00d7\3\2\2\2\16\u00d9\3\2\2\2\20\u00db\3\2"+
		"\2\2\22\u00dd\3\2\2\2\24\u00df\3\2\2\2\26\u00e1\3\2\2\2\30\u00e6\3\2\2"+
		"\2\32\33\7&\2\2\33\34\5\4\3\2\34\3\3\2\2\2\35!\7\30\2\2\36 \5\6\4\2\37"+
		"\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\'\3\2\2\2#!\3\2\2\2$&\5"+
		"\b\5\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2"+
		"*+\7\31\2\2+\5\3\2\2\2,-\7-\2\2-\63\5\30\r\2.\64\7\60\2\2/\60\7\34\2\2"+
		"\60\61\7!\2\2\61\62\7\35\2\2\62\64\7\60\2\2\63.\3\2\2\2\63/\3\2\2\2\64"+
		"\67\3\2\2\2\65\66\7\16\2\2\668\5\n\6\2\67\65\3\2\2\2\678\3\2\2\289\3\2"+
		"\2\29:\7\5\2\2:\7\3\2\2\2;<\5\30\r\2<?\7\60\2\2=>\7\16\2\2>@\5\n\6\2?"+
		"=\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\5\2\2B\u009c\3\2\2\2CD\5\30\r\2DE\7"+
		"\34\2\2EF\7!\2\2FG\7\35\2\2GJ\7\60\2\2HI\7\16\2\2IK\5\n\6\2JH\3\2\2\2"+
		"JK\3\2\2\2KL\3\2\2\2LM\7\5\2\2M\u009c\3\2\2\2NO\7\60\2\2OP\7\16\2\2PQ"+
		"\5\n\6\2QR\7\5\2\2R\u009c\3\2\2\2ST\7\60\2\2TU\7\34\2\2UV\7!\2\2VW\7\35"+
		"\2\2WX\7\16\2\2XY\5\n\6\2YZ\7\5\2\2Z\u009c\3\2\2\2[\\\7\'\2\2\\]\7\32"+
		"\2\2]^\5\n\6\2^_\7\33\2\2_b\5\b\5\2`a\7(\2\2ac\5\b\5\2b`\3\2\2\2bc\3\2"+
		"\2\2c\u009c\3\2\2\2dh\7\30\2\2eg\5\b\5\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2"+
		"hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2k\u009c\7\31\2\2lm\7*\2\2mn\7\32\2\2no\5"+
		"\n\6\2op\7\33\2\2pq\5\b\5\2q\u009c\3\2\2\2rs\7)\2\2st\7\32\2\2tu\5\f\7"+
		"\2uv\7\5\2\2vw\5\n\6\2w\u0081\7\5\2\2xy\7\60\2\2yz\7\16\2\2z\u0082\5\n"+
		"\6\2{|\7\60\2\2|}\7\n\2\2}\u0082\7\n\2\2~\177\7\60\2\2\177\u0080\7\13"+
		"\2\2\u0080\u0082\7\13\2\2\u0081x\3\2\2\2\u0081{\3\2\2\2\u0081~\3\2\2\2"+
		"\u0082\u0083\3\2\2\2\u0083\u0084\7\33\2\2\u0084\u0085\5\b\5\2\u0085\u009c"+
		"\3\2\2\2\u0086\u0087\7+\2\2\u0087\u008b\7\30\2\2\u0088\u008a\5\b\5\2\u0089"+
		"\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u009c\7\31\2\2\u008f"+
		"\u0090\7.\2\2\u0090\u0091\7\32\2\2\u0091\u0092\7\60\2\2\u0092\u0093\7"+
		"\33\2\2\u0093\u0097\7\30\2\2\u0094\u0096\5\b\5\2\u0095\u0094\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u009a\u009c\7\31\2\2\u009b;\3\2\2\2\u009bC\3"+
		"\2\2\2\u009bN\3\2\2\2\u009bS\3\2\2\2\u009b[\3\2\2\2\u009bd\3\2\2\2\u009b"+
		"l\3\2\2\2\u009br\3\2\2\2\u009b\u0086\3\2\2\2\u009b\u008f\3\2\2\2\u009c"+
		"\t\3\2\2\2\u009d\u009e\b\6\1\2\u009e\u009f\5\16\b\2\u009f\u00a0\5\n\6"+
		"\r\u00a0\u00b8\3\2\2\2\u00a1\u00a2\7\32\2\2\u00a2\u00a3\5\n\6\2\u00a3"+
		"\u00a4\7\33\2\2\u00a4\u00b8\3\2\2\2\u00a5\u00ae\7\34\2\2\u00a6\u00ab\5"+
		"\n\6\2\u00a7\u00a8\7\4\2\2\u00a8\u00aa\5\n\6\2\u00a9\u00a7\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00af\3\2"+
		"\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b8\7\35\2\2\u00b1\u00b8\t\2\2\2\u00b2\u00b3\7"+
		"\60\2\2\u00b3\u00b4\7\34\2\2\u00b4\u00b5\7!\2\2\u00b5\u00b8\7\35\2\2\u00b6"+
		"\u00b8\7\60\2\2\u00b7\u009d\3\2\2\2\u00b7\u00a1\3\2\2\2\u00b7\u00a5\3"+
		"\2\2\2\u00b7\u00b1\3\2\2\2\u00b7\u00b2\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\u00ce\3\2\2\2\u00b9\u00ba\f\f\2\2\u00ba\u00bb\7\r\2\2\u00bb\u00cd\5\n"+
		"\6\r\u00bc\u00bd\f\13\2\2\u00bd\u00be\5\20\t\2\u00be\u00bf\5\n\6\f\u00bf"+
		"\u00cd\3\2\2\2\u00c0\u00c1\f\n\2\2\u00c1\u00c2\5\22\n\2\u00c2\u00c3\5"+
		"\n\6\13\u00c3\u00cd\3\2\2\2\u00c4\u00c5\f\t\2\2\u00c5\u00c6\5\24\13\2"+
		"\u00c6\u00c7\5\n\6\n\u00c7\u00cd\3\2\2\2\u00c8\u00c9\f\b\2\2\u00c9\u00ca"+
		"\5\26\f\2\u00ca\u00cb\5\n\6\t\u00cb\u00cd\3\2\2\2\u00cc\u00b9\3\2\2\2"+
		"\u00cc\u00bc\3\2\2\2\u00cc\u00c0\3\2\2\2\u00cc\u00c4\3\2\2\2\u00cc\u00c8"+
		"\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\13\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\5\30\r\2\u00d2\u00d3\7\60"+
		"\2\2\u00d3\u00d4\7\16\2\2\u00d4\u00d5\5\n\6\2\u00d5\u00d8\3\2\2\2\u00d6"+
		"\u00d8\7\60\2\2\u00d7\u00d1\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\r\3\2\2"+
		"\2\u00d9\u00da\t\3\2\2\u00da\17\3\2\2\2\u00db\u00dc\t\4\2\2\u00dc\21\3"+
		"\2\2\2\u00dd\u00de\t\5\2\2\u00de\23\3\2\2\2\u00df\u00e0\t\6\2\2\u00e0"+
		"\25\3\2\2\2\u00e1\u00e2\t\7\2\2\u00e2\27\3\2\2\2\u00e3\u00e7\7\36\2\2"+
		"\u00e4\u00e7\7 \2\2\u00e5\u00e7\7\37\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e4"+
		"\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\31\3\2\2\2\25!\'\63\67?Jbh\u0081\u008b"+
		"\u0097\u009b\u00ab\u00ae\u00b7\u00cc\u00ce\u00d7\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}