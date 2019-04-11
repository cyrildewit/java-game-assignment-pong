package nl.cyrildewit.engine.entities.statics;

import nl.cyrildewit.engine.GameContainer;
import nl.cyrildewit.engine.entities.Entity;

public abstract class StaticEntry extends Entity {

	public StaticEntry(GameContainer gc, float x, float y, int width, int height) {
		super(gc, x, y, width, height);
	}

}
