package nl.cyrildewit.pong;

import java.awt.Graphics;

import nl.cyrildewit.engine.AbstractGame;
import nl.cyrildewit.engine.GameContainer;
import nl.cyrildewit.engine.state.State;
import nl.cyrildewit.pong.state.GameState;

public class GameManager extends AbstractGame
{
    private State gameState;

    public void initialize(GameContainer gc)
    {
        gameState = new GameState(gc);
    }

    @Override
    public void update(GameContainer gc) {
        gameState.update();
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        gameState.render(g);
    }

}
