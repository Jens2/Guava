package elaboration;

import java.util.List;

public class GuavaException extends Exception {
	private final List<String> messages;

	public GuavaException(List<String> messages) {
		super(messages.toString());
		this.messages = messages;
	}

	public List<String> getMessages() {
		return this.messages;
	}

	public void print() {
		for (String error : getMessages()) {
			System.out.println(error);
		}
	}
}