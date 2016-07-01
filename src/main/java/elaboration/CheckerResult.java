package elaboration;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.HashMap;
import java.util.Map;

public class CheckerResult {

    /**
     * Contains the entry points for all nodes
     */
    private final ParseTreeProperty<ParserRuleContext> entries = new ParseTreeProperty<>();

    /**
     * Contains the types for all nodes/variables
     */
    private final ParseTreeProperty<Type> types = new ParseTreeProperty<>();

    /**
     * Contains the offsets for all nodes/variables
     */
    private final ParseTreeProperty<Integer> offsets = new ParseTreeProperty<>();

    /**
     * Contains the offsets for all global nodes/variables
     */
    private final ParseTreeProperty<Integer> globalOffsets = new ParseTreeProperty<>();

    /**
     * Contains whether a node/variable is defined as global or not
     */
    private final ParseTreeProperty<Boolean> globalVars = new ParseTreeProperty<>();

    /**
     * Contains all local offsets mapped to a variable name
     */
    private final Map<Integer, String> varMap = new HashMap<>();

    /**
     * Contains all global offsets mapped to a variable name
     */
    private final Map<Integer, String> globalVarMap = new HashMap<>();

    /**
     * Contains arrays and their lengths
     */
    private final Map<String, Integer> arrayLength = new HashMap<>();

    /**
     * Indicates whether the Guava program that is being parsed uses any concurrency
     */
    private boolean isConc = false;

    private ParserRuleContext lastBranch;

    /**
     * Sets the concurrency flag for this program
     * @param conc <tt>true</tt> if the program uses any concurrency
     */
    public void setConc(boolean conc) {
        isConc = conc;
    }

    /**
     * Returns the value of the concurrency flag for this program
     * @return <tt>true</tt> if the program uses any concurrency
     */
    public boolean isConc() {
        return isConc;
    }

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

    public void setOffset(ParseTree node, int offset, boolean global) {
        if (global) {
            this.globalOffsets.put(node, offset);
            this.globalVarMap.put(offset, node.getText());
        } else {
            this.offsets.put(node, offset);
            this.varMap.put(offset, node.getText());
        }
    }

    public String getOffset(ParseTree node, boolean global) {
        if (global) {
            return String.valueOf(this.globalOffsets.get(node));
        } else {
            return String.valueOf(this.offsets.get(node));
        }
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

    public Map<Integer, String> getGlobalVarMap() {
        return this.globalVarMap;
    }

    public void setArrayLength(ParseTree node, int length) {
        this.arrayLength.put(node.getText(), length);
    }

    public int getArrayLength(ParseTree node) {
        return this.arrayLength.get(node.getText());
    }

    public void setLastBranch(ParserRuleContext ctx) {
        this.lastBranch = ctx;
    }

    public ParserRuleContext getLastBranch() {
        return this.lastBranch;
    }
}
