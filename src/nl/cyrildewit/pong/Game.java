package nl.cyrildewit.pong;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import nl.cyrildewit.pong.display.Display;
import nl.cyrildewit.pong.input.KeyManager;
import nl.cyrildewit.pong.state.GameState;
import nl.cyrildewit.pong.state.MenuState;
import nl.cyrildewit.pong.state.State;

public class Game implements Runnable {

    private boolean dev = false;

	private Display display;
	public String title;
	public int width, height;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy displayBufferStrategy;
	private Graphics g;

	// State
	private State gameState;
	private State menuState;

	// Input
	private KeyManager keyManager;

	// Handler
	private Handler handler;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);

		handler = new Handler(this);

		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
	}

	private void tick() {
		keyManager.tick();

        if (State.getState() != null) {
        	State.getState().tick();
        }
	}

	private void render() {
		displayBufferStrategy = display.getCanvas().getBufferStrategy();

		if (displayBufferStrategy == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		g = displayBufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, width, height);

		if (State.getState() != null) {
        	State.getState().render(g);
        }

		displayBufferStrategy.show();
		g.dispose();
	}

	@Override
	public void run() {
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				if (dev) {
                    System.out.println("Ticks and Frames: " + ticks);
                }
                ticks = 0;
				timer = 0;
			}
		}

		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public synchronized void start() {
		if (running) {
			return;
		}

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (! running) {
			return;
		}

		running = false;

		try {
			thread.join();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
