package cz.cvut.fel.pjv.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;

    /**
     * @param sheet buffered image.
     */
    public SpriteSheet(BufferedImage sheet) { this.sheet = sheet; }

    /**
     * Returns only part of the image, crops it as a rectangle of the given dimensions.
     *
     * @param x the x-coordinate of the upper-left corner of the specified rectangular region in pixels.
     * @param y the y-coordinate of the upper-left corner of the specified rectangular region in pixels.
     * @param width  the width of the specified rectangular region in pixels.
     * @param height the height of the specified rectangular region in pixels.
     * @return bufferedImage cut on the borders of the rectangle.
     */
    public BufferedImage cropImage(int x, int y, int width, int height) {
        return sheet.getSubimage(x,y,width,height);
    }
}
