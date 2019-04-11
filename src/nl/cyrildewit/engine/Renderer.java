package nl.cyrildewit.engine;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.DataBufferInt;

public class Renderer
{
    private GameContainer gc;
    private BufferStrategy bs;
    private Graphics g;

    public Renderer(GameContainer gc)
    {
        this.gc = gc;

        bs = gc.getWindow().getCanvas().getBufferStrategy();
        g = bs.getDrawGraphics();
    }

    public void clear()
    {
        g.clearRect(0, 0, gc.getWidth(), gc.getHeight());
    }

    public Graphics getG()
    {
        return g;
    }
}
