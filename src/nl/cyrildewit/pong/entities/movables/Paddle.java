package nl.cyrildewit.pong.entities.movables;

import java.awt.Color;
import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.input.keysets.KeySet;

public class Paddle extends MovableEntity {

    public static final int DEFAULT_RACKET_WIDTH = 14,
                            DEFAULT_RACKET_HEIGHT = 80;

    protected KeySet inputKeySet;

	public Paddle(Handler handler, EntityType type, KeySet inputKeySet, float x, float y) {
		super(handler, type, x, y, DEFAULT_RACKET_WIDTH, DEFAULT_RACKET_HEIGHT);

		this.inputKeySet = inputKeySet;

        bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;
	}

	@Override
	public void update() {
        //
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, width, height);
    }

}
