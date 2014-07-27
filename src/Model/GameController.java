package Model;

public class GameController {

	private Game game;
	private History history;
	private GameState state;

	public GameController() {
		this.game = new Game();
		this.history = new History();
		state = new GameState(game.getMatrix(), GameStatus.PLAYING);
	}

	public void moveDown() {
		game.moveDown();
		onMoved();
	}

	public void moveRight() {
		game.moveRight();
		onMoved();
	}

	public void moveUp() {
		game.moveUp();
		onMoved();
	}

	public void moveLeft() {
		game.moveLeft();
		onMoved();
	}

	private void onMoved() {
		game.setRandomSlot();
		updateGameState();
		saveOnMovedGame();
	}

	public void saveOnMovedGame() {
		int[][] currentState = this.game.getMatrix();

		int[][] saveState = new int[Game.DIMENSION][Game.DIMENSION];
		for (int i = 0; i < Game.DIMENSION; i++) {
			for (int j = 0; j < Game.DIMENSION; j++) {
				saveState[i][j] = currentState[i][j];
			}
		}
		this.history.saveOnMoved(saveState);
	}

	public void saveGame() {
		this.history.save(game.getMatrix());
	}

	public void loadGame() {
		this.game.setMatrix(this.history.load());
		updateGameState();
	}

	public void newGame() {
		game = new Game();
		history = new History();
		updateGameState();
	}
	public void undoGame() {
		int[][] oldState = this.history.undo();
		this.game.setMatrix(oldState);
		updateGameState();
	}

	public void redoGame() {
		int[][] newState = this.history.redo();
		this.game.setMatrix(newState);
		updateGameState();
	}

	public GameState getGameState() {
		return state;
	}

	public void updateGameState() {
		state.setBoard(game.getMatrix());

		if(hasWon()) {
			state.setStatus(GameStatus.WON);
		} else if(hasLost()) {
			state.setStatus(GameStatus.LOST);
		} else {
			state.setStatus(GameStatus.PLAYING);
		}
	}

	public boolean hasWon() {
		return game.hasWon();
	}

	public boolean hasLost() {
		return game.hasLost();
	}

}
