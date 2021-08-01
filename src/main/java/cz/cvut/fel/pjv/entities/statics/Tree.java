package cz.cvut.fel.pjv.entities.statics;

import cz.cvut.fel.pjv.graphics.Assets;
import cz.cvut.fel.pjv.graphics.tiles.Tile;
import cz.cvut.fel.pjv.inventory.Item;
import cz.cvut.fel.pjv.main.Handler;
import cz.cvut.fel.pjv.main.Main;

import java.awt.*;
import java.util.Random;

public class Tree extends EntityStatic{

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH * 4/3, Tile.TILE_HEIGHT * 4/3, 1);

        // Rectangle for single collision
        bounds.x = 24;
        bounds.y = 50;
        bounds.width = 44;
        bounds.height = 20;
    }

    @Override
    public void update() {}

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, (int) (x - handler.getCamera().getxOffSet()),
                (int) (y - handler.getCamera().getyOffSet()), width, height, null);
    }

    @Override
    public void die() {
        Random rand = new Random();
        int count  = 1 + rand.nextInt(5);  // After death, from 1 to 5 fruits can fall
        for (int i = 0; i < count; i++) {
            handler.getWorld().getItemManager().addItem(Item.appleItem.createNew((int) x, (int) y));
        }
        Main.getLOG().info("Tree died. Dropped " + count + " apples.");
    }
}