package com.cyrildewit.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends GameObject {

	private Handler handler;

	public static final int WIDTH = 15, HEIGHT = 15;

	public Ball(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;

		velX = 5;
		velY = 5;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		if (y <= 0 || y >= Game.HEIGHT - HEIGHT) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - WIDTH) velX *= -1;

		collision();
	}

	public void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.PlayerOne) {
				if (getBounds().intersects(tempObject.getBounds())) {
					velY *= -1;
					velX *= -1;
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, HEIGHT, WIDTH);
	}

}
