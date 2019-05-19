package nl.cyrildewit.pong.entities.movables;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.entities.statics.Goal;
import nl.cyrildewit.pong.input.keysets.KeySet;

public class Player extends Paddle {

    protected int score = 0;
    protected int wins = 0, losts = 0;
    protected Goal goal;

    public Player(Handler handler, EntityID id, EntityType type, KeySet inputKeySet, float x, float y) {
        super(handler, id, type, inputKeySet, x, y);

        this.speed = 4.0f;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addPoint() {
        this.score++;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public int getWins() {
        return wins;
    }

    public void incrementWins() {
        wins++;
    }

    public void resetWins() {
        wins = 0;
    }

    public int getLosts() {
        return losts;
    }

    public void incrementLosts() {
        losts++;
    }

    public void resetLosts() {
        wins = 0;
    }
}
