package nl.cyrildewit.pong.entities.creatures;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.ID;

public abstract class Creature extends Entity {

	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 16,
							DEFAULT_CREATURE_HEIGHT = 128;

	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, ID id, float x, float y, int width, int height) {
		super(handler, id, x, y, width, height);

		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		if (! checkEntityCollision(xMove, 0f)) {
			moveX();
		}

		if (! checkEntityCollision(yMove, 0f)) {
			moveY();
		}

	}

	public void moveX() {
		x += xMove;
	}

	public void moveY() {

		if (yMove < 0) { // Up
			if (y <= 0) {

			} else {
				y += yMove;
			}
		} else { // Down
			if (y >= handler.getHeight() - height) {

			} else {
				y += yMove;
			}
		}	
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
