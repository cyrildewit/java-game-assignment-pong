package nl.cyrildewit.pong.entities.movables;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityType;

public abstract class MovableEntity extends Entity {

    public static final float DEFAULT_SPEED = 5.0f;

    protected float speed;
    protected float xMove, yMove;

    public MovableEntity(Handler handler, EntityID id, EntityType type, float x, float y, int width, int height) {
        super(handler, id, type, x, y, width, height);

        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    /**
     * Handle the movement of the movable entity.
     *
     */
    public void move() {
        moveX();
        moveY();
    }

    /**
     * Handle the x-axis movement.
     */
    public void moveX() {
        x += xMove;
    }

    /**
     * Handle the y-axis movement.
     */
    public void moveY() {
        y += yMove;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getXMove() {
        return xMove;
    }

    public void setXMove(float xMove) {
        this.xMove = xMove;
    }

    public float getYMove() {
        return yMove;
    }

    public void setYMove(float yMove) {
        this.yMove = yMove;
    }

}
