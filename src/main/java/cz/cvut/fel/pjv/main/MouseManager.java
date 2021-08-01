package cz.cvut.fel.pjv.main;

import cz.cvut.fel.pjv.ui.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private UIManager uiManager; // User interface manager.

    private boolean leftClick, rightClick; // Variables describing whether the right or left mouse button was pressed.
    private int xMouse, yMouse; // The coordinates of the cursor position in pixels.

    /**
     * Called immediately after the user presses the mouse button
     * while the cursor is over the listening component.
     *
     * @param mouseEvent event mouse.
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) { // If the right mouse button is pressed
            leftClick = true;
            Main.getLOG().fine("The right mouse button was pressed.");
        } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) { // If the left mouse button is pressed
            rightClick = true;
            Main.getLOG().fine("The left mouse button was pressed.");
        }
        if (uiManager != null) {
            uiManager.onMouseRelease(mouseEvent);
        }
    }

    /**
     * Called immediately after the user releases the mouse button after clicking on the listening component.
     *
     * @param mouseEvent event mouse.
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseEvent.BUTTON1) { // If the right mouse button is released
            leftClick = false;
        } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) { // If the left mouse button is released
            rightClick = false;
        }
        if(uiManager != null) {
            uiManager.onMouseRelease(mouseEvent); // Adding the ability to release the mouse from the object
        }
    }

    /**
     * Called just after the user clicks the listened-to component.
     *
     * @param mouseEvent event mouse.
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}

    /**
     * Called just after the cursor enters the bounds of the listened-to component.
     *
     * @param mouseEvent event mouse.
     */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    /**
     * Called just after the cursor exits the bounds of the listened-to component.
     *
     * @param mouseEvent event mouse.
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {}

    /**
     * Called in response to the user moving the mouse while holding a mouse button down.
     * This event is fired by the component that fired the most recent mouse-pressed event,
     * even if the cursor is no longer over that component.
     *
     * @param mouseEvent event mouse.
     */
    @Override
    public void mouseDragged(MouseEvent mouseEvent) {}

    /**
     * Called immediately if it is currently under the cursor.
     *
     * @param mouseEvent event mouse.
     */
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        xMouse = mouseEvent.getX();
        yMouse = mouseEvent.getY();

        Main.getLOG().fine("Cursor coordinates x: " + xMouse + " y: " + yMouse + ".");

        if(uiManager != null) {
            uiManager.onMouseMove(mouseEvent); //  Adding capability for motion event.
        }
    }

    // Getters and Setters
    public void setUiManager(UIManager uiManager) {this.uiManager = uiManager;}

    public boolean isLeftClick() {return leftClick;}

    public boolean isRightClick() {return rightClick;}

    public int getxMouse() {return xMouse;}

    public int getyMouse() {return yMouse;}
}