package nl.cyrildewit.pong.worlds;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import nl.cyrildewit.engine.GameContainer;
import nl.cyrildewit.engine.worlds.World;
import nl.cyrildewit.engine.entities.EntityManager;
import nl.cyrildewit.pong.entities.ID;
import nl.cyrildewit.pong.entities.movables.Ball;
import nl.cyrildewit.pong.entities.Player;
import nl.cyrildewit.pong.entities.statics.Goal;
import nl.cyrildewit.pong.input.keysets.KeySet;
import nl.cyrildewit.pong.input.keysets.PlayerOneKeySet;
import nl.cyrildewit.pong.input.keysets.PlayerTwoKeySet;

public class ClassicWorld extends World {

	// Entities
	private EntityManager entityManager;

	private Random random = new Random();

	private Player playerOne, playerTwo;
	private KeySet playerOneKeySet, playerTwoKeySet;

	public ClassicWorld(GameContainer gc) {
		super(gc);

		entityManager = new EntityManager(gc);

		playerOneKeySet = new PlayerOneKeySet(gc);
		playerTwoKeySet = new PlayerTwoKeySet(gc);

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
		int centerX = gc.getWidth() / 2;
		int centerY = gc.getHeight() / 2;

		playerOne = new Player(gc, playerOneKeySet, 30, gc.getHeight() / 2);
		playerTwo = new Player(gc, playerTwoKeySet, gc.getWidth() - 30, gc.getHeight() / 2);

		Goal leftGoal = new Goal(gc, 0, 0, 0, gc.getHeight());
		Goal rightGoal = new Goal(gc, gc.getWidth(), 0, 5, gc.getHeight());

		entityManager.addEntity(leftGoal);
		entityManager.addEntity(rightGoal);

		entityManager.addEntity(playerOne);
		entityManager.addEntity(playerTwo);
		entityManager.addEntity(new Ball(gc, centerX, random.nextInt(centerY), 15));
	}

	public void buildWorld(Graphics g) {
		// Background
		g.setColor(Color.black);
		g.fillRect(0,  0,  gc.getWidth(), gc.getHeight());

		// Net
		Graphics2D g2d = (Graphics2D)g;
		float dashHeight = (float) gc.getHeight() / 20;
 		BasicStroke bs = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{dashHeight}, 0);
		g2d.setColor(Color.white);
		g2d.setStroke(bs);
		g2d.drawLine(gc.getWidth() / 2, 0, gc.getWidth() / 2, gc.getHeight());
		g2d.setStroke(new BasicStroke());
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
