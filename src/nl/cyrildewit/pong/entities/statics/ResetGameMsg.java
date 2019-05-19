package nl.cyrildewit.pong.entities.statics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.gfx.FontAssets;

public class ResetGameMsg extends StaticEntry {

    protected Color textColor;
    protected Font bitFont;
    protected int stringWidth = 0;

    public ResetGameMsg(Handler handler, EntityID id, EntityType type) {
        super(handler, id, type, 0, 0, 0, 0);

        textColor = Color.WHITE;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;

        bitFont = FontAssets.middleSizeMessage;
    }

    @Override
    public void update() {
        //
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, handler.getHeight() - 200, handler.getWidth(), 200);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(textColor);

        g.setFont(bitFont);

        String msg = "Press \"Y\" to reset the game";

        g2d.drawString(msg, x, y);
        stringWidth = g.getFontMetrics().stringWidth(msg);
    }

    public int getStringWidth() {
        return stringWidth;
    }

}
