package cz.cvut.fel.pjv.main;

import cz.cvut.fel.pjv.graphics.Assets;
import cz.cvut.fel.pjv.graphics.Camera;
import cz.cvut.fel.pjv.graphics.Display;
import cz.cvut.fel.pjv.states.GameState;
import cz.cvut.fel.pjv.states.MenuState;
import cz.cvut.fel.pjv.states.State;
import cz.cvut.fel.pjv.utils.LoadInventory;
import cz.cvut.fel.pjv.utils.Music;
import cz.cvut.fel.pjv.utils.Util;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.net.URL;


public class Game extends Handler implements Runnable {

    private final int width;
    private final int height;
    public String title;
    private Display display;

    private Thread thread;
    private boolean running = false; // Variable reflecting whether the game is running.

    // Game and menu states.
    public State gameState;
    public State menuState;

    // Input variable.
    private final KeyManager keyManager;
    private final MouseManager mouseManager;

    // Camera.
    private Camera camera;

    /**
     * @param title the name of the game, displayed in the upper left corner of the window.
     * @param width game window width in pixels.
     * @param height game window height in pixels.
     */
    public Game(String title, int width, int height) {
        //super();
        this.width = width;
        this.height = height;
        this.title = title;

        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    /**
     * Updating in the game loop.
     */
    private void update() {
        keyManager.update();

        // If the game is in one of the states, then the method of this state is called.
        if (State.getState() != null) State.getState().update();
    }

    /**
     * Rendering in a game loop.
     */
    private void render() {
        // Used to prevent image flickering.
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3); // 3 buffers are used when rendering images.
            return;
        }

        Graphics g = bs.getDrawGraphics(); // Creates a graphics context for the drawing buffer.
        g.clearRect(0, 0, width, height); // Clear Screen.
        g.fillRect(0, 0, width, height); // Creates a rectangle.

        // If the game is in one of the states, then the method of this state is called
        if (State.getState() != null) {
            State.getState().render(g);
        }

        // End drawing.
        bs.show();
        g.dispose();
    }

    /**
     * Executed when the start() method is applied to a Thread object.
     * Calling run() directly does not create a new thread.
     */
    public void run() {
        initialization();

        int fps = 60; // The number of replaced frames per unit of time.
        double timePerTick = 1000000000 / fps; // Time in nanoseconds of one frame change.
        double delta = 0; // Game loop number.
        long now; // How many time now.
        long lastTime = System.nanoTime(); // The current value of the system timer in nanoseconds.
        long timer = 0; // Elapsed time.

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick; // Number of frame changes over the last time interval.
            timer += now - lastTime;
            lastTime = now;

            // If need to execute at least one game loop.
            if (delta >= 1) {
                update();
                render();
                delta--;
            }

            // Updating the tickers and timer once per second.
            if (timer >= 1000000000) timer = 0;
        }

        stop(); // Stops the thread only when the variable running = false.
    }

    /**
     * Initializes all graphics in the game.
     */
    private void initialization() {
        display = new Display(title, width, height);
        // Adding listener for display.
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.initialization(); // Initializing buffered images.

        Handler handler = new Handler(this);
        camera = new Camera(this, 0, 0);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState); // Initial state of the game.

        // Loading saved player stats.
        LoadInventory.loadInventoryStart(handler.getWorld().getEntityManager().getPlayer());

        // Creating a path for play music.
        final URL url = Util.class.getResource("/"); // Getting the project path address.
        // Zero path check.
        if (url != null) {
            // Removing part of a line that refers to target.  Getting the full path of a text file.
            String pathUrl =  url.getPath().replace("target/classes/", "") +
                    "src/main/resources/music/fon.wav";

            Music.playSound(pathUrl); // Music initialization.
        }
    }

    /**
     * Creating a new thread.
     */
    public synchronized void start() {
        if (running) return; // Check if the game is running to avoid running the code below.
        running = true;
        thread = new Thread(this);
        thread.start(); // Starts execution of a new thread and calls the run() method.
    }

    /**
     * Will pause the execution of the current thread until another thread finishes its execution.
     */
    public synchronized void stop() {
        if (!running) return; // Checks if for some reason the game is already installed.
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Getters and Setters
    public KeyManager getKeyManager() { return keyManager; }

    public MouseManager getMouseManager() { return mouseManager; }

    public Camera getCamera() { return camera; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }
}