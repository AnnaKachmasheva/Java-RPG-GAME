package cz.cvut.fel.pjv.graphics;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private final String title;
    private final int width, height;

    /**
     * @param title the name of the game, displayed in the upper left corner of the window.
     * @param width game window width in pixels.
     * @param height game window height in pixels.
     */
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    /**
     * The method responsible for creating the window and canvas.
     */
    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // End the game by pressing the cross.
        frame.setResizable(false); // Prevents resizing of the window.
        frame.setLocationRelativeTo(null); // Positioning the window in the center of the screen.
        frame.setVisible(true); // Defines the visibility of the cadre at the screen.

        canvas = new Canvas();
        // Preferred, maximum and minimum canvas sizes.
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false); // Important! The only thing that a forum can have is this application.

        frame.add(canvas); // Adding a canvas to a frame.
        frame.pack(); // Resizes the frame to the smallest possible size.
    }

    // Getters and Setters
    public Canvas getCanvas() { return canvas; }

    public JFrame getFrame() { return frame; }
}
