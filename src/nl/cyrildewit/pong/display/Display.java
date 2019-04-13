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
        frame.setSize(s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}

}
