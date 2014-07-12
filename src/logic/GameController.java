package logic;

public class GameController {

	public void moveDown() {
		game.moveDown();
		onMoved();
	}

	public GameResult moveRight() {
		GameResult moveRight = game.moveRight();
		onMoved();
		return moveRight;
	}

	public void moveUp() {
		game.moveUp();
		onMoved();
	}

	private void onMoved() {
		saveGame();
	}

	public void moveLeft() {
		game.moveLeft();
		onMoved();
	}

	private Game game;
	private History history;

	public GameController(Game game) {
		this.game = game;
		this.history = new History();
	}

	void saveGame() {
		int[][] currentState = this.game.getMatrix();
		int dimension = currentState.length;

		int[][] saveState = new int[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				saveState[i][j] = currentState[i][j];
			}
		}
		this.history.save(saveState);
	}

	public void undoGame() {
		int[][] oldState = this.history.undo();
		this.game.setMatrix(oldState);
	}

	public void redoGame() {
		int[][] newState = this.history.redo();
		this.game.setMatrix(newState);
	}

}
