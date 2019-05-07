package nl.cyrildewit.pong.entities.statics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.gfx.FontAssets;

public class YouLost extends StaticEntry {

    protected Color textColor;
    protected Font bitFont;
    protected int stringWidth = 0;

    public YouLost(Handler handler, EntityID id, EntityType type) {
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

        g2d.drawString("You Lost!", x, y);

        stringWidth = g.getFontMetrics().stringWidth("You Lost!");
    }

    public int getStringWidth() {
        return stringWidth;
    }

}
