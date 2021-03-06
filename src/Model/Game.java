package Model;

import java.util.Random;

public class Game {

	public static final int DIMENSION = 4;
	private int[][] matrix;

	public Game() {
		this.matrix = new int[DIMENSION][DIMENSION];
		matrixSetup();
	}

	private void matrixSetup() {
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				this.matrix[i][j] = 0;
			}
		}
		// Every game starts with 2 numbers.
		setRandomSlot();
		setRandomSlot();
	}

	public int getDimension() {
		return DIMENSION;
	}

	public int[][] getMatrix() {
		return this.matrix;
	}

	public void setMatrix(int[][] newMatrix) {
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				this.matrix[i][j] = newMatrix[i][j];
			}
		}
	}

	public void rotateMatrixRight() {
		int[][] rotatedMatrix = new int[DIMENSION][DIMENSION];

		for (int i = 0; i < DIMENSION; ++i) {
			for (int j = 0; j < DIMENSION; ++j) {
				rotatedMatrix[i][j] = this.matrix[DIMENSION - j - 1][i];
			}
		}

		for (int i = 0; i < DIMENSION; ++i) {
			for (int j = 0; j < DIMENSION; ++j) {
				this.matrix[i][j] = rotatedMatrix[i][j];
			}
		}
	}

	// This is the main logic for updating the matrix after a move.
	public void moveRight() {
		for (int row = 0; row < DIMENSION; row++) {
			moveRowRightmost(row);

			int mergeLimitPosition = DIMENSION - 1;
			int currentColumn = mergeLimitPosition - 1;
			for (int col = currentColumn; col >= 0; col--) {
				if (this.matrix[row][col] == this.matrix[row][col + 1]) {
					if (col < mergeLimitPosition) {
						this.matrix[row][col + 1] = this.matrix[row][col] * 2;
						this.matrix[row][col] = 0;
						moveRowRightmost(row);
						mergeLimitPosition--;
						col++;
					}
				}
			}
		}
	}

	private void moveRowRightmost(int row) {
		int moveLimit = DIMENSION - 1;
		for (int col = moveLimit - 1; col >= 0; col--) {
			moveCellRightmost(row, col);
		}
	}

	private void moveCellRightmost(int row, int col) {
		int currentCellValue = this.matrix[row][col];
		if (col == DIMENSION - 1) {
			return;
		}
		int emptyCount = 0;
		for (int column = col + 1; column < DIMENSION; column++) {
			if (this.matrix[row][column] == 0) {
				emptyCount++;
			}
		}
		this.matrix[row][col] = 0;
		this.matrix[row][col + emptyCount] = currentCellValue;
	}

	public void moveUp() {
		this.rotateMatrixRight();
		moveRight();
		this.rotateMatrixRight();
		this.rotateMatrixRight();
		this.rotateMatrixRight();
	}

	public void moveDown() {
		this.rotateMatrixRight();
		this.rotateMatrixRight();
		this.rotateMatrixRight();
		moveRight();
		this.rotateMatrixRight();
	}

	public void moveLeft() {
		this.rotateMatrixRight();
		this.rotateMatrixRight();
		moveRight();
		this.rotateMatrixRight();
		this.rotateMatrixRight();
	}

	public static int generateNumber() {
		int n;
		Random rand = new Random();
		n = rand.nextInt(10);
		if (n >= 1) {
			return 2;
		} else {
			return 4;
		}
	}

	private int findEmptySlots() {
		int emptyCount = 0;
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (this.matrix[i][j] == 0) {
					emptyCount++;
				}
			}
		}
		return emptyCount;
	}

	public void setRandomSlot() {
		int emptyCount = this.findEmptySlots();
		if (emptyCount == 0) {
			return;
		}
		Random rand = new Random();
		int n = rand.nextInt(emptyCount) + 1;

		emptyCount = 0;
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (this.matrix[i][j] == 0) {
					emptyCount++;
					if (n == emptyCount) {
						this.matrix[i][j] = generateNumber();
						break;
					}
				}
			}
		}
	}

	public boolean hasWon() {
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				if (this.matrix[i][j] == 2048) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasLost() {
		if (this.findEmptySlots() > 0) {
			return false;
		} else {
			for (int x = 0; x < DIMENSION; x++) {
				for (int y = 0; y < DIMENSION - 1; y++) {
					if (matrix[x][y] == matrix[x][y + 1]) {
						return false;
					}
				}
			}
			for (int y = 0; y < DIMENSION; y++) {
				for (int x = 0; x < DIMENSION - 1; x++) {
					if (matrix[x][y] == matrix[x + 1][y]) {
						return false;
					}
				}
			}
		}
		return true;

	}

}
