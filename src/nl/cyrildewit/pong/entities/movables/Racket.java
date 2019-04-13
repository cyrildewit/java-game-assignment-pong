package nl.cyrildewit.pong.entities.movables;

import java.awt.Color;
import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.input.keysets.KeySet;

public class Racket extends MovableEntity {

    public static final int DEFAULT_RACKET_WIDTH = 14,
                            DEFAULT_RACKET_HEIGHT = 80;

    protected KeySet inputKeySet;

	public Racket(Handler handler, EntityType type, KeySet inputKeySet, float x, float y) {
		super(handler, type, x, y, DEFAULT_RACKET_WIDTH, DEFAULT_RACKET_HEIGHT);

		this.inputKeySet = inputKeySet;

        bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;
	}

	@Override
	public void tick() {
        getInput();
        move();
	}

	@Override
	public void render(Graphics g) {
        // White racket
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, width, height);
    }

    private void getInput() {
		yMove = 0;

		if (inputKeySet.up()) yMove = -speed;
		if (inputKeySet.down()) yMove = speed;
	}

}
