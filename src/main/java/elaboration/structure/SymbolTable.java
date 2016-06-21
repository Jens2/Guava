package elaboration.structure;

public interface SymbolTable {
	public abstract void openScope();

	public abstract void closeScope();

	public abstract boolean add(String id, Type type);

	public abstract boolean contains(String id);
}
