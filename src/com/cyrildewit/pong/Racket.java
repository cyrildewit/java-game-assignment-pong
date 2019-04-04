package com.cyrildewit.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Racket extends GameObject {

	public static final int WIDTH = 15, HEIGHT = 80;

	public Racket(int x, int y, ID id) {
		super(x, y, id);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		y = Game.clamp(y, 0, Game.HEIGHT - HEIGHT - 29);
	}



	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

//		g.setColor(Color.green);
//		g2d.draw(getBounds());

		g.setColor(Color.white);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

}
