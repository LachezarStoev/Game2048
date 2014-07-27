package Model;

public class GameState {

	private GameStatus status;
	private int[][] board;

	public GameState(int[][] board, GameStatus status) {
		this.status = status;
		this.board = board;
	}

	public GameStatus getStatus() {
		return status;
	}
	public void setStatus(GameStatus status) {
		this.status = status;
	}
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}
}
