package nl.cyrildewit.pong.worlds;

import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;

public abstract class World {

    protected Handler handler;

    public World(Handler handler) {
        this.handler = handler;
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public abstract Object getEntityManager();

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}
