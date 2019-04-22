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

public class PlayerScore extends StaticEntry {

    protected Color textColor;
    protected Font bitFont;
    protected Player player;

    public PlayerScore(Handler handler, EntityID id, EntityType type, float x, float y) {
        super(handler, id, type, x, y, 0, 0);

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

        String score = player != null ? Integer.toString(player.getScore()) : "0";

        g2d.drawString(score, x, y);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
