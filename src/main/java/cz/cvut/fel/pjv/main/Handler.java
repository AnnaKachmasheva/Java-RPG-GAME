package cz.cvut.fel.pjv.main;

import cz.cvut.fel.pjv.graphics.Camera;
import cz.cvut.fel.pjv.graphics.World;

public class Handler {

    private Game game;
    private World world;

    public Handler() {}

    /**
     * @param game class object Game.
     */
    public Handler(Game game) { this.game = game; }

    // Getters and Setters
    public Camera getCamera() { return game.getCamera(); }

    public KeyManager getKeyManager() { return game.getKeyManager(); }

    public MouseManager getMouseManager() { return game.getMouseManager(); }

    public int getWidth() { return game.getWidth(); }

    public int getHeight() { return game.getHeight(); }

    public Game getGame() { return game; }

    public void setGame(Game game) { this.game = game; }

    public World getWorld() { return world; }

    public void setWorld(World world) { this.world = world; }
}
