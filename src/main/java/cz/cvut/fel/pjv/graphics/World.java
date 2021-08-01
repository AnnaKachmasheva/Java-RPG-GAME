package cz.cvut.fel.pjv.graphics;

import cz.cvut.fel.pjv.entities.dynamics.Player;
import cz.cvut.fel.pjv.entities.EntityManager;
import cz.cvut.fel.pjv.entities.dynamics.Spider;
import cz.cvut.fel.pjv.entities.statics.Bush;
import cz.cvut.fel.pjv.entities.statics.Chest;
import cz.cvut.fel.pjv.entities.statics.Tree;
import cz.cvut.fel.pjv.graphics.tiles.GrassTile;
import cz.cvut.fel.pjv.graphics.tiles.Tile;
import cz.cvut.fel.pjv.graphics.tiles.WaterTile;
import cz.cvut.fel.pjv.inventory.ItemManager;
import cz.cvut.fel.pjv.main.Handler;
import cz.cvut.fel.pjv.utils.Util;

import java.awt.*;

public class World {

    private Handler handler;
    private EntityManager entityManager;

    //For a map, there are number of tiles in width/height;
    private int width, height;

    // The coordinates of the player's position at the start of the game in pixels.
    private int spawnX, spawnY;

    private ItemManager itemManager;

    // Arrays tiles layers.
    private int[][] tilesArrayLayerFirst, tilesArrayLayerSecond;

    public World() {}

    /**
     * @param handler class object Handler.
     * @param path string path to a text file containing data about the world.
     */
    public World(Handler handler, String path) {
        this.handler = handler;

        entityManager = new EntityManager(handler, new Player(handler,spawnX,spawnY));
        itemManager = new ItemManager(handler);

        loadWorld(path); // Loading the world.
        loadWStaticChests(); // Loading chests.

        // Spider creation
        entityManager.addEntityDynamic(new Spider(handler, 500,510));
        entityManager.addEntityDynamic(new Spider(handler, 550,520));
        entityManager.addEntityDynamic(new Spider(handler, 570,530));
        entityManager.addEntityDynamic(new Spider(handler, 430,540));
        entityManager.addEntityDynamic(new Spider(handler, 600,550));
        entityManager.addEntityDynamic(new Spider(handler, 400,560));
        entityManager.addEntityDynamic(new Spider(handler, 2000,300));
        entityManager.addEntityDynamic(new Spider(handler, 2000,320));
        entityManager.addEntityDynamic(new Spider(handler, 2000,340));
        entityManager.addEntityDynamic(new Spider(handler, 2000,360));
        entityManager.addEntityDynamic(new Spider(handler, 2000,500));
        entityManager.addEntityDynamic(new Spider(handler, 500,1280));
        entityManager.addEntityDynamic(new Spider(handler, 520,1280));
        entityManager.addEntityDynamic(new Spider(handler, 540,1280));
        entityManager.addEntityDynamic(new Spider(handler, 560,1280));

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

        loadWStaticTree(); // Loading tree.
        loadWStaticBush(); // Loading bush.
    }

    /**
     * Renewal of the world. The update rate is set in the class Game.
     */
    public void update() {
        itemManager.update();
        entityManager.update();
    }

