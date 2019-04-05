package nl.cyrildewit.pong.entities.statics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.ID;

public abstract class StaticEntry extends Entity {

	public StaticEntry(Handler handler, ID id, float x, float y, int width, int height) {
		super(handler, id,  x, y, width, height);
	}

}
