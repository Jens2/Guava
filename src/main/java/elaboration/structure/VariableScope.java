package elaboration.structure;

import java.util.LinkedHashMap;
import java.util.Map;

public class VariableScope {
	private final Map<String, Type> types;

	public VariableScope() {
		this.types = new LinkedHashMap<>();
	}

	public boolean contains(String id) {
		return this.types.containsKey(id);
	}

	public boolean put(String id, Type type) {
		boolean result = !this.types.containsKey(id);
		if (result) {
			this.types.put(id, type);
		}
		return result;
	}

	public Type type(String id) {
		return this.types.get(id);
	}

}