package nl.cyrildewit.pong.worlds;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

public class TestWorld extends World {

    // Entities
    private EntityManager entityManager;
    private Random random;

    private KeySet playerOneKeySet, playerTwoKeySet;

    public TestWorld(Handler handler) {
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
        // Testcase #1
        entityManager.addEntity(new Paddle(handler, EntityType.Paddle, playerTwoKeySet, 100, 100));
        entityManager.addEntity(new Paddle(handler, EntityType.Paddle, playerTwoKeySet, 400, 100));
        Ball ballOne = new Ball(handler, EntityType.Ball, 300, 100, 15);
        ballOne.setXMove(-5);
        ballOne.setYMove(0);
        entityManager.addEntity(ballOne);

        // Testcase #2
        entityManager.addEntity(new Paddle(handler, EntityType.Paddle, playerTwoKeySet, 100, 300));
        entityManager.addEntity(new Paddle(handler, EntityType.Paddle, playerTwoKeySet, 100, 600));
        Ball ballTwo = new Ball(handler, EntityType.Ball, 100, 500, 15);
        ballTwo.setXMove(0);
        ballTwo.setYMove(-5);
        entityManager.addEntity(ballTwo);

        // Testcase #3
        entityManager.addEntity(new Paddle(handler, EntityType.Paddle, playerTwoKeySet, 300, 400));
        Ball ballThree = new Ball(handler, EntityType.Ball, 200, 350, 15);
        ballThree.setXMove(5);
        ballThree.setYMove(2);
        entityManager.addEntity(ballThree);

        // Testcase #4
        entityManager.addEntity(new Paddle(handler, EntityType.Paddle, playerTwoKeySet, 100, 150));
        entityManager.addEntity(new Paddle(handler, EntityType.Paddle, playerTwoKeySet, 600, 600));
        Ball ballFour = new Ball(handler, EntityType.Ball, 400, 400, 15);
        ballFour.setXMove(5);
        ballFour.setYMove(4);
        entityManager.addEntity(ballFour);
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
