package nl.cyrildewit.engine.state;

import java.awt.Graphics;

import nl.cyrildewit.engine.GameContainer;

public abstract class State {

    protected GameContainer gc;

	private static State currentState = null;

    public State(GameContainer gc) {
		this.gc = gc;
	}

    public abstract void update();

    public abstract void render(Graphics g);

	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

}
