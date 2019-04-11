package nl.cyrildewit.pong.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import nl.cyrildewit.engine.GameContainer;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.ID;

public class Ball extends StaticEntry {

	public static final float DEFAULT_SPEED = 5.0f;
	public static final int DEFAULT_BALL_WIDTH = 15,
							DEFAULT_BALL_HEIGHT = 15;

	protected float speed;
	protected float xMove, yMove;

	public Ball(GameContainer gc, ID id, float x, float y, int width, int height) {
		super(gc, id, x, y, width, height);

		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;

		speed = DEFAULT_SPEED;
        xMove = yMove = speed;
	}

	@Override
	public void tick() {
		move();
//		checkGoals();
	}

	@Override
	public void render(Graphics g) {
		// White ball
		g.setColor(Color.white);
		g.fillOval((int) x, (int) y, (int) height, (int) width);

		g.setColor(Color.green);
		g.drawOval((int) (x + bounds.x), (int) (y + bounds.y), (int) bounds.width, (int) bounds.height);

	}

	public void move() {
		if(checkCollisionWithGoal()) {
			System.out.println("Goal side: " + "left");
		}
		moveX();
		moveY();

//		if (checkCollisionWithRacket()) {
//			System.out.println("Collision with racket" + System.currentTimeMillis());
//		}

//		if (checkCollisionWithGoal()) {
//			System.out.println("Collision with goal" + System.currentTimeMillis());
//		}

//		if (checkEntityCollision(xMove, 0)) {
//			System.out.println("Col" + System.currentTimeMillis());
//		}
////
////		if (! checkEntityCollision(yMove, 0f)) {
////
////		}

	}

	public boolean checkCollisionWithGoal() {
		if (xMove < 0 && x <= 0) { // Up
			return true;
		} else if (xMove < 0  && x >= gc.getWidth() - width) {
			return true;
		}

		return false;
	}

//	public boolean checkCollisionWithRacket() {
//		EntityManager entityManager = (EntityManager) handler.getWorld().getEntityManager();
//
//		for(Entity e : entityManager.getEntities()) {
//			if(! e.equals(new Racket(handler, id, speed, speed)))
//				continue;
//			if(e.getCollisionBounds(0, 0).intersects(bounds)){
////				e.add(1);
////				System.out.println("Goalll");
//				return true;
//			}
//		}
//
//		return false;
//	}

	public void checkGoals() {
		if (x <= 0) {
//			System.out.println("Goalll");
		}
//		EntityManager entityManager = (EntityManager) handler.getWorld().getEntityManager();
//
//		for(Entity e : entityManager.getEntities()) {
//			if(e.equals(this))
//				continue;
//			if(e.getCollisionBounds(0, 0).intersects(bounds)){
////				e.add(1);
//				System.out.println("Goalll");
//				return;
//			}
//		}
	}

	public void moveX() {
		if (xMove < 0) { // Up
			if (x <= 0) { // Bounce the ball back
				xMove *= -1;
			} else {
				x += xMove;
			}
		} else { // Down
			if (x >= gc.getWidth() - width) { // Bounce the ball back
				xMove *= -1;
			} else {
				x += xMove;
			}
		}
	}

	public void moveY() {
		if (yMove < 0) { // Up
			if (y <= 0) { // Bounce the ball back
				yMove *= -1;
			} else {

				y += yMove;
			}
		} else { // Down
			if (y >= gc.getHeight() - height) { // Bounce the ball back
				yMove *= -1;
			} else {
				y += yMove;
			}
		}
	}

}
