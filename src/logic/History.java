package logic;

import java.util.Stack;

public class History {

	private Stack<int[][]> undoStack = new Stack<int[][]>();
	private Stack<int[][]> redoStack = new Stack<int[][]>();
	
	public History() {
	}
	
	public void save (int[][] matrix) {
		undoStack.push(matrix);
	}

	public int[][] undo() {
		int[][] previousState = undoStack.pop();
		redoStack.push(previousState);
		return undoStack.peek();
	}

	public int[][] redo() {
		int[][] returnedMatrix =  redoStack.pop();
		undoStack.push(returnedMatrix);
		return returnedMatrix;
	}
}
