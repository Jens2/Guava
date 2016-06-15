import grammar.GuavaBaseListener;
import org.antlr.v4.runtime.tree.ErrorNode;

/**
 * Created by Jens on 15-6-2016.
 * This class is only used to check for parse errors.
 */
public class SimpleListener extends GuavaBaseListener {

    private boolean error;

    public SimpleListener() {
        this.error = false;
    }

    public boolean parseError() {
        return this.error;
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        this.error = true;
    }
}
