package nl.cyrildewit.pong.gfx;

import java.awt.Font;

import nl.cyrildewit.pong.helpers.FontHelper;

public class FontAssets {
    public static Font playerScoreFont, middleSizeMessage;

    public static void initialize()
    {
        playerScoreFont = FontHelper.loadFont("fonts/bit5x3.ttf", 86);
        middleSizeMessage = FontHelper.loadFont("fonts/bit5x3.ttf", 28);
    }
}
