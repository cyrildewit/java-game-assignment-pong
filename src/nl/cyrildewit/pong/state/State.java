package nl.cyrildewit.pong.state;

import java.awt.Graphics;

import nl.cyrildewit.engine.GameContainer;

public abstract class State {

    protected GameContainer gc;

	private static State currentState = null;

    public State(GameContainer gc) {
		this.gc = gc;
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
