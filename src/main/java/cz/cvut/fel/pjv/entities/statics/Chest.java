package cz.cvut.fel.pjv.entities.statics;

import cz.cvut.fel.pjv.graphics.Assets;
import cz.cvut.fel.pjv.graphics.tiles.Tile;
import cz.cvut.fel.pjv.inventory.Item;
import cz.cvut.fel.pjv.main.Handler;
import cz.cvut.fel.pjv.main.Main;

import java.awt.*;
import java.util.Random;

public class Chest extends EntityStatic{

    /**
     * @param handler class object Handler.
     * @param x the x-coordinate in pixels of the upper-left corner of the rectangle of the chest image.
     * @param y the y-coordinate in pixels of the upper-left corner of the rectangle of the chest image.
     */
    public Chest(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH , Tile.TILE_HEIGHT, 1);
        // Rectangle for single collision
        bounds.x = 0;
        bounds.y = 40;
        bounds.width = 40;
        bounds.height = 20;
    }

    @Override
    public void update() {}

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.chestClosed, (int) (x - handler.getCamera().getxOffSet()),
                (int) (y - handler.getCamera().getyOffSet()), width, height, null);
    }

    @Override
    public void die() {
        Random rand = new Random();

        // Random drop of luck after death
        int count  = 1 + rand.nextInt(10);
        for (int i = 0; i < count; i++) {
            handler.getWorld().getItemManager().addItem(Item.potionRedItem.createNew((int)x,(int)y));
            handler.getWorld().getItemManager().addItem(Item.potionWhiteItem.createNew((int)x,(int)y));
            handler.getWorld().getItemManager().addItem(Item.potionBlueItem.createNew((int)x,(int)y));
        }
        count  =  rand.nextInt(2);
        for (int i = 0; i < count; i++) {
            handler.getWorld().getItemManager().addItem(Item.gloves1Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.gloves2Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.gloves3Item.createNew((int) x, (int) y));

            handler.getWorld().getItemManager().addItem(Item.weapon1Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.weapon2Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.weapon3Item.createNew((int) x, (int) y));

            handler.getWorld().getItemManager().addItem(Item.pants1Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.pants2Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.pants3Item.createNew((int) x, (int) y));

            handler.getWorld().getItemManager().addItem(Item.torso1Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.torso2Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.torso3Item.createNew((int) x, (int) y));

            handler.getWorld().getItemManager().addItem(Item.shield1Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.shield2Item.createNew((int) x, (int) y));

            handler.getWorld().getItemManager().addItem(Item.ringHealthItem.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.ringAttackItem.createNew((int) x, (int) y));

            handler.getWorld().getItemManager().addItem(Item.head1Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.head2Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.head3Item.createNew((int) x, (int) y));

            handler.getWorld().getItemManager().addItem(Item.amuletAttackItem.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.amuletHealthItem.createNew((int) x, (int) y));

            handler.getWorld().getItemManager().addItem(Item.boot1Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.boot2Item.createNew((int) x, (int) y));
            handler.getWorld().getItemManager().addItem(Item.boot3Item.createNew((int) x, (int) y));
        }
        Main.getLOG().info("The chest is open.");
    }
}
