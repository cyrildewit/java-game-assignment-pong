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
import nl.cyrildewit.pong.input.keysets.KeySet;
import nl.cyrildewit.pong.input.keysets.PlayerOneKeySet;
import nl.cyrildewit.pong.input.keysets.PlayerTwoKeySet;

public class ClassicWorld extends World {

	// Entities
	private EntityManager entityManager;

	private Random random = new Random();

	public ClassicWorld(Handler handler) {
		super(handler);

		entityManager = new EntityManager(handler);

		int centerX = handler.getWidth() / 2;
		int centerY = handler.getHeight() / 2;

		KeySet playerOneKeySet = new PlayerOneKeySet(handler);
		KeySet playerTwoKeySet = new PlayerTwoKeySet(handler);

		Player playerOne = new Player(handler, ID.RacketOne, playerOneKeySet, 30, handler.getHeight() / 2);
		Player playerTwo = new Player(handler, ID.RacketTwo, playerTwoKeySet, handler.getWidth() - 30, handler.getHeight() / 2);

		entityManager.addEntity(playerOne);
		entityManager.addEntity(playerTwo);
		entityManager.addEntity(new Ball(handler, ID.Ball, centerX, random.nextInt(centerY), 15));
	}

	public void tick() {
		entityManager.tick();
	}

	public void render(Graphics g) {
		buildWorld(g);

		entityManager.render(g);
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
