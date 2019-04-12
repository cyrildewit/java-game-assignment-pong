package nl.cyrildewit.pong.entities.movables;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import nl.cyrildewit.engine.GameContainer;
import nl.cyrildewit.engine.entities.MovableEntity;
import nl.cyrildewit.pong.entities.ID;

public class Ball extends MovableEntity {

    private int diameter;
    private Random random;

	public Ball(GameContainer gc, float x, float y, int diameter) {
		super(gc, x, y, diameter, diameter);

        random = new Random();

        this.diameter = diameter;

        bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;

        // Set default movement
        xMove = yMove = speed;
        yMove = 3;
        // TODO: different angles (maybe using cos or sin)
        // xMove = speed;
        // yMove = 1 + random.nextFloat() * (max - min);
	}

	@Override
	public void update() {
        move();
	}

	@Override
	public void render(Graphics g) {
		// White ball
		g.setColor(Color.white);
		g.fillOval((int) x, (int) y, (int) height, (int) width);
	}

}
