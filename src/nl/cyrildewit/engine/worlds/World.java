package nl.cyrildewit.engine.worlds;

import nl.cyrildewit.engine.GameContainer;
import nl.cyrildewit.engine.Renderer;

public abstract class World {

	protected GameContainer gc;

	public World(GameContainer gc) {
		this.gc = gc;
	}

    public abstract void update();

    public abstract void render(Renderer r);

    public abstract Object getEntityManager();

	public GameContainer getHandler() {
		return gc;
	}

	public void setGameContainer(GameContainer gc) {
		this.gc = gc;
	}

}
