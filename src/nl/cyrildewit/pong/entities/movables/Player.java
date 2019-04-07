package nl.cyrildewit.pong.entities.movables;

import java.awt.Color;
import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.ID;
import nl.cyrildewit.pong.input.keysets.KeySet;

public class Player extends MovableEntity {

    public static final int DEFAULT_PLAYER_WIDTH = 16,
                            DEFAULT_PLAYER_HEIGHT = 128;

    protected KeySet inputKeySet;

	public Player(Handler handler, ID id, KeySet inputKeySet, float x, float y) {
		super(handler, id, x, y, DEFAULT_PLAYER_WIDTH, DEFAULT_PLAYER_HEIGHT);

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
		// xMove = 0;
		yMove = 0;

		if (inputKeySet.up()) yMove = -speed;
		if (inputKeySet.down()) yMove = speed;
	}

}
