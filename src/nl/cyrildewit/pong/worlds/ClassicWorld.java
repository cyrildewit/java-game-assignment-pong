package nl.cyrildewit.pong.worlds;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.creatures.Racket;
import nl.cyrildewit.pong.entities.statics.Ball;

public class ClassicWorld extends World {

	// Entities
	private EntityManager entityManager;

	public ClassicWorld(Handler handler) {
		super(handler);

		entityManager = new EntityManager(handler);

		entityManager.addEntity(new Racket(handler, 30, handler.getHeight() / 2));
		entityManager.addEntity(new Racket(handler, handler.getWidth() - 30, handler.getHeight() / 2));
		entityManager.addEntity(new Ball(handler, handler.getWidth() / 2, handler.getHeight() / 2, 10, 10));
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
 		BasicStroke bs = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{dashHeight}, 0);
		g2d.setColor(Color.white);
		g2d.setStroke(bs);
		g2d.drawLine(handler.getWidth() / 2, 0, handler.getWidth() / 2, handler.getHeight());
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
