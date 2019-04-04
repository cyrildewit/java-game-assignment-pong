package com.cyrildewit.pong;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	private static final long serialVersionUID = 4201637014418202425L;

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);

		frame.add(game);
		frame.pack();

		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
		game.start();
	}
}
