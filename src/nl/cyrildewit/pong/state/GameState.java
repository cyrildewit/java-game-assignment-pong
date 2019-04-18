package nl.cyrildewit.pong.state;

import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.worlds.ClassicWorld;
import nl.cyrildewit.pong.worlds.TestWorld;
import nl.cyrildewit.pong.worlds.World;

public class GameState extends State {

    private World currentWorld;

    public GameState(Handler handler) {
        super(handler);

        ClassicWorld classicWorld = new ClassicWorld(handler);
        TestWorld testWorld = new TestWorld(handler);

        // currentWorld = testWorld;
        currentWorld = classicWorld;

        handler.setWorld(currentWorld);
    }

    @Override
    public void update() {
        currentWorld.update();
    }

    @Override
    public void render(Graphics g) {
        currentWorld.render(g);
    }

}
