package nl.cyrildewit.pong.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.entities.movables.Player;

public class Goal extends StaticEntry {

    private Player player;
    private Player opponent;

    public Goal(Handler handler, EntityID id, EntityType type, float x, float y, int width, int height) {
        super(handler, id, type, x, y, width, height);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;
    }

    @Override
    public void update() {
        //
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int) (x + bounds.x), (int) (y + bounds.y), (int) bounds.width, (int) bounds.height);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

}
