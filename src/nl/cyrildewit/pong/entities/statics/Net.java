package nl.cyrildewit.pong.entities.statics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityType;

public class Net extends StaticEntry {

    public Net(Handler handler, EntityID id, EntityType type, float x, float y, int width, int height) {
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
        Graphics2D g2d = (Graphics2D) g;

        float dash[] = { 16 };
        BasicStroke bs = new BasicStroke((float) width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1.0f, dash, 0);

        g2d.setColor(Color.WHITE);
        g2d.setStroke(bs);
        g2d.drawLine((int) x, (int) y, (int) x, (int) (y + height));

        // Reset stroke;
        g2d.setStroke(new BasicStroke());
    }

}
