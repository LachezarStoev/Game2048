package View;

import java.io.IOException;

public interface Visualization {

	void displayBoard() throws IOException;

	void displayLoseMessage();

	void displayWinMessage();

}
