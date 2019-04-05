package nl.cyrildewit.pong.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import nl.cyrildewit.pong.Handler;

public class Racket extends Creature {

	public Racket(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds = new Rectangle(0, 0, width, height);
	}

	@Override
	public void tick() {
		getInput();
		move();
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up) {
			yMove = -speed;
		}

		if (handler.getKeyManager().down) {
			yMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		// White racket
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, width, height);

//		g.setColor(Color.red);
//		g.fillRect((int) bounds.x, (int) bounds.y, width, height);
	}

}
