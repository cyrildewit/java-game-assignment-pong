package nl.cyrildewit.pong.helpers;

import java.awt.Font;
import java.awt.Graphics2D;
import java.io.File;

public class FontHelper {
    private static Graphics2D g2d;

    public static Font loadFont(String path, float size)
    {
        Font font;

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(size);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(path + " not loaded. Using serif font.");
            font = new Font("serif", Font.PLAIN, 24);
        }

        return font;
    }
}
