package cz.cvut.fel.pjv.main;

import java.util.logging.*;

public class Main {

    // Class logger.
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    /**
     * Entry point to Java programs.
     *
     * @param args command line arguments and is an array of type java.lang.String class.
     */
    public static void main(String[] args) {
        Game game = new Game("My Game", 1280, 800); // Game window options.
        game.start(); // Start the game.

        // Configure own handlers.
        LOG.setUseParentHandlers(false);
        java.util.logging.Handler stdout = new StreamHandler(System.out, new SimpleFormatter()) {
            @Override
            public void publish(LogRecord record) {
                super.publish(record);
                flush();
            }
        };
        LOG.addHandler(stdout);
        LOG.setLevel(Level.INFO);
        stdout.setLevel(Level.ALL);
    }

    // Getters and setters
    public static Logger getLOG() {
        return LOG;
    }
}