package nl.cyrildewit.engine.state;

import nl.cyrildewit.engine.GameContainer;
import nl.cyrildewit.engine.Renderer;

public abstract class State {

    protected GameContainer gc;

	private static State currentState = null;

    public State(GameContainer gc) {
		this.gc = gc;
	}

    public abstract void update();

    public abstract void render(Renderer r);

	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

}
