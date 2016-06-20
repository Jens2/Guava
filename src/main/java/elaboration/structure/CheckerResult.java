package elaboration.structure;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class CheckerResult {
	private final ParseTreeProperty<ParserRuleContext> entries = new ParseTreeProperty<>();
	private final ParseTreeProperty<Type> types = new ParseTreeProperty<>();

	public void setEntry(ParseTree node, ParserRuleContext entry) {
		this.entries.put(node, entry);
	}

	public ParserRuleContext getEntry(ParseTree node) {
		return this.entries.get(node);
	}

	public void setType(ParseTree node, Type type) {
		this.types.put(node, type);
	}

	public Type getType(ParseTree node) {
		return this.types.get(node);
	}
}
