package nl.cyrildewit.pong.entities.statics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.Entity;

public abstract class StaticEntry extends Entity {

	public StaticEntry(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
