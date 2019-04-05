package nl.cyrildewit.pong.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;

public class Ball extends StaticEntry {

	public Ball(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);

		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 0;
		bounds.height = 0;
	}

	@Override
	public void tick() {
        //
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, (int) height, (int) width);
	}

}
