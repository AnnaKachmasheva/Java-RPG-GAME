package cz.cvut.fel.pjv.ui;

import cz.cvut.fel.pjv.main.Main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UiObject {

    private BufferedImage[] imageButton;
    private ClickListener ckickListener;

    /**
     * @param x the x-coordinate in pixels of the upper left corner of the bounding rectangle of button.
     * @param y the y-coordinate in pixels of the upper left corner of the bounding rectangle of button.
     * @param width width in pixels of button.
     * @param height height in pixels of button.
     * @param imageButton an array of buffered images of the button.
     * @param ckickListener interface object ClickListener.
     */
    public UIImageButton(float x, float y, int width, int height, BufferedImage[] imageButton, ClickListener ckickListener) {
        super(x, y, width, height);
        this.imageButton = imageButton;
        this.ckickListener = ckickListener;
    }

    @Override
    public void update() {}

    @Override
    public void render(Graphics g) {
        if(hovering) {
            g.drawImage(imageButton[1], (int) x, (int) y, width, height, null);
            Main.getLOG().fine("Cursor over the menu button.");
        } else {
            g.drawImage(imageButton[0], (int) x, (int) y, width, height, null);
        }
    }

    @Override
    public void onClick() { ckickListener.onClick(); }
}
