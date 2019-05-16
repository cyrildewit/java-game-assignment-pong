package nl.cyrildewit.pong.entities.statics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.EntityID;
import nl.cyrildewit.pong.entities.EntityType;
import nl.cyrildewit.pong.entities.movables.Player;
import nl.cyrildewit.pong.gfx.FontAssets;

public class GameStats extends StaticEntry {

    protected Color textColor;
    protected Font bitFont;
    protected int stringWidth = 0;
    protected Player player;

    public GameStats(Handler handler, EntityID id, EntityType type, float x, float y) {
        super(handler, id, type, x, y, 0, 0);

        textColor = Color.WHITE;

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;

        bitFont = FontAssets.smallSizeMessage;
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

        // String lostsMsg = "Lots: " + Integer.toString(player.getLosts());
        String winsMsg = "Wins: " + Integer.toString(player.getWins());

        g2d.drawString(winsMsg, x, y);

        // g2d.drawString(winsMsg, x, y + 30);

        stringWidth = g.getFontMetrics().stringWidth(winsMsg);
    }

    public int getStringWidth() {
        return stringWidth;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
