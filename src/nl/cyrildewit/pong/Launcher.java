package nl.cyrildewit.pong;

import nl.cyrildewit.engine.GameContainer;

public class Launcher {

	public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.setWidth(640);
        gc.setHeight(480);
        gc.setTitle("Pong Game!");
		gc.start();
	}

}
