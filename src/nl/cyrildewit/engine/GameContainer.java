package nl.cyrildewit.engine;

import java.awt.Graphics;

import nl.cyrildewit.pong.state.GameState;
import nl.cyrildewit.pong.state.State;
import nl.cyrildewit.pong.worlds.World;

public class GameContainer implements Runnable
{
    private Thread thread;
    private Window window;
    private Renderer renderer;
    private KeyManager keyManager;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;
    private int width = 320, height = 240;
    private float scale = 1f;
    private String title;

	// State
	private State gameState;

    // World
    private World world;

    public World getWorld()
    {
        return world;
    }

    public void setWorld(World world)
    {
        this.world = world;
    }

    public GameContainer()
    {
        //
    }

    public synchronized void start()
    {
        // TEMP
        init();
        // ENDTEMP
        window = new Window(this);
        renderer = new Renderer(this);
        keyManager = new KeyManager();

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

    public void run()
    {
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

                // TODO: Update game

                keyManager.tick();
                if (State.getState() != null) {
                    State.getState().tick();
                }
                // ENDTODO
                if (frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
            }

            if (render) {
                // TODO: Render game
                renderer.clear();
                window.update();
                if (State.getState() != null) {
                    State.getState().render(g);
                }
                // ENDTODO
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

    private void init()
    {
		gameState = new GameState(this);
    	// menuState = new MenuState(this);
		State.setState(gameState);
	}

    private void dispose() {
        //
    }

    public Window getWindow()
    {
        return window;
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
