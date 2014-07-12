package logic;

public class GameLogicTestMain {

	public static void printMatrix(int[][] matrix) {
		int dimension = matrix.length;
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.print(Integer.toString(matrix[i][j]) + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		GameController gc = new GameController(game);
		
		game.setRandomSlot();
		game.setRandomSlot();
		game.setRandomSlot();
		game.setRandomSlot();
		game.setRandomSlot();
		game.setRandomSlot();
		game.setRandomSlot();
		System.out.println("the board");
		printMatrix(game.getMatrix());

		System.out.println("Right");
		gc.moveRight();
		printMatrix(game.getMatrix());

		System.out.println("Left");
		gc.moveLeft();
		printMatrix(game.getMatrix());

		System.out.println("Up");
		gc.moveUp();
		printMatrix(game.getMatrix());

		System.out.println("Down");
		gc.moveDown();
		printMatrix(game.getMatrix());

		System.out.println("Undo");
		gc.undoGame();
		printMatrix(game.getMatrix());

		System.out.println("Redo");
		gc.redoGame();
		printMatrix(game.getMatrix());
		

	}

}
