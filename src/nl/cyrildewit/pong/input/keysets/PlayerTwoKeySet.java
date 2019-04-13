package nl.cyrildewit.pong.input.keysets;

import java.awt.event.KeyEvent;

import nl.cyrildewit.pong.Handler;

public class PlayerTwoKeySet extends KeySet {

    public PlayerTwoKeySet(Handler handler) {
        super(handler);

        UP = KeyEvent.VK_UP;
        DOWN = KeyEvent.VK_DOWN;
    }

}
