package nl.cyrildewit.pong.worlds;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.entities.movables.Ball;
import nl.cyrildewit.pong.entities.movables.Player;
import nl.cyrildewit.pong.entities.statics.Goal;
import nl.cyrildewit.pong.entities.statics.Net;
import nl.cyrildewit.pong.entities.statics.PlayerScore;
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

    private void initEntities() {
        int centerX = handler.getWidth() / 2;
        int centerY = handler.getHeight() / 2;

        // Left Goal
        Goal leftGoal = new Goal(
            handler,
            EntityID.PlayerOneGoal,
            EntityType.Goal,
            0, 0,
            1, handler.getHeight()
        );
        entityManager.addEntity(leftGoal);

        // Right Goal
        Goal rightGoal = new Goal(
            handler,
            EntityID.PlayerTwoGoal,
            EntityType.Goal,
            handler.getWidth(), 1,
            5, handler.getHeight()
        );
        entityManager.addEntity(rightGoal);

        // Left Player
        Player leftPlayer = new Player(
            handler,
            EntityID.PlayerOnePaddle,
            EntityType.Paddle,
            playerOneKeySet,
            40,
            centerY
        );
        leftPlayer.setGoal(leftGoal);
        entityManager.addEntity(leftPlayer);
        leftGoal.setPlayer(leftPlayer);

        // Right Paddle
        Player rightPlayer = new Player(
            handler,
            EntityID.PlayerTwoPaddle,
            EntityType.Paddle,
            playerTwoKeySet,
            handler.getWidth() - 40,
            handler.getHeight() / 2
        );
        entityManager.addEntity(rightPlayer);
        rightGoal.setPlayer(rightPlayer);

        // Top Wall
        entityManager.addEntity(new Wall(
            handler,
            EntityID.TopWall,
            EntityType.Wall,
            0, -1,
            handler.getWidth(), 1
        ));

        // Top Wall
        entityManager.addEntity(new Wall(
            handler,
            EntityID.BottomWall,
            EntityType.Wall,
            0, handler.getHeight() + 1,
            handler.getWidth(), 1
        ));

        // Net
        entityManager.addEntity(new Net(
            handler,
            EntityID.Net,
            EntityType.Net,
            centerX, 0,
            6, handler.getHeight())
        );

        // Ball
        entityManager.addEntity(new Ball(
            handler,
            EntityID.Ball,
            EntityType.Ball,
            centerX, centerY, 12
        ));

        // Left Player Score
        PlayerScore leftPlayerScore = new PlayerScore(
            handler,
            EntityID.PlayerOneScore,
            EntityType.Score,
            centerX / 2, 100
        );
        leftPlayerScore.setPlayer(leftPlayer);
        entityManager.addEntity(leftPlayerScore);

        // Left Player Score
        PlayerScore rightPlayerScore = new PlayerScore(
            handler,
            EntityID.PlayerTwoScore,
            EntityType.Score,
            centerX + (centerX / 2), 100
        );
        rightPlayerScore.setPlayer(rightPlayer);
        entityManager.addEntity(rightPlayerScore);
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
