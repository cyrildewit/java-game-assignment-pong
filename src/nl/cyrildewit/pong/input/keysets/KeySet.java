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
		return gc.getKeyManager().keyStatus(UP);
	}

	public boolean down() {
		return gc.getKeyManager().keyStatus(DOWN);
	}

}
