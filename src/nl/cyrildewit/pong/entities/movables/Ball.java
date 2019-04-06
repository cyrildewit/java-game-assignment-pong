package nl.cyrildewit.pong.entities.movables;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.ID;
import nl.cyrildewit.pong.entities.creatures.Racket;

public class Ball extends MovableEntity {

    private int diameter;

	public Ball(Handler handler, ID id, float x, float y, int diameter) {
		super(handler, id, x, y, diameter, diameter);

        this.diameter = diameter;

        bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;

        // Set default movement
        xMove = yMove = speed;
	}

	@Override
	public void tick() {
		// Move the ball on every tick
        move();
	}

	@Override
	public void render(Graphics g) {
		// White ball
		g.setColor(Color.white);
		g.fillOval((int) x, (int) y, (int) height, (int) width);

        // TODO: temporary border that represents the bounds
        g.setColor(Color.green);
		g.drawOval((int) (x + bounds.x), (int) (y + bounds.y), (int) bounds.width, (int) bounds.height);
	}

}
