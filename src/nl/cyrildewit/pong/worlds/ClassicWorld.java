package nl.cyrildewit.pong.worlds;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.ID;
import nl.cyrildewit.pong.entities.movables.Ball;
import nl.cyrildewit.pong.entities.movables.Player;
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

	public ClassicWorld(Handler handler) {
		super(handler);

		entityManager = new EntityManager(handler);
		
		playerOneKeySet = new PlayerOneKeySet(handler);
		playerTwoKeySet = new PlayerTwoKeySet(handler);
		
		initEntities();
	}

	public void tick() {
		entityManager.tick();
	}

	public void render(Graphics g) {
		buildWorld(g);

		entityManager.render(g);
	}
	
	public void initEntities() {
		int centerX = handler.getWidth() / 2;
		int centerY = handler.getHeight() / 2;

		playerOne = new Player(handler, ID.PlayerOne, playerOneKeySet, 30, handler.getHeight() / 2);
		playerTwo = new Player(handler, ID.PlayerTwo, playerTwoKeySet, handler.getWidth() - 30, handler.getHeight() / 2);
		
		Goal leftGoal = new Goal(handler, ID.PlayerOneGoal, 0, 0, 0, handler.getHeight());
		Goal rightGoal = new Goal(handler, ID.PlayerTwoGoal, handler.getWidth(), 0, 5, handler.getHeight());

		entityManager.addEntity(leftGoal);
		entityManager.addEntity(rightGoal);
		
		entityManager.addEntity(playerOne);
		entityManager.addEntity(playerTwo);
		entityManager.addEntity(new Ball(handler, ID.Ball, centerX, random.nextInt(centerY), 15));
	}

	public void buildWorld(Graphics g) {
		// Background
		g.setColor(Color.black);
		g.fillRect(0,  0,  handler.getWidth(), handler.getHeight());

		// Net
		Graphics2D g2d = (Graphics2D)g;
		float dashHeight = (float) handler.getHeight() / 20;
 		BasicStroke bs = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{dashHeight}, 0);
		g2d.setColor(Color.white);
		g2d.setStroke(bs);
		g2d.drawLine(handler.getWidth() / 2, 0, handler.getWidth() / 2, handler.getHeight());
		g2d.setStroke(new BasicStroke());
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
