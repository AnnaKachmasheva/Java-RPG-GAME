package cz.cvut.fel.pjv.ui;

import cz.cvut.fel.pjv.main.Main;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UiObject {

    protected float x, y;
    protected int width, height;

    protected Rectangle bounds; // Rectangle enclosing the interface object.
    protected boolean hovering = false; // If the mouse cursor is not under the desired object.

    /**
     * @param x the x-coordinate in pixels of the upper left corner of the bounding rectangle of uiObject.
     * @param y the y-coordinate in pixels of the upper left corner of the bounding rectangle of uiObject.
     * @param width width in pixels of uiObject.
     * @param height height in pixels of uiObject.
     */
    public UiObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle((int)x, (int)y, width, height); // The rectangle in which the button is located.
    }

    /**
     * Update UIObject.
     */
    public abstract void update();

    /**
     * Render UIObject.
     *
     * @param g class object Graphics.
     */
    public abstract void render(Graphics g);

    /**
     * A method describing events that occur after a mouse button is pressed from UIObject.
     */
    public abstract void onClick();

    /**
     * Determines if the mouse cursor is over the specified object with a rectangle
     *
     * @param mouseEvent mouse event.
     */
    public void onMouseMove(MouseEvent mouseEvent) {
        hovering = bounds.contains(mouseEvent.getX(), mouseEvent.getY());
        Main.getLOG().fine("Cursor from UIObject.");
    }

    /**
     *  If the cursor is over a given rectangle clickable
     *
     * @param mouseEvent mouse event
     */
    public void onMouseRelease(MouseEvent mouseEvent) {
        if(hovering) onClick();
    }

    // Getters and Setters
    public float getX() { return x; }

    public float getY() { return y; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public void setX(float x) { this.x = x; }

    public void setY(float y) { this.y = y; }

    public void setWidth(int width) { this.width = width; }

    public void setHeight(int height) { this.height = height; }
}
