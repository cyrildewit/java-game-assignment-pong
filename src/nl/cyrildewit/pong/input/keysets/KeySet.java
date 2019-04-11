package nl.cyrildewit.pong.input.keysets;

import nl.cyrildewit.engine.GameContainer;

public abstract class KeySet {

	protected GameContainer gc;

	public int UP,
			  DOWN;

	public KeySet(GameContainer gc) {
		this.gc = gc;
	}

	public boolean up() {
		return gc.getInput().isKey(UP);
	}

	public boolean down() {
		return gc.getInput().isKey(DOWN);
	}

}
