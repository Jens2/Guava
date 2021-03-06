// Generated from C:/Users/Dion/Documents/TI/Module 8/Guava/src/main/java/grammar\Guava.g4 by ANTLR 4.5.3
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GuavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, COMMA=2, SEMI=3, SQUOTE=4, DQUOTE=5, DIV=6, MULT=7, PLUS=8, MINUS=9, 
		POWER=10, ASSIGN=11, NOT=12, OR=13, AND=14, EQ=15, LT=16, LE=17, GT=18, 
		GE=19, NE=20, LBRACK=21, RBRACK=22, LPAR=23, RPAR=24, LSQBR=25, RSQBR=26, 
		INT=27, CHARACTER=28, BOOLEAN=29, NUM=30, BOOL=31, CHAR=32, TRUE=33, FALSE=34, 
		EPIC=35, IF=36, ELSE=37, FOR=38, WHILE=39, BRANCH=40, GLOBAL=41, LOCK=42, 
		ID=43, COMMENTBLOCK=44, COMMENTLINE=45, WS=46;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"DOT", "COMMA", "SEMI", "SQUOTE", "DQUOTE", "DIV", "MULT", "PLUS", "MINUS", 
		"POWER", "ASSIGN", "NOT", "OR", "AND", "EQ", "LT", "LE", "GT", "GE", "NE", 
		"LBRACK", "RBRACK", "LPAR", "RPAR", "LSQBR", "RSQBR", "INT", "CHARACTER", 
		"BOOLEAN", "NUM", "BOOL", "CHAR", "TRUE", "FALSE", "EPIC", "IF", "ELSE", 
		"FOR", "WHILE", "BRANCH", "GLOBAL", "LOCK", "LETTER", "DIGIT09", "DIGIT19", 
		"ID", "COMMENTBLOCK", "COMMENTLINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "','", "';'", "'''", "'\"'", "'/'", "'*'", "'+'", "'-'", 
		"'^'", "'='", "'~'", "'|'", "'&'", "'=='", "'<'", "'<='", "'>'", "'>='", 
		"'~='", "'{'", "'}'", "'('", "')'", "'['", "']'", "'int'", "'char'", "'pulp'", 
		null, null, null, "'sweet'", "'sour'", "'epicarp'", "'if'", "'else'", 
		"'for'", "'while'", "'branch'", "'universal'", "'lock'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DOT", "COMMA", "SEMI", "SQUOTE", "DQUOTE", "DIV", "MULT", "PLUS", 
		"MINUS", "POWER", "ASSIGN", "NOT", "OR", "AND", "EQ", "LT", "LE", "GT", 
		"GE", "NE", "LBRACK", "RBRACK", "LPAR", "RPAR", "LSQBR", "RSQBR", "INT", 
		"CHARACTER", "BOOLEAN", "NUM", "BOOL", "CHAR", "TRUE", "FALSE", "EPIC", 
		"IF", "ELSE", "FOR", "WHILE", "BRANCH", "GLOBAL", "LOCK", "ID", "COMMENTBLOCK", 
		"COMMENTLINE", "WS"
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


	public GuavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Guava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\60\u0129\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\7\37\u00af\n\37\f\37"+
		"\16\37\u00b2\13\37\5\37\u00b4\n\37\3 \3 \5 \u00b8\n \3!\3!\3!\5!\u00bd"+
		"\n!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3"+
		")\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3-\3"+
		"-\3.\3.\3/\3/\3/\7/\u0105\n/\f/\16/\u0108\13/\3\60\3\60\3\60\3\60\7\60"+
		"\u010e\n\60\f\60\16\60\u0111\13\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\3\61\7\61\u011c\n\61\f\61\16\61\u011f\13\61\3\61\3\61\3\62\6\62"+
		"\u0124\n\62\r\62\16\62\u0125\3\62\3\62\3\u010f\2\63\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W\2Y\2[\2]-_.a/c\60\3\2\7\4\2C\\c|\3\2\62;\3\2\63;\4\2\f\f\17"+
		"\17\5\2\13\f\17\17\"\"\u012e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\3e\3\2\2\2\5g\3\2\2\2\7i\3\2\2\2\tk\3\2\2\2\13m\3\2\2\2\r"+
		"o\3\2\2\2\17q\3\2\2\2\21s\3\2\2\2\23u\3\2\2\2\25w\3\2\2\2\27y\3\2\2\2"+
		"\31{\3\2\2\2\33}\3\2\2\2\35\177\3\2\2\2\37\u0081\3\2\2\2!\u0084\3\2\2"+
		"\2#\u0086\3\2\2\2%\u0089\3\2\2\2\'\u008b\3\2\2\2)\u008e\3\2\2\2+\u0091"+
		"\3\2\2\2-\u0093\3\2\2\2/\u0095\3\2\2\2\61\u0097\3\2\2\2\63\u0099\3\2\2"+
		"\2\65\u009b\3\2\2\2\67\u009d\3\2\2\29\u00a1\3\2\2\2;\u00a6\3\2\2\2=\u00b3"+
		"\3\2\2\2?\u00b7\3\2\2\2A\u00b9\3\2\2\2C\u00c0\3\2\2\2E\u00c6\3\2\2\2G"+
		"\u00cb\3\2\2\2I\u00d3\3\2\2\2K\u00d6\3\2\2\2M\u00db\3\2\2\2O\u00df\3\2"+
		"\2\2Q\u00e5\3\2\2\2S\u00ec\3\2\2\2U\u00f6\3\2\2\2W\u00fb\3\2\2\2Y\u00fd"+
		"\3\2\2\2[\u00ff\3\2\2\2]\u0101\3\2\2\2_\u0109\3\2\2\2a\u0117\3\2\2\2c"+
		"\u0123\3\2\2\2ef\7\60\2\2f\4\3\2\2\2gh\7.\2\2h\6\3\2\2\2ij\7=\2\2j\b\3"+
		"\2\2\2kl\7)\2\2l\n\3\2\2\2mn\7$\2\2n\f\3\2\2\2op\7\61\2\2p\16\3\2\2\2"+
		"qr\7,\2\2r\20\3\2\2\2st\7-\2\2t\22\3\2\2\2uv\7/\2\2v\24\3\2\2\2wx\7`\2"+
		"\2x\26\3\2\2\2yz\7?\2\2z\30\3\2\2\2{|\7\u0080\2\2|\32\3\2\2\2}~\7~\2\2"+
		"~\34\3\2\2\2\177\u0080\7(\2\2\u0080\36\3\2\2\2\u0081\u0082\7?\2\2\u0082"+
		"\u0083\7?\2\2\u0083 \3\2\2\2\u0084\u0085\7>\2\2\u0085\"\3\2\2\2\u0086"+
		"\u0087\7>\2\2\u0087\u0088\7?\2\2\u0088$\3\2\2\2\u0089\u008a\7@\2\2\u008a"+
		"&\3\2\2\2\u008b\u008c\7@\2\2\u008c\u008d\7?\2\2\u008d(\3\2\2\2\u008e\u008f"+
		"\7\u0080\2\2\u008f\u0090\7?\2\2\u0090*\3\2\2\2\u0091\u0092\7}\2\2\u0092"+
		",\3\2\2\2\u0093\u0094\7\177\2\2\u0094.\3\2\2\2\u0095\u0096\7*\2\2\u0096"+
		"\60\3\2\2\2\u0097\u0098\7+\2\2\u0098\62\3\2\2\2\u0099\u009a\7]\2\2\u009a"+
		"\64\3\2\2\2\u009b\u009c\7_\2\2\u009c\66\3\2\2\2\u009d\u009e\7k\2\2\u009e"+
		"\u009f\7p\2\2\u009f\u00a0\7v\2\2\u00a08\3\2\2\2\u00a1\u00a2\7e\2\2\u00a2"+
		"\u00a3\7j\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7t\2\2\u00a5:\3\2\2\2\u00a6"+
		"\u00a7\7r\2\2\u00a7\u00a8\7w\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7r\2\2"+
		"\u00aa<\3\2\2\2\u00ab\u00b4\7\62\2\2\u00ac\u00b0\5[.\2\u00ad\u00af\5Y"+
		"-\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00ab\3\2"+
		"\2\2\u00b3\u00ac\3\2\2\2\u00b4>\3\2\2\2\u00b5\u00b8\5C\"\2\u00b6\u00b8"+
		"\5E#\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8@\3\2\2\2\u00b9\u00bc"+
		"\5\t\5\2\u00ba\u00bd\5W,\2\u00bb\u00bd\5Y-\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\5\t\5\2\u00bfB\3\2\2\2"+
		"\u00c0\u00c1\7u\2\2\u00c1\u00c2\7y\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4"+
		"\7g\2\2\u00c4\u00c5\7v\2\2\u00c5D\3\2\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8"+
		"\7q\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7t\2\2\u00caF\3\2\2\2\u00cb\u00cc"+
		"\7g\2\2\u00cc\u00cd\7r\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7e\2\2\u00cf"+
		"\u00d0\7c\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2\7r\2\2\u00d2H\3\2\2\2\u00d3"+
		"\u00d4\7k\2\2\u00d4\u00d5\7h\2\2\u00d5J\3\2\2\2\u00d6\u00d7\7g\2\2\u00d7"+
		"\u00d8\7n\2\2\u00d8\u00d9\7u\2\2\u00d9\u00da\7g\2\2\u00daL\3\2\2\2\u00db"+
		"\u00dc\7h\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7t\2\2\u00deN\3\2\2\2\u00df"+
		"\u00e0\7y\2\2\u00e0\u00e1\7j\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3\7n\2\2"+
		"\u00e3\u00e4\7g\2\2\u00e4P\3\2\2\2\u00e5\u00e6\7d\2\2\u00e6\u00e7\7t\2"+
		"\2\u00e7\u00e8\7c\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea\7e\2\2\u00ea\u00eb"+
		"\7j\2\2\u00ebR\3\2\2\2\u00ec\u00ed\7w\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef"+
		"\7k\2\2\u00ef\u00f0\7x\2\2\u00f0\u00f1\7g\2\2\u00f1\u00f2\7t\2\2\u00f2"+
		"\u00f3\7u\2\2\u00f3\u00f4\7c\2\2\u00f4\u00f5\7n\2\2\u00f5T\3\2\2\2\u00f6"+
		"\u00f7\7n\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7e\2\2\u00f9\u00fa\7m\2\2"+
		"\u00faV\3\2\2\2\u00fb\u00fc\t\2\2\2\u00fcX\3\2\2\2\u00fd\u00fe\t\3\2\2"+
		"\u00feZ\3\2\2\2\u00ff\u0100\t\4\2\2\u0100\\\3\2\2\2\u0101\u0106\5W,\2"+
		"\u0102\u0105\5W,\2\u0103\u0105\5Y-\2\u0104\u0102\3\2\2\2\u0104\u0103\3"+
		"\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"^\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a\7@\2\2\u010a\u010b\7\u0080\2"+
		"\2\u010b\u010f\3\2\2\2\u010c\u010e\13\2\2\2\u010d\u010c\3\2\2\2\u010e"+
		"\u0111\3\2\2\2\u010f\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0112\3\2"+
		"\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7\u0080\2\2\u0113\u0114\7>\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0116\b\60\2\2\u0116`\3\2\2\2\u0117\u0118\7@\2\2"+
		"\u0118\u0119\7@\2\2\u0119\u011d\3\2\2\2\u011a\u011c\n\5\2\2\u011b\u011a"+
		"\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\b\61\2\2\u0121b\3\2\2\2"+
		"\u0122\u0124\t\6\2\2\u0123\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0123"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\b\62\2\2"+
		"\u0128d\3\2\2\2\f\2\u00b0\u00b3\u00b7\u00bc\u0104\u0106\u010f\u011d\u0125"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}