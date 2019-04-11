package nl.cyrildewit.pong.entities.statics;

import nl.cyrildewit.engine.GameContainer;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.ID;

public abstract class StaticEntry extends Entity {

	public StaticEntry(GameContainer gc, ID id, float x, float y, int width, int height) {
		super(gc, id,  x, y, width, height);
	}

}
