package elaboration;

public interface SymbolTable {
    /**
     * Opens a new scope
     */
	void openScope();

    /**
     * Closes the deepest scope
     */
	void closeScope();

    /**
     * Adds a variable to the deepest scope
     * @param id the name of the variable
     * @param type the type of the variable
     * @param global whether the variable is defined as global or not
     * @return <tt>false</tt> if the variable was already declared in the current scope
     */
	boolean add(String id, Type type, boolean global);

    /**
     * Checks whether the given variable is already in any of the scopes
     * @param id the name of the variable
     * @return <tt>true</tt> if the given variable is already in the table
     */
	boolean contains(String id);
}
