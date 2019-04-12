package nl.cyrildewit.pong;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import nl.cyrildewit.pong.display.Display;
import nl.cyrildewit.pong.input.KeyManager;
import nl.cyrildewit.pong.state.GameState;
import nl.cyrildewit.pong.state.State;

public class Game implements Runnable
{
    private Thread thread;
    private Display display;
    private KeyManager keyManager;

    private BufferStrategy displayBufferStrategy;
    private Graphics g;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;
    private int width = 320, height = 240;
    private float scale = 1f;
    private String title;

	private State gameState;
	private Handler handler;

    public Game(String title, int width, int height)
    {
		this.title = title;
		this.width = width;
		this.height = height;
    }

    public synchronized void start()
    {
        display = new Display(title, width, height);
        keyManager = new KeyManager();
        display.getFrame().addKeyListener(keyManager);
        handler = new Handler(this);

        gameState = new GameState(handler);
        State.setState(gameState);

        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()
    {
        //
    }

    public void run() {
        running = true;

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while (running) {
            render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= UPDATE_CAP) {
                unprocessedTime -= UPDATE_CAP;
                render = true;

                tick();

                if (frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
            }

            if (render) {
                render();

                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        dispose();
    }

    private void dispose() {
        //
    }

    private void tick()
    {
		keyManager.tick();

        if (State.getState() != null) {
        	State.getState().tick();
        }
	}

    private void render()
    {
		displayBufferStrategy = display.getCanvas().getBufferStrategy();

		if (displayBufferStrategy == null) {
			display.getCanvas().createBufferStrategy(2);
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

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
