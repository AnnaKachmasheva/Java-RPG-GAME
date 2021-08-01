package cz.cvut.fel.pjv.ui;

import cz.cvut.fel.pjv.main.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class UIManager {

    private Handler handler;
    private List<UiObject> objects;

    /**
     * @param handler class object Handler.
     */
    public UIManager(Handler handler) {
        this.handler = handler;

        objects = new ArrayList<>();
    }

    /**
     * For each sheet object, call a method from the class UiObject.
     * */
    public void update() {
        for (UiObject object : objects) { object.update(); }
    }

    /**
     * Render UI objects.
     *
     * @param g lass object Graphics.
     */
    public void render(Graphics g) {
        for (UiObject object : objects) { object.render(g); }
    }

    /**
     * Adds a mouse event to the object (position of the cursor over the object).
     *
     * @param mouseEvent mouse event.
     */
    public void onMouseMove(MouseEvent mouseEvent) {
        for (UiObject object : objects) { object.onMouseMove(mouseEvent); }
    }

    /**
     * Adds a mouse event to the object (clickable).
     *
     * @param mouseEvent mouse event.
     */
    public void onMouseRelease(MouseEvent mouseEvent) {
        for (UiObject object : objects) { object.onMouseRelease(mouseEvent); }
    }

    // Adding an object to the list

    /**
     * Add new object in the ArrayList objects.
     *
     * @param object class object UIObject.
     */
    public void addObject(UiObject object) {
        objects.add(object);
    }

    // Getters and Setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
