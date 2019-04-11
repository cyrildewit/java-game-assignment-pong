package nl.cyrildewit.engine;

import java.awt.Graphics;

public abstract class AbstractGame
{
    public abstract void initialize(GameContainer gc);

    public abstract void update(GameContainer gc);

    public abstract void render(GameContainer gc, Graphics g);

}
