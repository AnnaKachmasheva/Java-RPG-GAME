package cz.cvut.fel.pjv.states;

import cz.cvut.fel.pjv.main.Handler;

import java.awt.*;

public abstract class State {

    private static State currentState = null; // Current state of the game.

    protected Handler handler;

    /**
     * @param handler class object Handler.
     */
    public State(Handler handler) {
        this.handler = handler;
    }

    /**
     * Updating the state. The update rate is set in the class Game.
     */
    public abstract void update();

    /**
     * Render the state. The render rate is set in the class Game.
     *
     * @param g class object Graphics.
     */
    public abstract void render(Graphics g);

    // Getters and Setters
    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }
}
