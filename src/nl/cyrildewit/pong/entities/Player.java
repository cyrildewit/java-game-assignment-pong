package nl.cyrildewit.pong.entities.movables;

import java.awt.Color;
import java.awt.Graphics;

import nl.cyrildewit.engine.GameContainer;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.ID;
import nl.cyrildewit.pong.input.keysets.KeySet;

public class Player extends MovableEntity {

    public static final int DEFAULT_PLAYER_WIDTH = 16,
                            DEFAULT_PLAYER_HEIGHT = 128;

    protected KeySet inputKeySet;

	public Player(GameContainer gc, ID id, KeySet inputKeySet, float x, float y) {
		super(gc, id, x, y, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);

		this.inputKeySet = inputKeySet;

        bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;
	}

	@Override
	public void tick() {
        getInput();
        move();
        checkBallCollision();
	}

	@Override
	public void render(Graphics g) {
        // White racket
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, width, height);
    }

    private void getInput() {
		// xMove = 0;
		yMove = 0;

		if (inputKeySet.up()) yMove = -speed;
		if (inputKeySet.down()) yMove = speed;
	}
    
    public void checkBallCollision() {
    	EntityManager entityManager = (EntityManager) gc.getWorld().getEntityManager();

        for(Entity e : entityManager.getEntities()) {
        	// If the current entity isn't an instance of the Ball class, continue
            if(! e.getId().equals(ID.Ball)) {
                continue;
            }

            // Check if the entity is touching the bounds of this goal
			if(e.getCollisionBounds(0, 0).intersects(getCollisionBounds(0, 0))) {
				Ball ball = (Ball) e;
				ball.setXMove(-1 * ball.getXMove());
				ball.setYMove(-1 * ball.getYMove());
			}
		}
    }

}
