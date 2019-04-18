package nl.cyrildewit.pong.display;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import nl.cyrildewit.pong.Handler;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    public Display(Handler handler) {
        canvas = new Canvas();
        Dimension s = new Dimension((int) (handler.getWidth() * handler.getScale()), (int) (handler.getHeight() * handler.getScale()));
        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setMinimumSize(s);

        frame = new JFrame(handler.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setUndecorated(true);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setFocusable(false);

        canvas.requestFocus();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

}
