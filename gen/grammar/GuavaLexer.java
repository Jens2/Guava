// Generated from C:/Users/Jens/IdeaProjects/Guava/src/main/java/grammar\Guava.g4 by ANTLR 4.5.3
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
		POWER=10, MOD=11, ASSIGN=12, NOT=13, OR=14, AND=15, EQ=16, LT=17, LE=18, 
		GT=19, GE=20, NE=21, LBRACK=22, RBRACK=23, LPAR=24, RPAR=25, LSQBR=26, 
		RSQBR=27, INT=28, CHARACTER=29, BOOLEAN=30, NUM=31, BOOL=32, CHAR=33, 
		TRUE=34, FALSE=35, EPIC=36, IF=37, ELSE=38, FOR=39, WHILE=40, BRANCH=41, 
		OUT=42, GLOBAL=43, LOCK=44, UNLOCK=45, ID=46, COMMENTBLOCK=47, COMMENTLINE=48, 
		WS=49;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"DOT", "COMMA", "SEMI", "SQUOTE", "DQUOTE", "DIV", "MULT", "PLUS", "MINUS", 
		"POWER", "MOD", "ASSIGN", "NOT", "OR", "AND", "EQ", "LT", "LE", "GT", 
		"GE", "NE", "LBRACK", "RBRACK", "LPAR", "RPAR", "LSQBR", "RSQBR", "INT", 
		"CHARACTER", "BOOLEAN", "NUM", "BOOL", "CHAR", "TRUE", "FALSE", "EPIC", 
		"IF", "ELSE", "FOR", "WHILE", "BRANCH", "OUT", "GLOBAL", "LOCK", "UNLOCK", 
		"LETTER", "DIGIT09", "DIGIT19", "ID", "COMMENTBLOCK", "COMMENTLINE", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\63\u013f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \7 \u00b9\n \f \16 \u00bc\13 \5 \u00be\n \3!\3!"+
		"\5!\u00c2\n!\3\"\3\"\3\"\5\"\u00c7\n\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3"+
		"$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3("+
		"\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,"+
		"\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3/\3/\3\60\3"+
		"\60\3\61\3\61\3\62\3\62\3\62\7\62\u011b\n\62\f\62\16\62\u011e\13\62\3"+
		"\63\3\63\3\63\3\63\7\63\u0124\n\63\f\63\16\63\u0127\13\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\64\3\64\3\64\3\64\7\64\u0132\n\64\f\64\16\64\u0135\13"+
		"\64\3\64\3\64\3\65\6\65\u013a\n\65\r\65\16\65\u013b\3\65\3\65\3\u0125"+
		"\2\66\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\2_\2a\2c\60e\61g\62i\63\3\2\7"+
		"\4\2C\\c|\3\2\62;\3\2\63;\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u0144\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\2i\3\2\2\2\3k\3\2\2\2\5m\3\2\2\2\7o\3\2\2\2\tq\3\2\2\2\13s\3\2\2\2\r"+
		"u\3\2\2\2\17w\3\2\2\2\21y\3\2\2\2\23{\3\2\2\2\25}\3\2\2\2\27\177\3\2\2"+
		"\2\31\u0083\3\2\2\2\33\u0085\3\2\2\2\35\u0087\3\2\2\2\37\u0089\3\2\2\2"+
		"!\u008b\3\2\2\2#\u008e\3\2\2\2%\u0090\3\2\2\2\'\u0093\3\2\2\2)\u0095\3"+
		"\2\2\2+\u0098\3\2\2\2-\u009b\3\2\2\2/\u009d\3\2\2\2\61\u009f\3\2\2\2\63"+
		"\u00a1\3\2\2\2\65\u00a3\3\2\2\2\67\u00a5\3\2\2\29\u00a7\3\2\2\2;\u00ab"+
		"\3\2\2\2=\u00b0\3\2\2\2?\u00bd\3\2\2\2A\u00c1\3\2\2\2C\u00c3\3\2\2\2E"+
		"\u00ca\3\2\2\2G\u00d0\3\2\2\2I\u00d5\3\2\2\2K\u00dd\3\2\2\2M\u00e0\3\2"+
		"\2\2O\u00e5\3\2\2\2Q\u00e9\3\2\2\2S\u00ef\3\2\2\2U\u00f6\3\2\2\2W\u00fb"+
		"\3\2\2\2Y\u0105\3\2\2\2[\u010a\3\2\2\2]\u0111\3\2\2\2_\u0113\3\2\2\2a"+
		"\u0115\3\2\2\2c\u0117\3\2\2\2e\u011f\3\2\2\2g\u012d\3\2\2\2i\u0139\3\2"+
		"\2\2kl\7\60\2\2l\4\3\2\2\2mn\7.\2\2n\6\3\2\2\2op\7=\2\2p\b\3\2\2\2qr\7"+
		")\2\2r\n\3\2\2\2st\7$\2\2t\f\3\2\2\2uv\7\61\2\2v\16\3\2\2\2wx\7,\2\2x"+
		"\20\3\2\2\2yz\7-\2\2z\22\3\2\2\2{|\7/\2\2|\24\3\2\2\2}~\7`\2\2~\26\3\2"+
		"\2\2\177\u0080\7o\2\2\u0080\u0081\7q\2\2\u0081\u0082\7f\2\2\u0082\30\3"+
		"\2\2\2\u0083\u0084\7?\2\2\u0084\32\3\2\2\2\u0085\u0086\7\u0080\2\2\u0086"+
		"\34\3\2\2\2\u0087\u0088\7~\2\2\u0088\36\3\2\2\2\u0089\u008a\7(\2\2\u008a"+
		" \3\2\2\2\u008b\u008c\7?\2\2\u008c\u008d\7?\2\2\u008d\"\3\2\2\2\u008e"+
		"\u008f\7>\2\2\u008f$\3\2\2\2\u0090\u0091\7>\2\2\u0091\u0092\7?\2\2\u0092"+
		"&\3\2\2\2\u0093\u0094\7@\2\2\u0094(\3\2\2\2\u0095\u0096\7@\2\2\u0096\u0097"+
		"\7?\2\2\u0097*\3\2\2\2\u0098\u0099\7\u0080\2\2\u0099\u009a\7?\2\2\u009a"+
		",\3\2\2\2\u009b\u009c\7}\2\2\u009c.\3\2\2\2\u009d\u009e\7\177\2\2\u009e"+
		"\60\3\2\2\2\u009f\u00a0\7*\2\2\u00a0\62\3\2\2\2\u00a1\u00a2\7+\2\2\u00a2"+
		"\64\3\2\2\2\u00a3\u00a4\7]\2\2\u00a4\66\3\2\2\2\u00a5\u00a6\7_\2\2\u00a6"+
		"8\3\2\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7v\2\2\u00aa"+
		":\3\2\2\2\u00ab\u00ac\7e\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7c\2\2\u00ae"+
		"\u00af\7t\2\2\u00af<\3\2\2\2\u00b0\u00b1\7r\2\2\u00b1\u00b2\7w\2\2\u00b2"+
		"\u00b3\7n\2\2\u00b3\u00b4\7r\2\2\u00b4>\3\2\2\2\u00b5\u00be\7\62\2\2\u00b6"+
		"\u00ba\5a\61\2\u00b7\u00b9\5_\60\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2"+
		"\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bd\u00b5\3\2\2\2\u00bd\u00b6\3\2\2\2\u00be@\3\2\2\2"+
		"\u00bf\u00c2\5E#\2\u00c0\u00c2\5G$\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3"+
		"\2\2\2\u00c2B\3\2\2\2\u00c3\u00c6\5\t\5\2\u00c4\u00c7\5]/\2\u00c5\u00c7"+
		"\5_\60\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c9\5\t\5\2\u00c9D\3\2\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cc\7y\2\2\u00cc"+
		"\u00cd\7g\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7v\2\2\u00cfF\3\2\2\2\u00d0"+
		"\u00d1\7u\2\2\u00d1\u00d2\7q\2\2\u00d2\u00d3\7w\2\2\u00d3\u00d4\7t\2\2"+
		"\u00d4H\3\2\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7r\2\2\u00d7\u00d8\7k\2"+
		"\2\u00d8\u00d9\7e\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7t\2\2\u00db\u00dc"+
		"\7r\2\2\u00dcJ\3\2\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7h\2\2\u00dfL\3"+
		"\2\2\2\u00e0\u00e1\7g\2\2\u00e1\u00e2\7n\2\2\u00e2\u00e3\7u\2\2\u00e3"+
		"\u00e4\7g\2\2\u00e4N\3\2\2\2\u00e5\u00e6\7h\2\2\u00e6\u00e7\7q\2\2\u00e7"+
		"\u00e8\7t\2\2\u00e8P\3\2\2\2\u00e9\u00ea\7y\2\2\u00ea\u00eb\7j\2\2\u00eb"+
		"\u00ec\7k\2\2\u00ec\u00ed\7n\2\2\u00ed\u00ee\7g\2\2\u00eeR\3\2\2\2\u00ef"+
		"\u00f0\7d\2\2\u00f0\u00f1\7t\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7p\2\2"+
		"\u00f3\u00f4\7e\2\2\u00f4\u00f5\7j\2\2\u00f5T\3\2\2\2\u00f6\u00f7\7f\2"+
		"\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7q\2\2\u00f9\u00fa\7r\2\2\u00faV\3\2"+
		"\2\2\u00fb\u00fc\7w\2\2\u00fc\u00fd\7p\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff"+
		"\7x\2\2\u00ff\u0100\7g\2\2\u0100\u0101\7t\2\2\u0101\u0102\7u\2\2\u0102"+
		"\u0103\7c\2\2\u0103\u0104\7n\2\2\u0104X\3\2\2\2\u0105\u0106\7n\2\2\u0106"+
		"\u0107\7q\2\2\u0107\u0108\7e\2\2\u0108\u0109\7m\2\2\u0109Z\3\2\2\2\u010a"+
		"\u010b\7w\2\2\u010b\u010c\7p\2\2\u010c\u010d\7n\2\2\u010d\u010e\7q\2\2"+
		"\u010e\u010f\7e\2\2\u010f\u0110\7m\2\2\u0110\\\3\2\2\2\u0111\u0112\t\2"+
		"\2\2\u0112^\3\2\2\2\u0113\u0114\t\3\2\2\u0114`\3\2\2\2\u0115\u0116\t\4"+
		"\2\2\u0116b\3\2\2\2\u0117\u011c\5]/\2\u0118\u011b\5]/\2\u0119\u011b\5"+
		"_\60\2\u011a\u0118\3\2\2\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c"+
		"\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011dd\3\2\2\2\u011e\u011c\3\2\2\2"+
		"\u011f\u0120\7@\2\2\u0120\u0121\7\u0080\2\2\u0121\u0125\3\2\2\2\u0122"+
		"\u0124\13\2\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0126\3"+
		"\2\2\2\u0125\u0123\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128"+
		"\u0129\7\u0080\2\2\u0129\u012a\7>\2\2\u012a\u012b\3\2\2\2\u012b\u012c"+
		"\b\63\2\2\u012cf\3\2\2\2\u012d\u012e\7@\2\2\u012e\u012f\7@\2\2\u012f\u0133"+
		"\3\2\2\2\u0130\u0132\n\5\2\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2"+
		"\2\2\u0136\u0137\b\64\2\2\u0137h\3\2\2\2\u0138\u013a\t\6\2\2\u0139\u0138"+
		"\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013e\b\65\2\2\u013ej\3\2\2\2\f\2\u00ba\u00bd\u00c1"+
		"\u00c6\u011a\u011c\u0125\u0133\u013b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}