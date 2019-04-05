package nl.cyrildewit.pong.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.ID;

public class Ball extends StaticEntry {
	
	public static final float DEFAULT_SPEED = 5.0f;
	public static final int DEFAULT_BALL_WIDTH = 15,
							DEFAULT_BALL_HEIGHT = 15;
	
	protected float speed;
	protected float xMove, yMove;

	public Ball(Handler handler, ID id, float x, float y, int width, int height) {
		super(handler, id, x, y, width, height);

		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;
		
		speed = DEFAULT_SPEED;
		Random random = new Random();
		xMove = random.nextInt(20);
		yMove = random.nextInt(3);
	}

	@Override
	public void tick() {
		move();
	}

	@Override
	public void render(Graphics g) {
		// White ball
		g.setColor(Color.white);
		g.fillOval((int) x, (int) y, (int) height, (int) width);
	}
	
	public void move() {
		moveX();
		moveY();
		
//		if (! checkEntityCollision(xMove, 0f)) {
//			
//		}
//
//		if (! checkEntityCollision(yMove, 0f)) {
//			
//		}

	}

	public void moveX() {
		if (xMove < 0) { // Up
			if (x <= 0) {
				xMove *= -1;
			} else {
				x += xMove;
			}
		} else { // Down
			if (x >= handler.getWidth() - width) {
				xMove *= -1;
			} else {
				
				x += xMove;
			}
		}
	}

	public void moveY() {
		if (yMove < 0) { // Up
			if (y <= 0) {
				yMove *= -1;
			} else {
				
				y += yMove;
			}
		} else { // Down
			if (y >= handler.getHeight() - height) {
				yMove *= -1;
			} else {
				
				y += yMove;
			}
		}
	}

}