    /**
     * Updating the display of the world layer 1 on screen. Rendering rate is set in the class Game.
     *
     * @param g class object Graphics.
     */
    public void renderLayerFirst(Graphics g) {
        int xStart = (int) Math.max(0,handler.getCamera().getxOffSet() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.max(width,(handler.getCamera().getxOffSet() + handler.getWidth())/Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0,handler.getCamera().getyOffSet() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.max(height,(handler.getCamera().getyOffSet() + handler.getHeight())/Tile.TILE_HEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTileFirstLayer(y,x).render(g,(int)(x * Tile.TILE_HEIGHT - handler.getCamera().getxOffSet()),
                        (int)(y * Tile.TILE_WIDTH - handler.getCamera().getyOffSet()));
            }
        }
    }

    /**
     * Updating the display of the world layer 2 on screen. Rendering rate is set in the class Game.
     *
     * @param g class object Graphics
     */
    public void renderLayerSecond(Graphics g) {
        int xStart = (int) Math.max(0,handler.getCamera().getxOffSet() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.max(width,(handler.getCamera().getxOffSet() + handler.getWidth())/ Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0,handler.getCamera().getyOffSet() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.max(height,(handler.getCamera().getyOffSet() + handler.getHeight())/ Tile.TILE_HEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                if (getTileSecondLayer(y,x) != null)
                    getTileSecondLayer(y,x).render(g,(int)(x * Tile.TILE_HEIGHT - handler.getCamera().getxOffSet()),
                        (int)(y * Tile.TILE_WIDTH - handler.getCamera().getyOffSet()));
            }
        }

        // On top of the second layer are depicted items and entities.
        itemManager.render(g);
        entityManager.render(g);
    }

    /**
     * Returns a tile by column and row number from a two-dimensional array.
     *
     * @param x horizontal tile number.
     * @param y vertical tile number.
     * @return an object of class Tile by number horizontally and vertically.
     */
    public Tile getTileFirstLayer(int x, int y) {
        if(x < 0 || y < 0 || y >= width || x >= height) return new WaterTile(14);
        return getTileById(tilesArrayLayerFirst[y][x]);
    }

    /**
     * Returns a tile by column and row number from a two-dimensional array.
     *
     * @param x horizontal tile number.
     * @param y vertical tile number.
     * @return an object of class Tile by number horizontally and vertically.
     */
    public Tile getTileSecondLayer(int x, int y) {
        if(x < 0 || y < 0 || y >= width || x >= height) return new WaterTile(14);
        else if (tilesArrayLayerSecond[y][x] == 4) return null;
        else return getTileById(tilesArrayLayerSecond[y][x]);
    }

    /**
     * Checks to which group of tiles the received identifier belongs to and returns a tile based on it.
     *
     * @param id unique tile identifier.
     * @return a tile by its id by number horizontally and vertically.
     */
    public Tile getTileById(int id) {
        if ((id >= 1 && id <= 13) || (id >= 30 && id <= 36)) return new GrassTile(id);
        else if (id >= 14 && id <= 29) return new WaterTile(id);
        return new WaterTile(14);
    }

    /**
     * Loading world data from a file.
     *
     * @param path a string containing the path to the text file world.txt.
     */
    public void loadWorld(String path){
        String file = Util.loadFileAsString(path);
        String[] tokens = file.split("\\s+");

        width = Util.parseInt(tokens[0]);
        height = Util.parseInt(tokens[1]);
        spawnX = Util.parseInt(tokens[2]);
        spawnY = Util.parseInt(tokens[3]);

        tilesArrayLayerFirst = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tilesArrayLayerFirst[x][y] = Util.parseInt(tokens[(x + y * width + 4)]);
            }
        }
        tilesArrayLayerSecond = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tilesArrayLayerSecond[x][y] = Util.parseInt(tokens[(height * width + x + y * width + 4)]);
            }
        }
    }

    /**
     * Loading trees data from a file.
     */
    public void loadWStaticTree() {
        String file = Util.loadFileAsString("/files/tree.txt");
        String[] tokens = file.split("\\s+");
        int i = 0, x = 0, y = 0;
        for (String t: tokens) {
            i++;
            if (i == 1) x = Util.parseInt(t);
            else {
                y = Util.parseInt(t);
                entityManager.addEntityStatic(new Tree(handler, x, y));
                i = 0;
            }
        }
    }

    /**
     * Loading bushes data from a file.
     */
    public void loadWStaticBush() {
        String file = Util.loadFileAsString("/files/bush.txt");
        String[] tokens = file.split("\\s+");
        int i = 0, x = 0, y = 0;
        for (String t: tokens) {
            i++;
            if (i == 1) x = Util.parseInt(t);
            else {
                y = Util.parseInt(t);
                entityManager.addEntityStatic(new Bush(handler, x, y));
                i = 0;
            }
        }
    }

    /**
     * Loading chests data from a file.
     */
    public void loadWStaticChests() {
        String file = Util.loadFileAsString("/files/chest.txt");
        String[] tokens = file.split("\\s+");
        int i = 0, x = 0, y = 0;
        for (String t: tokens) {
            i++;
            if (i == 1) x = Util.parseInt(t);
            else {
                y = Util.parseInt(t);
                entityManager.addEntityChest(new Chest(handler, x, y));
                i = 0;
            }
        }
    }

    // Getters and Setters
    public EntityManager getEntityManager() { return entityManager; }

    public ItemManager getItemManager() { return itemManager; }

    public Handler getHandler() { return handler; }

    public void setHandler(Handler handler) { this.handler = handler; }
}
