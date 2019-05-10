package nl.cyrildewit.pong.worlds;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.entities.movables.Ball;
import nl.cyrildewit.pong.entities.movables.Player;
import nl.cyrildewit.pong.entities.statics.GoToNextLevel;
import nl.cyrildewit.pong.entities.statics.Goal;
import nl.cyrildewit.pong.entities.statics.Net;
import nl.cyrildewit.pong.entities.statics.PlayerScore;
import nl.cyrildewit.pong.entities.statics.Wall;
import nl.cyrildewit.pong.entities.statics.YouWon;
import nl.cyrildewit.pong.input.keysets.KeySet;
import nl.cyrildewit.pong.input.keysets.PlayerOneKeySet;
import nl.cyrildewit.pong.input.keysets.PlayerTwoKeySet;

public class ClassicWorld extends World {

	private EntityManager entityManager;
    private Random random;
    private KeySet playerOneKeySet, playerTwoKeySet;

    private int centerX = handler.getWidth() / 2;
    private int centerY = handler.getHeight() / 2;

    private final int MAXIMUM_SCORE = 1;
    private final int START_LEVEL = 1;

    private boolean isPlaying = true, isPaused = false;
    private int currentLevel = 1;
    private EntityID lastWinner = null, lastLoser = null;

    Player leftPlayer, rightPlayer;
    Ball ball;
    YouWon youWon;
    GoToNextLevel nextLevel;

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

        if (leftPlayer != null && rightPlayer != null) {
            if (leftPlayer.getScore() >= MAXIMUM_SCORE || rightPlayer.getScore() >= MAXIMUM_SCORE) {
                isPlaying = false;

                if (leftPlayer.getScore() > rightPlayer.getScore()) {
                    lastWinner = leftPlayer.getID();
                    lastLoser = rightPlayer.getID();
                } else {
                    lastWinner = rightPlayer.getID();
                    lastLoser = leftPlayer.getID();
                }

                ball.setActive(false);
            }
        }

        if (! isPlaying && ! isPaused && lastWinner != null && lastLoser != null) {
            if (lastWinner == EntityID.PlayerOnePaddle) {
                youWon.setPosition((centerX / 2) - youWon.getStringWidth() / 2, centerY);
                youWon.setActive(true);
            }

            if (lastWinner == EntityID.PlayerTwoPaddle) {
                youWon.setPosition(centerX + (centerX / 2) - youWon.getStringWidth() / 2, centerY);
                youWon.setActive(true);
            }
        }

        if (! isPlaying && handler.getInput().isKey(KeyEvent.VK_SPACE)) {
            isPlaying = true;
            leftPlayer.setScore(0);
            rightPlayer.setScore(0);
            youWon.setActive(false);
            ball.setActive(true);
            ball.respawn();
            incrementLevel();
        }
    }

    public void render(Graphics g) {
        buildWorld(g);

        entityManager.render(g);
    }

    private void initEntities() {
        Goal leftGoal = new Goal(
            handler,
            EntityID.PlayerOneGoal,
            EntityType.Goal,
            0, 0,
            1, handler.getHeight()
        );

        Goal rightGoal = new Goal(
            handler,
            EntityID.PlayerTwoGoal,
            EntityType.Goal,
            handler.getWidth(), 1,
            5, handler.getHeight()
        );

        leftPlayer = new Player(
            handler,
            EntityID.PlayerOnePaddle,
            EntityType.Paddle,
            playerOneKeySet,
            40,
            centerY
        );

        rightPlayer = new Player(
            handler,
            EntityID.PlayerTwoPaddle,
            EntityType.Paddle,
            playerTwoKeySet,
            handler.getWidth() - 40,
            handler.getHeight() / 2
        );

        Wall topWall = new Wall(
            handler,
            EntityID.TopWall,
            EntityType.Wall,
            0, -1,
            handler.getWidth(), 1
        );

        Wall bottomWall = new Wall(
            handler,
            EntityID.BottomWall,
            EntityType.Wall,
            0, handler.getHeight() + 1,
            handler.getWidth(), 1
        );

        Net net = new Net(
            handler,
            EntityID.Net,
            EntityType.Net,
            centerX, 0,
            6, handler.getHeight()
        );

        ball = new Ball(
            handler,
            EntityID.Ball,
            EntityType.Ball,
            centerX, centerY, 12
        );

        PlayerScore leftPlayerScore = new PlayerScore(
            handler,
            EntityID.PlayerOneScore,
            EntityType.Score,
            centerX / 2, 100
        );

        PlayerScore rightPlayerScore = new PlayerScore(
            handler,
            EntityID.PlayerTwoScore,
            EntityType.Score,
            centerX + (centerX / 2), 100
        );

        youWon = new YouWon(
            handler,
            EntityID.YouWon,
            EntityType.YouWon
        );

        leftGoal.setPlayer(leftPlayer);
        leftGoal.setOpponent(rightPlayer);
        rightGoal.setPlayer(rightPlayer);
        rightGoal.setOpponent(leftPlayer);

        leftPlayer.setGoal(leftGoal);
        rightPlayer.setGoal(rightGoal);

        leftPlayerScore.setPlayer(leftPlayer);
        rightPlayerScore.setPlayer(rightPlayer);

        entityManager.addEntity(net);
        entityManager.addEntity(ball);
        entityManager.addEntity(rightPlayer);
        entityManager.addEntity(leftGoal);
        entityManager.addEntity(rightGoal);
        entityManager.addEntity(leftPlayer);
        entityManager.addEntity(leftPlayerScore);
        entityManager.addEntity(rightPlayerScore);
        entityManager.addEntity(topWall);
        entityManager.addEntity(bottomWall);
        entityManager.addEntity(youWon);
    }

    public void buildWorld(Graphics g) {
        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0,  0,  handler.getWidth(), handler.getHeight());
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void incrementLevel() {
        currentLevel++;
    }

    public void resetLevel() {
        currentLevel = START_LEVEL;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

}
