package nl.cyrildewit.engine.entities;

import nl.cyrildewit.engine.GameContainer;

public abstract class StaticEntry extends Entity {

	public StaticEntry(GameContainer gc, float x, float y, int width, int height) {
		super(gc, x, y, width, height);
	}

}
