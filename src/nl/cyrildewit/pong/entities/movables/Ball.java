package nl.cyrildewit.pong.entities.movables;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityType;

public class Ball extends MovableEntity {

    private int diameter;
    private Random random;

    public Ball(Handler handler, EntityType type, float x, float y, int diameter) {
        super(handler, type, x, y, diameter, diameter);

        random = new Random();

        this.diameter = diameter;

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
        g.setColor(Color.white);
        g.fillOval((int) x - (width / 2), (int) y - (height / 2), (int) height, (int) width);
    }

}
