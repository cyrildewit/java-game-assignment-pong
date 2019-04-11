package nl.cyrildewit.pong.input.keysets;

import java.awt.event.KeyEvent;

import nl.cyrildewit.engine.GameContainer;

public class PlayerOneKeySet extends KeySet {

	public PlayerOneKeySet(GameContainer gc) {
		super(gc);
		
		UP = KeyEvent.VK_W;
		DOWN = KeyEvent.VK_S;
	}

}
