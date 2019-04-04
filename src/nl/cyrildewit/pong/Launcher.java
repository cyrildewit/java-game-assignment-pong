package nl.cyrildewit.pong;

import nl.cyrildewit.pong.display.Display;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("Pong!", 640, 480);
		game.start();
	}

}
