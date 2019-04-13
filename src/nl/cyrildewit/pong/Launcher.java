package nl.cyrildewit.pong;

public class Launcher {

	public static void main(String[] args) {
        Game game = new Game("Pong Game!");
        game.setWidth(320 * 3);
        game.setHeight(240 * 3);
		game.start();
	}

}
