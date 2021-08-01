package cz.cvut.fel.pjv.graphics.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
    protected BufferedImage texture;
    protected final int id;

    /**
     * @param texture a buffered image unique to each tile type.
     * @param id integer unique image id for each type of tile.
     */
    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
    }

    /**
     * Draw image tiles.
     *
     * @param g class object Graphics.
     * @param x the x coordinate in pixels of the upper left corner of the bounding rectangle of tile.
     * @param y the y coordinate in pixels of the upper left corner of the bounding rectangle of tile.
     */
    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /**
     * On the tile can pass.
     *
     * @return true, if it is impossible to move on the tile, it returns false if it is possible to move on the tile.
     */
    public boolean isSolid() { return false; }

    // Getters and setters
    public int getId() {
        return id;
    }
}
