package nl.cyrildewit.pong.entities.movables;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.EntityType;

public class Ball extends MovableEntity {

    private int diameter;
    private Random random;

    public Ball(Handler handler, EntityType type, float x, float y, int diameter) {
        super(handler, type, x, y, diameter, diameter);

        random = new Random();

        this.x = x - (diameter / 2);
        this.y = y - (diameter / 2);
        this.diameter = diameter;
        this.speed = 10;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;

        xMove = -speed / 2;
        yMove = -speed / 6;
        // yMove = 0;
    }

    @Override
    public void update() {
        checkPaddleCollision();
        checkWallCollision();
        checkGoalCollision();
        move();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval((int) x, (int) y, (int) height, (int) width);

        // g.setColor(Color.GREEN);
        // g.fillRect((int) getCollisionBounds(0, 0).x, (int) getCollisionBounds(0, 0).y, (int) getCollisionBounds(0, 0).height, (int) getCollisionBounds(0, 0).width);

        // g.setColor(Color.PINK);
        // g.drawRect((int) getCollisionBounds(tempXMove, tempYMove).x, (int) getCollisionBounds(tempXMove, tempYMove).y,
        //         (int) getCollisionBounds(tempXMove, tempYMove).height, (int) getCollisionBounds(tempXMove, tempYMove).width);
    }

    private void checkPaddleCollision() {
        EntityManager entityManager = (EntityManager) handler.getWorld().getEntityManager();

        for (Entity e : entityManager.getEntities()) {
            if (! e.getType().equals(EntityType.Paddle)) {
                continue;
            }

            if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(0, 0))) {
                xMove *= -1;
                yMove *= -1;

                // moveRandomly();
            }
        }
    }

    private void checkWallCollision() {
        EntityManager entityManager = (EntityManager) handler.getWorld().getEntityManager();

        for (Entity e : entityManager.getEntities()) {
            if (!e.getType().equals(EntityType.Wall)) {
                continue;
            }

            // Since we only have walls on the top and the bottom of the canvas, the ball will only need to be reversed in yMove.
            // It will otherwise move in the same direction back.
            // TODO[EXTRA]: Calculate based on touch positon where the ball needs to go
            if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(0, 0))) {
                yMove *= -1;
            }
        }
    }

    private void checkGoalCollision() {
        EntityManager entityManager = (EntityManager) handler.getWorld().getEntityManager();

        for (Entity e : entityManager.getEntities()) {
            if (!e.getType().equals(EntityType.Goal)) {
                continue;
            }

            if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(0, 0))) {
                System.out.println("Goal!!");
            }
        }
    }

    public void moveRandomly() {
        int directionX = 0;
        int directionY = 0;

        float minSpeed = speed / 2;
        float maxSpeed = speed * 2;

        if (xMove > 0) directionX = 1;
        if (yMove > 0) directionY = 1;

        xMove = minSpeed + random.nextFloat() * (maxSpeed - minSpeed);
        yMove = minSpeed + random.nextFloat() * (maxSpeed - minSpeed);
        //
    }

    public void setXMove(float xMove)
    {
        this.xMove = xMove;
    }

    public void setYMove(float yMove) {
        this.yMove = yMove;
    }
}
