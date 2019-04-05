package nl.cyrildewit.pong.state;

import java.awt.Graphics;

import nl.cyrildewit.pong.Game;

public abstract class State {

    protected Game game;

	private static State currentState = null;

    public State(Game game) {
		this.game = game;
	}

    public abstract void tick();

	public abstract void render(Graphics g);

	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

}
