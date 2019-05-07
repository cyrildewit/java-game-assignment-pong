package nl.cyrildewit.pong.entities.movables;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.entities.statics.Goal;
import nl.cyrildewit.pong.worlds.ClassicWorld;

public class Ball extends MovableEntity {

    private Random random;

    private int diameter;
    private Color backgroundColor;
    private Player lastHittedBy;

    public Ball(Handler handler, EntityID id, EntityType type, float x, float y, int diameter) {
        super(handler, id, type, x, y, diameter, diameter);

        random = new Random();

        this.x = x - (diameter / 2);
        this.y = y - (diameter / 2);
        this.diameter = diameter;
        this.backgroundColor = Color.WHITE;
        this.speed = 10;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;

        // xMove = -speed / 2;
        // yMove = -speed / 6;
        moveRandomly();
    }

    @Override
    public void update() {
        ClassicWorld world = (ClassicWorld) handler.getWorld();

        if(! world.isPlaying()) {
            active = false;
        }

        checkCollisionWithEntities();
        move();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRect((int) x, (int) y, (int) height, (int) width);
    }

    private void checkCollisionWithEntities()
    {
        EntityManager entityManager = (EntityManager) handler.getWorld().getEntityManager();

        for (Entity e : entityManager.getEntities()) {
            if (e.getType().equals(EntityType.Paddle)) {
                if (x - width <= e.getX() && x >= e.getX() - e.getWidth() &&
                    y <= e.getY() + e.getHeight() && y + getHeight() >= e.getY()
                ) {
                    // If the ball is moving to the left side, add the ball width to x coordinate.
                    // The ball will otherwise bug with the paddle.
                    x = xMove < 0 ? (e.getX() + width) : (e.getX() - width);

                    xMove *= -1;

                    if (e instanceof Player) {
                        lastHittedBy = (Player) e;
                    }
                }
            }

            if (e.getType().equals(EntityType.Wall)) {
                // Since we only have walls on the top and the bottom of the canvas, the ball
                // will only need to be reversed in yMove.
                // It will otherwise move in the same direction back.
                // TODO[EXTRA]: Calculate based on touch positon where the ball needs to go
                if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(0, 0))) {
                    yMove *= -1;
                }
            }

            if (e.getType().equals(EntityType.Goal)) {
                if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(0, 0))) {
                    System.out.println("Goal!!" + e.getID());
                    active = false;
                    xMove = 0;
                    yMove = 0;

                    if (e instanceof Goal) {
                        Goal goal = (Goal) e;
                        goal.getOpponent().addPoint();
                    }

                    respawn();
                    moveRandomly();
                    active = true;
                }
            }
        }
    }

    public void respawn() {
        x = (handler.getWidth() / 2) - width / 2;
        y = height + random.nextInt(handler.getHeight() - height);
    }

    public void moveRandomly() {
        // true => right, false => left
        boolean directionX = false;

        float minSpeed = 4f;
        float maxSpeed = 7f;

        directionX = xMove > 0 ? true : false;

        xMove = minSpeed + random.nextFloat() * (maxSpeed - minSpeed);
        yMove = minSpeed + random.nextFloat() * (maxSpeed - minSpeed);

        System.out.println("Speed: " + speed);
    }

    public void setXMove(float xMove)
    {
        this.xMove = xMove;
    }

    public void setYMove(float yMove) {
        this.yMove = yMove;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }
}
