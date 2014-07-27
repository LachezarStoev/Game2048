package Controller;

public enum UserCommand {
	UP(16), DOWN(14), RIGHT(6), LEFT(2), SAVE(115), UNDO(117), REDO(114), QUIT(
			113), LOAD(108), NEW(
			110);

	private UserCommand(int keyNumber) {
		this.keyNumber = keyNumber;
	}

	private final int keyNumber;

	public int getNumber() {
		return keyNumber;
	}

}
