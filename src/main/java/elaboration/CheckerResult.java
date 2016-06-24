package elaboration;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.HashMap;
import java.util.Map;

public class CheckerResult {
	private final ParseTreeProperty<ParserRuleContext> entries = new ParseTreeProperty<>();
	private final ParseTreeProperty<Type> types = new ParseTreeProperty<>();
	private final ParseTreeProperty<Integer> offsets = new ParseTreeProperty<>();
    private final ParseTreeProperty<Boolean> globalVars = new ParseTreeProperty<>();
    private final Map<Integer, String> varMap = new HashMap<>();

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

    public void setOffset(ParseTree node, int offset) {
        this.offsets.put(node, offset);
        this.varMap.put(offset, node.getText());
    }

    public String getOffset(ParseTree node) {
        return String.valueOf(this.offsets.get(node));
    }

    public void setGlobalVar(ParseTree node, boolean global) {
        this.globalVars.put(node, global);
    }

    public boolean isGlobalVar(ParseTree node) {
        return (this.globalVars.get(node) != null);
    }

    public Map<Integer, String> getVarMap() {
        return varMap;
    }

}
