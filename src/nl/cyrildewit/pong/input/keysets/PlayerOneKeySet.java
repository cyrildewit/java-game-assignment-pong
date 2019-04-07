package nl.cyrildewit.pong.input.keysets;

import java.awt.event.KeyEvent;

import nl.cyrildewit.pong.Handler;

public class PlayerOneKeySet extends KeySet {

	public PlayerOneKeySet(Handler handler) {
		super(handler);
		
		UP = KeyEvent.VK_W;
		DOWN = KeyEvent.VK_S;
	}

}
