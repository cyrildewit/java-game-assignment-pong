package nl.cyrildewit.pong.worlds;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.entities.movables.Ball;
import nl.cyrildewit.pong.entities.movables.Paddle;
import nl.cyrildewit.pong.entities.statics.Goal;
import nl.cyrildewit.pong.entities.statics.Net;
import nl.cyrildewit.pong.entities.statics.Wall;
import nl.cyrildewit.pong.input.keysets.KeySet;
import nl.cyrildewit.pong.input.keysets.PlayerOneKeySet;
import nl.cyrildewit.pong.input.keysets.PlayerTwoKeySet;

public class ClassicWorld extends World {

    // Entities
    private EntityManager entityManager;
    private Random random;

    private KeySet playerOneKeySet, playerTwoKeySet;

    public ClassicWorld(Handler handler) {
        super(handler);

        entityManager = new EntityManager(handler);
        random = new Random();

        playerOneKeySet = new PlayerOneKeySet(handler);
        playerTwoKeySet = new PlayerTwoKeySet(handler);

        initEntities();
    }

    public void update() {
        entityManager.tick();
    }

    public void render(Graphics g) {
        buildWorld(g);

        entityManager.render(g);
    }

    public void initEntities() {
        int centerX = handler.getWidth() / 2;
        int centerY = handler.getHeight() / 2;

        // Left Paddle
        entityManager.addEntity(new Paddle(handler, EntityType.Paddle, playerOneKeySet, 30, handler.getHeight() / 2));
        // Right Paddle
        entityManager.addEntity(new Paddle(handler, EntityType.Paddle, playerTwoKeySet, handler.getWidth() - 30, handler.getHeight() / 2));

        // Left Goal
        entityManager.addEntity(new Goal(handler, EntityType.Goal, 0, 0, 0, handler.getHeight()));
        // Right Goal
        entityManager.addEntity(new Goal(handler, EntityType.Goal, handler.getWidth(), 0, 5, handler.getHeight()));

        // Top Wall
        entityManager.addEntity(new Wall(handler, EntityType.Wall, 0, -1, handler.getWidth(), 1));
        // Top Wall
        entityManager.addEntity(new Wall(handler, EntityType.Wall, 0, handler.getHeight() + 1, handler.getWidth(), 1));

        // Net
        entityManager.addEntity(new Net(handler, EntityType.Net, centerX, 0, 6, handler.getHeight()));

        // Ball
        entityManager.addEntity(new Ball(handler, EntityType.Ball, centerX, centerY, 15));
        // entityManager.addEntity(new Ball(handler, EntityType.Ball, centerX, random.nextInt(centerY), 15));
    }

    public void buildWorld(Graphics g) {
        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0,  0,  handler.getWidth(), handler.getHeight());
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
