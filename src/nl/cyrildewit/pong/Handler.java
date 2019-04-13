package nl.cyrildewit.pong;

import nl.cyrildewit.pong.display.Display;
import nl.cyrildewit.pong.input.Input;
import nl.cyrildewit.pong.worlds.World;

public class Handler {

    private Game game;
    private World world;

    public Handler(Game game) {
        this.game = game;
    }

    public Input getInput() {
        return game.getInput();
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public float getScale() {
        return game.getScale();
    }

    public String getTitle() {
        return game.getTitle();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Display getDisplay() {
        return game.getDisplay();
    }

}
