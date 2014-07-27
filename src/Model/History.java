package Model;

import java.util.Stack;


public class History {

	private Stack<int[][]> undoStack;
	private Stack<int[][]> redoStack;
	
	public History() {
		undoStack = new Stack<int[][]>();
		redoStack = new Stack<int[][]>();
	}
	
	public void saveOnMoved(int[][] matrix) {
		undoStack.push(matrix);
	}

	public void save(int[][] state) {
		// TODO: save the state of the game into a file.
	}

	public int[][] load() {
		// TODO: load the game into the file.
		return null;
	}

	public int[][] undo() {
		int[][] previousState = undoStack.pop();
		redoStack.push(previousState);
		return previousState;
	}

	public int[][] redo() {
		int[][] returnedMatrix =  redoStack.pop();
		undoStack.push(returnedMatrix);
		return returnedMatrix;
	}
}
