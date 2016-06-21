package elaboration.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dion on 21-6-2016.
 */
public class GuavaVariableTable implements SymbolTable {
    private List<Map<String, Type>> table;
    private int deepestScope;

    public GuavaVariableTable() {
        this.table = new ArrayList<>();
        openScope();
        this.deepestScope = 0;
    }

    @Override
    public void openScope() {
        table.add(new HashMap<String, Type>());
        deepestScope++;
    }

    @Override
    public void closeScope() {
        if (deepestScope != 0) {
            table.remove(deepestScope);
            deepestScope--;
        } else {
            throw (new RuntimeException("Only contains outer scope"));
        }
    }

    @Override
    public boolean add(String id, Type type) {
        if (table.get(deepestScope).containsKey(id)) {
            return false;
        }

        table.get(deepestScope).put(id, type);
        return true;
    }

    @Override
    public boolean contains(String id) {
        for (int i = deepestScope; i >= 0; i--) {
            if (table.get(i).containsKey(id)) {
                return true;
            }
        }

        return false;
    }

    public Type getType(String id) {
        for (int i = deepestScope; i >= 0; i--) {
            if (table.get(i).containsKey(id)) {
                return table.get(i).get(id);
            }
        }

        return null;
    }
}
