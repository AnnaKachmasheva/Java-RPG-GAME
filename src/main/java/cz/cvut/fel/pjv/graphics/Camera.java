package cz.cvut.fel.pjv.graphics;

import cz.cvut.fel.pjv.entities.Entity;
import cz.cvut.fel.pjv.graphics.tiles.Tile;
import cz.cvut.fel.pjv.main.Handler;

public class Camera {

    private Handler handler;

    private float xOffSet, yOffSet;

    /**
     * @param handler class object Handler.
     * @param xOffSet x offset in pixels from the top left corner of the map.
     * @param yOffSet y offset in pixels from the top left corner of the map.
     */
    public Camera(Handler handler, float xOffSet, float yOffSet) {
        this.handler = handler;
        this.xOffSet = xOffSet;
        this.yOffSet = yOffSet;
    }

    /**
     * Checking the map boundary.
     */
    public void checkMapBorder() {
        if(xOffSet < 0) {
            xOffSet = 0;
    } else if (xOffSet > 40 * Tile.TILE_WIDTH - handler.getWidth()) {
           xOffSet = 40 * Tile.TILE_WIDTH - handler.getWidth();
        }
        if(yOffSet < 0) {
            yOffSet = 0;
        } else if (yOffSet > 25 * Tile.TILE_HEIGHT - handler.getHeight()) {
            yOffSet = 25 * Tile.TILE_HEIGHT - handler.getHeight();
        }
    }

    /**
     * Centering the camera relative to the player's position.
     * Calling the method to check if the camera will go beyond the boundaries of the map.
     *
     * @param entity class object Entity.
     */
    public void centerOnEntity(Entity entity) {
        // Divide by 2 so that the player's character is in the center of the visible screen.
        xOffSet = (float)(entity.getX() + entity.getWidth() / 2 - handler.getWidth() / 2);
        yOffSet = (float)(entity.getY()+ entity.getHeight() / 2 - handler.getHeight() / 2);
        checkMapBorder();
    }

    // Getters and Setters
    public float getxOffSet() {
        return xOffSet;
    }

    public float getyOffSet() {
        return yOffSet;
    }
}
