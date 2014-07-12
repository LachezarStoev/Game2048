package logic;

public class GameLogicTestMain {

	public static void printMatrix(int[][] matrix, int dimension) {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.print(Integer.toString(matrix[i][j]) + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.setRandomSlot();
		game.setRandomSlot();
		System.out.println("the board");
		printMatrix(game.getMatrix(), game.getDimension());

		System.out.println("Right");
		game.moveRight();
		printMatrix(game.getMatrix(), game.getDimension());

		System.out.println("Left");
		game.moveLeft();
		printMatrix(game.getMatrix(), game.getDimension());

		System.out.println("Up");
		game.moveUp();
		printMatrix(game.getMatrix(), game.getDimension());

		System.out.println("Down");
		game.moveDown();
		printMatrix(game.getMatrix(), game.getDimension());

	}

}
