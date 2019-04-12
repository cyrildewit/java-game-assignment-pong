package nl.cyrildewit.pong.state;

import java.awt.Graphics;

import nl.cyrildewit.engine.GameContainer;
import nl.cyrildewit.engine.state.State;
import nl.cyrildewit.pong.worlds.ClassicWorld;

public class GameState extends State {

	private ClassicWorld world;

	public GameState(GameContainer gc) {
		super(gc);

		world = new ClassicWorld(gc);
	}

	@Override
	public void update() {
		world.update();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
