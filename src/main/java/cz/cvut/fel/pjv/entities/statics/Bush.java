package cz.cvut.fel.pjv.entities.statics;

import cz.cvut.fel.pjv.graphics.Assets;
import cz.cvut.fel.pjv.graphics.tiles.Tile;
import cz.cvut.fel.pjv.inventory.Item;
import cz.cvut.fel.pjv.main.Handler;
import cz.cvut.fel.pjv.main.Main;

import java.awt.*;
import java.util.Random;

public class Bush extends EntityStatic{

    /**
     * @param handler class object Handler.
     * @param x the x-coordinate in pixels of the upper-left corner of the rectangle of the bush image.
     * @param y the y-coordinate in pixels of the upper-left corner of the rectangle of the bush image.
     */
    public Bush(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, 1);
        // Rectangle for single collision
        bounds.x = 10;
        bounds.y = 34;
        bounds.width = 46;
        bounds.height = 16;
    }

    @Override
    public void update() {}

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bush, (int) (x - handler.getCamera().getxOffSet()),
                (int) (y - handler.getCamera().getyOffSet()), width, height, null);
    }

    @Override
    public void die() {
        Random rand = new Random();
        int count  = 1 + rand.nextInt(3); // After death, from 1 to 4 fruits can fall.
        for (int i = 0; i < count; i++) {
            handler.getWorld().getItemManager().addItem(Item.strawberryItem.createNew((int) x, (int) y));
        }
        Main.getLOG().info("Bush died. Dropped " + count +" strawberries.");
    }
}
