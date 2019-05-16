package nl.cyrildewit.pong.entities.statics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.gfx.FontAssets;

public class YouWon extends StaticEntry {

    protected Color textColor;
    protected Font bitFont;
    protected int stringWidth = 0;
    protected int stringHeight = 0;

    public YouWon(Handler handler, EntityID id, EntityType type) {
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

        String msg = "You Won!";

        g2d.drawString(msg, x, y);
        stringWidth = g.getFontMetrics().stringWidth(msg);
        // stringHeight = g.getFontMetrics().stringHei
    }

    public int getStringWidth() {
        return stringWidth;
    }

    private Rectangle getStringBounds(Graphics2D g2, String str, float x, float y) {
        FontRenderContext frc = g2.getFontRenderContext();
        GlyphVector gv = g2.getFont().createGlyphVector(frc, str);
        return gv.getPixelBounds(null, x, y);
    }

}
