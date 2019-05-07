package nl.cyrildewit.pong.entities.statics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.gfx.FontAssets;

public class GoToNextLevel extends StaticEntry {

    protected Color textColor;
    protected Font bitFont;

    public GoToNextLevel(Handler handler, EntityID id, EntityType type) {
        super(handler, id, type, 0, 0, 0, 0);

        textColor = Color.WHITE;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;

        bitFont = FontAssets.playerScoreFont;
    }

    @Override
    public void update() {
        //
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(textColor);

        g.setFont(bitFont);

        g2d.drawString("Press space to continue playing", x, y);
    }

}
