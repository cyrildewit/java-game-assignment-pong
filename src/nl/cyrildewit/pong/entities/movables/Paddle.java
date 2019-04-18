package nl.cyrildewit.pong.entities.movables;

import java.awt.Color;
import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.input.keysets.KeySet;

public class Paddle extends MovableEntity {

    public static final int DEFAULT_PADDLE_WIDTH = 14,
                            DEFAULT_PADDLE_HEIGHT = 80;

    protected KeySet inputKeySet;

    public Paddle(Handler handler, EntityType type, KeySet inputKeySet, float x, float y) {
        super(handler, type, x, y, DEFAULT_PADDLE_WIDTH, DEFAULT_PADDLE_HEIGHT);

        this.inputKeySet = inputKeySet;

        this.x = x - (width / 2);
        this.y = y - (height / 2);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;
    }

    @Override
    public void update() {
        handleKeyboardInput();
        checkWallCollision();
        move();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, width, height);
    }

    private void handleKeyboardInput() {
        yMove = 0;

        if (inputKeySet.up())
            yMove = -speed;
        if (inputKeySet.down())
            yMove = speed;
    }

    private void checkWallCollision() {
        EntityManager entityManager = (EntityManager) handler.getWorld().getEntityManager();

        for (Entity e : entityManager.getEntities()) {
            if (! e.getType().equals(EntityType.Wall)) {
                continue;
            }

            if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(0, yMove))) {
                yMove = 0;
            }
        }
    }

}
