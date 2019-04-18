package nl.cyrildewit.pong.entities.movables;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.input.keysets.KeySet;

public class Player extends Paddle {

    protected int score = 0;

    public Player(Handler handler, EntityID id, EntityType type, KeySet inputKeySet, float x, float y) {
        super(handler, id, type, inputKeySet, x, y);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
