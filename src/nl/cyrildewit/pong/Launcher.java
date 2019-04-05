package nl.cyrildewit.pong;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("Pong Game!", 640, 480);
		game.start();
	}

}
