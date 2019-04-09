package nl.cyrildewit.pong.input.keysets;

import nl.cyrildewit.pong.Handler;

public abstract class KeySet {

	protected Handler handler;

	public int UP,
			  DOWN;

	public KeySet(Handler handler) {
		this.handler = handler;
	}

	public boolean up() {
		return handler.getKeyManager().keyStatus(UP);
	}

	public boolean down() {
		return handler.getKeyManager().keyStatus(DOWN);
	}

}
