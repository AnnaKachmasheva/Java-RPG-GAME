package cz.cvut.fel.pjv.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {

    /**
     * Loads images by path from folder resources.
     *
     * @param path the path to the image in the form of a string. The path starts from the folder resources.
     * @return the buffered image found in the received path.
     */
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path)); // Returns a buffered image object.
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); // If the image is not received, then the game will not be launched.
        }
        return null;
    }
}
