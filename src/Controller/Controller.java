package Controller;

import Model.GameController;
import Model.GameState;

public class Controller {

	private GameController gameController;

	public Controller() {
		this.gameController = new GameController();
	}
	
	public GameState onCommand(int command) {

		if (command == UserCommand.QUIT.getNumber()) {
			System.exit(0);
		} else if (command == UserCommand.SAVE.getNumber()) {
			gameController.saveGame();
		} else if (command == UserCommand.LOAD.getNumber()) {
			gameController.loadGame();
		} else if(command == UserCommand.NEW.getNumber()) {
			gameController.newGame();
		} else if(command == UserCommand.REDO.getNumber()) {
			gameController.redoGame();
		} else if (command == UserCommand.UNDO.getNumber()) {
			gameController.undoGame();
		} else if (command == UserCommand.LEFT.getNumber()) {
			gameController.moveLeft();
		} else if(command == UserCommand.UP.getNumber()) {
			gameController.moveUp();
		} else if (command == UserCommand.RIGHT.getNumber()) {
			gameController.moveRight();
		} else if (command == UserCommand.DOWN.getNumber()) {
			gameController.moveDown();
		}
		return gameController.getGameState();
	}

}
