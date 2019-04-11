package nl.cyrildewit.pong.worlds;

import nl.cyrildewit.engine.GameContainer;

public abstract class World {

	protected GameContainer gc;

	public World(GameContainer gc) {
		this.gc = gc;
	}

	public abstract Object getEntityManager();

	public GameContainer getHandler() {
		return gc;
	}

	public void setGameContainer(GameContainer gc) {
		this.gc = gc;
	}

}
