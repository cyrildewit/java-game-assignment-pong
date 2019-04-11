package nl.cyrildewit.engine.worlds;

import java.awt.Graphics;

import nl.cyrildewit.engine.GameContainer;

public abstract class World {

	protected GameContainer gc;

	public World(GameContainer gc) {
		this.gc = gc;
	}

    public abstract void update();

    public abstract void render(Graphics g);

    public abstract Object getEntityManager();

	public GameContainer getHandler() {
		return gc;
	}

	public void setGameContainer(GameContainer gc) {
		this.gc = gc;
	}

}
