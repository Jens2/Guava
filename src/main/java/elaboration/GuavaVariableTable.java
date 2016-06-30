package elaboration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        this.globalOffset = 0;
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

    @Override
    public boolean contains(String id) {
        for (int i = deepestScope; i >= 0; i--) {
            if (table.get(i).containsKey(id)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Adds an array to the deepest scope
     * @param id name of the array
     * @param type type of the array
     * @param size size of array (number of elements)
     * @return <tt>false</tt> if the array is already defined in the table
     */
    public boolean addArray(String id, Type type, int size) {
        if (contains(id)) {
            return false;
        }

        table.get(deepestScope).put(id, type);
        offsets.put(id, offset);
        offset = offset + size;

        return true;
    }

    /**
     * Adds a nested variable to the deepest scope. Nested variables will not be assigned an offset
     * @param id name of the variable
     * @param type type of the variable
     * @return <tt>false</tt> if the variable is already defined in the table
     */
    public boolean addNested(String id, Type type) {
        if (contains(id)) {
            return false;
        }

        table.get(deepestScope).put(id, type);
        return true;
    }

    /**
     * Returns the type of the given variable
     * @param id the name of the variable for which the type is requested
     * @return the type of the given variable
     */
    public Type getType(String id) {
        for (int i = deepestScope; i >= 0; i--) {
            if (table.get(i).containsKey(id)) {
                return table.get(i).get(id);
            }
        }

        return null;
    }

    /**
     * Indicate that a variable has been assigned a value
     * @param id the name of the variable
     */
    public void assign(String id) {
        if (!this.assigned.get(deepestScope).contains(id)) {
            this.assigned.get(deepestScope).add(id);
        }
    }

    /**
     * Returns whether a variable is already assigned a value or not
     * @param id the name of the variable
     * @return <tt>true</tt> if the variable is already assigned a value in any of the scopes
     */
    public boolean isAssigned(String id) {
        for (int i = deepestScope; i >= 0; i--) {
            if (assigned.get(i).contains(id)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the offset of the given variable
     * @param id the name of the variable
     * @return the offset of the given variable
     */
    public Integer offset(String id) {
        return this.offsets.get(id);
    }

    /**
     * Returns the offset of the given global variable
     * @param id the name of the global variable
     * @return the offset of the given global variable
     */
    public Integer globalOffset(String id) {
        return this.globalOffsets.get(id);
    }

}
