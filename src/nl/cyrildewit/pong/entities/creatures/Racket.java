package nl.cyrildewit.pong.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.ID;

public class Racket extends Creature {

	public Racket(Handler handler, ID id, float x, float y) {
		super(handler, id, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

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

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (id.equals(ID.RacketOne)) {
			if (handler.getKeyManager().up) yMove = -speed;
			if (handler.getKeyManager().down) yMove = speed;
		}
		
		if (id.equals(ID.RacketTwo)) {
			if (handler.getKeyManager().aUp) yMove = -speed;
			if (handler.getKeyManager().aDown) yMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		// White racket
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, width, height);
	}

}
