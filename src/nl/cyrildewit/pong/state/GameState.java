package nl.cyrildewit.pong.state;

import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.worlds.ClassicWorld;

public class GameState extends State {

    private ClassicWorld world;

    public GameState(Handler handler) {
        super(handler);

        world = new ClassicWorld(handler);
        handler.setWorld(world);
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
