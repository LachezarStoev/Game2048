package View;

import java.io.IOException;

import jline.ConsoleReader;
import jline.Terminal;
import Controller.Controller;
import Controller.UserCommand;
import Model.Game;
import Model.GameState;
import Model.GameStatus;

public class ConsoleUI implements Visualization {

	private static final Terminal TERMINAL = jline.Terminal.setupTerminal();
	private ConsoleReader console;
	private Controller controller;
	private int commandType;
	private GameState currentState;
	
	public ConsoleUI() throws IOException {
		this.controller = new Controller();
		currentState = controller.onCommand(UserCommand.NEW.getNumber());
		console = new ConsoleReader();
	}

	@Override
	public void displayBoard() throws IOException {

		while (true) {
			this.printBoard();
			commandType = TERMINAL.readVirtualKey(System.in);
			currentState = controller.onCommand(commandType);
			if(currentState.getStatus() == GameStatus.WON) {
				this.displayWinMessage();
				break;
			} else if (currentState.getStatus() == GameStatus.LOST) {
				this.displayLoseMessage();
				break;
			}
			console.clearScreen();
		}
	}

	@Override
	public void displayLoseMessage() {
		System.out.println("You lost!");
	}

	@Override
	public void displayWinMessage() {
		System.out.println("You won!");
	}

	private void printBoard() {
		int[][] board = currentState.getBoard();
		for (int i = 0; i < Game.DIMENSION; i++) {
			for (int j = 0; j < Game.DIMENSION; j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
