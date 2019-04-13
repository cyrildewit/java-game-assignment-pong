package nl.cyrildewit.pong.state;

import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;

public abstract class State {

    protected Handler handler;

    private static State currentState = null;

    public State(Handler handler) {
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

}
