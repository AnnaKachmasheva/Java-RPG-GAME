package cz.cvut.fel.pjv.graphics;

import java.awt.image.BufferedImage;

public class Animation {

    private int speed; // Time speed.
    private int index; // The index of the location of the image in the array images.
    private long timer = 0; // Time in nanoseconds that one image is displayed.
    private long lastTime; // Elapsed time.
    private BufferedImage[] images; // Array of images that make up the animation.

    /**
     * @param speed speed of changing 1 animation image in milliseconds.
     * @param images an array of buffered images with images to animate.
     */
    public Animation(int speed, BufferedImage[] images) {
        this.speed = speed;
        this.images = images;
        index = 0;
    }

    /**
     * The images are changed by a timer. This creates animation.
     */
    public void update() {
        timer += System.currentTimeMillis()  - lastTime;
        lastTime = System.currentTimeMillis();
        if(timer > speed) { // Changes the image to the next.
            index++;
            timer = 0;
            if(index >= images.length) { // Looping animation.
                index = 0;
            }
        }
    }

    /**
     * Returns an image by index from an array of images
     *
     * @return bufferedImage from an array images by location index in the array.
     */
    public BufferedImage getCurrentImages() {
        return images[index];
    }
}
