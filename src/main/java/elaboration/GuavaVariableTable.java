package elaboration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dion on 21-6-2016.
 *
 */
public class GuavaVariableTable implements SymbolTable {
    private List<Map<String, Type>> table;
    private List<List<String>> assigned;
    private Map<String, Integer> offsets;
    private Map<String, Integer> globalOffsets;
    private int deepestScope;
    private int offset;
    private int globalOffset;

    public GuavaVariableTable() {
        this.table = new ArrayList<>();
        this.assigned = new ArrayList<>();
        this.offsets = new HashMap<>();
        this.globalOffsets = new HashMap<>();
        openScope();
        this.deepestScope = 0;
        this.offset = 1;
        this.globalOffset = 3;
    }

    @Override
    public void openScope() {
        table.add(new HashMap<String, Type>());
        assigned.add(new ArrayList<String>());
        deepestScope++;
    }

    @Override
    public void closeScope() {
        if (deepestScope != 0) {
            table.remove(deepestScope);
            assigned.remove(deepestScope);
            deepestScope--;
        } else {
            throw (new RuntimeException("Only contains outer scope"));
        }
    }

    @Override
    public boolean add(String id, Type type, boolean global) {
        if (contains(id)) {
            return false;
        }

        table.get(deepestScope).put(id, type);

        if (global) {
            globalOffsets.put(id, globalOffset);
            globalOffset += 2;
        } else {
            offsets.put(id, offset++);
        }

        return true;
    }

    public boolean addArray(String id, Type type, int size) {
        if (contains(id)) {
            return false;
        }

        table.get(deepestScope).put(id, type);
        offsets.put(id, offset);
        offset = offset + size;

        return true;
    }

    public boolean addLocal(String id, Type type) {
        if (contains(id)) {
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

    public void assign(String id) {
        if (!this.assigned.get(deepestScope).contains(id)) {
            this.assigned.get(deepestScope).add(id);
        }
    }

    public boolean isAssigned(String id) {
        for (int i = deepestScope; i >= 0; i--) {
            if (assigned.get(i).contains(id)) {
                return true;
            }
        }

        return false;
    }

    public Integer offset(String id) {
        return this.offsets.get(id);
    }

    public Integer globalOffset(String id) {
        return this.globalOffsets.get(id);
    }

    public void print() {
        for (String str : offsets.keySet()) {
            System.out.println(offsets.get(str));
        }
    }

}
