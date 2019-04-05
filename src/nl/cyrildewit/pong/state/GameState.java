package nl.cyrildewit.pong.state;

import java.awt.Graphics;

import nl.cyrildewit.pong.Game;
import nl.cyrildewit.pong.entities.creatures.Racket;

public class GameState extends State {

	private Racket racket;

	public GameState(Game game) {
		super(game);

		racket = new Racket(game, 100, 100);
	}

	@Override
	public void tick() {
		racket.tick();
	}

	@Override
	public void render(Graphics g) {
		racket.render(g);
	}

}
