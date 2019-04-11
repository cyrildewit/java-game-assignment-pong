package nl.cyrildewit.pong.input.keysets;

import java.awt.event.KeyEvent;

import nl.cyrildewit.engine.GameContainer;

public class PlayerTwoKeySet extends KeySet {

	public PlayerTwoKeySet(GameContainer gc) {
		super(gc);
		
		UP = KeyEvent.VK_UP;
		DOWN = KeyEvent.VK_DOWN;
	}

}
