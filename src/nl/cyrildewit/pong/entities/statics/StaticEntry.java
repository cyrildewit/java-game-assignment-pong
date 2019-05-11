package nl.cyrildewit.pong.entities.statics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityType;

public abstract class StaticEntry extends Entity {

    public StaticEntry(Handler handler, EntityID id, EntityType type, float x, float y, int width, int height) {
        super(handler, id, type,  x, y, width, height);
    }

}
