package com.cyrildewit.pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ID.PlayerOne) {
				if(key == KeyEvent.VK_W) tempObject.setVelY(-10);
				if(key == KeyEvent.VK_S) tempObject.setVelY(10);
			}

			if(tempObject.getId() == ID.PlayerTwo) {
				if(key == KeyEvent.VK_UP) tempObject.setVelY(-10);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(10);
			}
		}

		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ID.PlayerOne) {
				if(key == KeyEvent.VK_W) tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);
			}

			if(tempObject.getId() == ID.PlayerTwo) {
				if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
			}
		}
	}

}
