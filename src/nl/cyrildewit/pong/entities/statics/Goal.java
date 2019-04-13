package nl.cyrildewit.pong.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityType;

public class Goal extends StaticEntry {

    public Goal(Handler handler, EntityType type, float x, float y, int width, int height) {
        super(handler, type, x, y, width, height);

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

}
