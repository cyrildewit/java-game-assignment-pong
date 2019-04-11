package nl.cyrildewit.pong;

import com.sun.glass.events.KeyEvent;

import nl.cyrildewit.engine.AbstractGame;
import nl.cyrildewit.engine.GameContainer;
import nl.cyrildewit.engine.Renderer;
import nl.cyrildewit.engine.state.State;
import nl.cyrildewit.engine.worlds.World;
import nl.cyrildewit.pong.state.GameState;

public class GameManager extends AbstractGame
{
    private State gameState;

    public GameManager()
    {
        gameState = new GameState(gc);
    }

    @Override
    public void update(GameContainer gc, float dt) {
        gameState.update();
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        gameState.render(r);
    }

}
