package nl.cyrildewit.pong;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import nl.cyrildewit.pong.window.Window;
import nl.cyrildewit.pong.input.KeyManager;
import nl.cyrildewit.pong.state.GameState;
import nl.cyrildewit.pong.state.State;

public class GameContainer implements Runnable
{
    private Thread thread;
    private Window window;
    private Renderer renderer;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;
    private int width = 320, height = 240;
    private float scale = 1f;
    private String title;

    private BufferStrategy displayBufferStrategy;
	private Graphics g;

	// State
	private State gameState;

	// Input
	private KeyManager keyManager;

	// Handler
	private Handler handler;

    public GameContainer()
    {
		//
    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()
    {
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
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
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    private void init()
    {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);

		handler = new Handler(this);

		gameState = new GameState(handler);
//		menuState = new MenuState(handler);
		State.setState(gameState);
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

    private void dispose() {
        //
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
