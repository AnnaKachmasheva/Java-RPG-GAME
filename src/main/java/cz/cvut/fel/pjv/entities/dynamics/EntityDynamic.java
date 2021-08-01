package cz.cvut.fel.pjv.entities.dynamics;

import cz.cvut.fel.pjv.entities.Entity;
import cz.cvut.fel.pjv.graphics.tiles.Tile;
import cz.cvut.fel.pjv.main.Handler;

public abstract class EntityDynamic extends Entity {

    public static final float DEFAULT_SPEED = 1.0f;
    protected float speed; // Travel speed in pixels.
    protected float xMove, yMove; // Axis movement.

    /**
     * @param handler class object Handler.
     * @param x the x-coordinate in pixels of the upper-left corner of the rectangle of the dynamic entity image.
     * @param y the y-coordinate in pixels of the upper-left corner of the rectangle of the dynamic entity image.
     * @param width width in pixels of dynamic entity.
     * @param height height in pixels of dynamic entity.
     * @param health health of a dynamic entity in whole units.
     */
    public EntityDynamic(Handler handler, float x, float y, int width, int height, int health) {
        super(handler, x, y, width, height, health);
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    /**
     * Changing movement coordinates.
     */
    public void move() {
        if (checkEntityCollision(xMove, 0f)) moveX(); // If there was a movement (collision) along the x axis.
        if (checkEntityCollision(0f, yMove)) moveY(); // If there was a movement (collision) along the y axis.
    }

    /**
     * Moving right-left.
     */
    public void moveX() {
        // The right (xMove > 0) and left (xMove < 0) sides of the  entity' s rectangle are checked for collision.
        if (xMove > 0) {
            int positionX = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            // Check for collision of the upper right and lower right points of the right edge of the rectangle.
            if (collisionWithTile(positionX, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    collisionWithTile(positionX, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT))
                x += xMove;
        } else if (xMove < 0) {
            int positionX = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            // The upper left and lower left points of the left edge of the rectangle are checked for collision.
            if (collisionWithTile(positionX, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    collisionWithTile(positionX, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT))
                x += xMove;
        }
    }

    /**
     * Moving up-down.
     */
    public void moveY() {
        if(yMove < 0) {
            // The top (yMove > 0) and bottom (yMove < 0) edges of the creature's bounding rectangle are checked for collision.
            int positionY = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
            // Bottom-left and bottom-right points of the creature's rectangle are checked for collision.
            if(collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, positionY) &&
                    collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, positionY))
                y += yMove;
        } else if(yMove > 0) {
            int positionY = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
            // Top-left and top-right points of the  creature's rectangle are checked for collision.
            if(collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, positionY) &&
                    collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, positionY))
                y += yMove;
        }
    }

    /**
     * Checking collision between tiles and entities dynamic.
     * For movement to be possible, collisions should not be on both layers of the map.
     *
     * @param y horizontal tile number.
     * @param x vertical tile number.
     * @return true if a collision occurred, returns false if no collision occurred.
     */
    protected boolean collisionWithTile(int y, int x) {
        if (handler.getWorld().getTileSecondLayer(x, y) != null)
            return !handler.getWorld().getTileFirstLayer(x, y).isSolid()
                    && !handler.getWorld().getTileSecondLayer(x, y).isSolid();
        return !handler.getWorld().getTileFirstLayer(x, y).isSolid();
    }

    // Getters and setters
    public void setSpeed(float speed) { this.speed = speed; }
}
